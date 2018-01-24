# selenium-automation-testing
This project will host Selenium automated tests that will be run inside a Docker container and the results of tests will be emailed.

- Selenium automated test should committed to the src directory
  - src/main/.../pages host automated test page configuration
  - src/test/.../test  host the actual test to run over the pages configured.

- Selenium automated tests then could be builded and a docker image will be created.

- With the selenium automated tests dockerized you can run the test in a container or even better a Jenkins instance can do it for you.
