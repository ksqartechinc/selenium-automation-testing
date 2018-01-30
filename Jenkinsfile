#!/usr/bin/env groovys

pipeline {
    agent any

    stages {
        stage ('Clone') {
          steps {
            git url: 'https://github.com/ksqartechinc/selenium-automation-testing.git', branch: 'master'
          }
        }

          // agent {
          //     docker {
          //         image 'maven:3-alpine'
          //         args '-v /root/.m2:/root/.m2'
          //         reuseNode true
          //     }
          // }
          tools {
            maven 'Maven 3.5.2'
          }

          steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'docker images'
                // CHK maybe targe will be loose after mvn clean package
                // stash will be required
          }
        }
}
