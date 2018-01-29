# selenium-automation-testing
This project will host Selenium automated tests that will be run inside a Docker container and the results of tests will be emailed.

- Selenium automated test should committed to the src directory
  - src/main/.../pages host automated test page configuration
  - src/test/.../test  host the actual test to run over the pages configured.

- Selenium automated tests then could be builded and a docker image will be created.

- With the selenium automated tests dockerized you can run the test in a container or even better a Jenkins instance can do it for you.

# How to use

## Selenium grid.
Creating the Selenium grid to run the Selenium test cases there. Having docker and docker-compose

```
docker-compose up -d

## to add more chrome or firefox selenium instances
docker-compose scale chrome=5

## and to shutdown the services
docker-compose down

```

You can access the selenium-grid console using [http://localhost:4444/grid/console](http://localhost:4444/grid/console)

## Jenkins

Jenkins server to have a job to pull the source code:

  - building the maven test project
  - building the docker image of the selenium test. (using  the dockerifle and maven docker plugin o with plain docker build commands, is up to you)
  - running the docker container to run the selenium test (with the previous image builded)
  - If all test passed it then the image is push to docker hub.

### Running the jenkins server
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
