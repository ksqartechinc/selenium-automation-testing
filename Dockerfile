FROM openjdk:8-jre-slim
# Docker image base dir
ARG BASE_DIR=/usr/share/tag

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/container-test.jar $BASE_DIR/container-test.jar
ADD  target/libs $BASE_DIR/libs

# Add the suite xmls
ADD basic-flow-module.xml $BASE_DIR/basic-flow-module.xml

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/container-test.jar", "org.testng.TestNG", "/usr/share/tag/basic-flow-module.xml"]
