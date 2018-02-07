# selenium-automation-testing
This project takes Selenium automation tests code and run the tests
inside a Docker containera, using a selenium grid with chrome and firefox nodes.
The tests results reports (TestNG and extent) can be retrieved from the container.

- Selenium automation tests should committed to the src directory
  - src/main/.../pages host automated test page configuration
  - src/test/.../test  host the actual test to run over the pages configured.

# How to use

## Quick Start
Having installed Docker and docker-compose

```
docker-compose up
```
It will create the following containers

- selenium-hub : The selenium hub that will coordinate running the selenium test in parallel
in any of the nodes available (for this case chrome or firefox). Usually you can see
the Selenium Hub web ui when is running at http://localhost:4444/grid/console and nodes can subcribe to the hub at http://localhost:4444/wd/hub

- chrome/firefox nodes : The browser specific nodes where selenium tests can run.

- container-test : The container with the selenium tests compiled (using maven)
and ready to run. The docker image used to run this container is pulled from https://hub.docker.com/r/infoloblabs/gap-oracle-selenium/. As you can see you can
build your own image using the dockerfile in this solution or using the maven docker plugin
included at the pom.xml (just ```mvn clean package ```)

TestNG and extent result reports can be retrieved issuing some docker copy commands over the container-test

```
docker cp container-test:/usr/share/tag/test-output/ .
docker cp container-test:/Test_Execution_Report.html .  
```

## Raising your own Jenkins based Selenium CI/CD
If you want to build your own Selenium automation tests docker images in a CI/CD
way, you just need:

### Running the Selenium grid.

```
# selenium-grid/docker-compose.yml is the compose file to raise just selenium hub and node containers

docker-compose -f selenium-grid/docker-compose.yml up

## after running this command the second time you will need to remove the existing containers from the firs time
# docker rm $( docker ps -q -f status=exited)

## to add more chrome or firefox selenium instances
# docker-compose scale chrome=5
## and to shutdown the services
# docker-compose down
```
You can access the selenium-grid console using [http://localhost:4444/grid/console](http://localhost:4444/grid/console)

### Running Jenkins server to build your selenium test docker images from source code

Jenkins server to have a job to pull the source code and doing the follwing CI/CD steps:

  - building the maven test project
  - building the docker image of the selenium test. (using  the dockerifle
    and maven docker plugin or with plain docker build commands, is up to you)
  - running the docker container to run the selenium test (with the previous image builded)
  - If all test passed it then the image is pushed to docker hub.

- Running the jenkins server
```
  docker run \
  -u root \
  --rm \
  -d \
  -p 8080:8080 \
  -p 50000:50000 \
  -v jenkins-data:/var/jenkins_home \
  -v /var/run/docker.sock:/var/run/docker.sock \
  jenkinsci/blueocean

# if you what to have jenkins home at you local directory change -v jenkins-data... by  -v $HOME/jenkins:/var/jenkins_home

# docker logs jenkinsci/blueocean
# docker exec -it jenkinsci/blueocean bash

```
- Configuring and creating the Pipeline for the Selenium CI/CD
In order to have a Pipeline building Selenium automation tests and Docker images
 you would need to install the following Jenkins plugins
  - Pipeline multibranch
  - Pipeline
  - Maven
  - Github to retrieve your code hosted at githug
  - Docker Pipeline
  - Email Extension

- Creating the Selenium pipeline
  - At Jenkins cick on New Item
  - Enter the name you want and select Multibranch Pipeline and click OK
  - At Branch sources select and add Git as source
  - At the Project repository field enter the url of you github project (i.e https://github.com/ksqartechinc/selenium-automation-testing.git)
  - At Building configuration at the mode drop down select By Jenkinsfile
  - should see the pipeline just created. If not try clicking at "Scan Multibranch Pipeline now"
  - after that it should list the branches founded in your github repository.
  - Select one branch and click the "Build Now" at the left side panel
  - Jenkins will pull your repository and run through the stages defined at the Jenkinsfile (see the Jenkinfile of this repository to get an idea)

 - Using the Jenkinsfile
 The Jenkinsfile in this project (still in progress) does simple integration steps
 like pulling the source code, using maven build the jar and docker images and
 finally run a docker container with image just created by the build step.

 As container-test requires a selenium node in order to run the selenium test, \
 you need to specify the IP address for the Selenium Hub host, if you are Running
 your selenium locally you can set this as follow:

 - Getting you ip address
  Using mac: ```ifconfig```
  Take the ip address listed at the en0 interface that should looks like ```inet 192.168.x.x```
 - Setting the Selium Hub address at the Jenkinsfile
 Edit the jenkinsfile and at the Test stage replace the SELENIUM_HUB value with the one of you ip addrees
  ```docker run --env SELENIUM_HUB=YOU_LOCAL_IPADDRESS --name container-test infoloblabs/gap-oracle-selenium:latest || error=true
  ```

You can even run the container without Jenkins
```
  docker build
  docker run -e SELENIUM_HUB=192.168.7.121 --name container-test YOU_DTR_REPO/YOUR_IMAGE_NAME
```

The TestNG and Extent reports can retrieved also using docker copy commads.

# Next steps
 - Adding Docker Publishing capabilities to the Jenkisfile/Pipeline, i.e binding your docker hub credentials in order to docker push the images created at the pipeline.
 - Email the TestNG results and Extent Reports, i.e configure the Jenkinsfile/pipeline to email the TestNG results and attach Extent Reports
