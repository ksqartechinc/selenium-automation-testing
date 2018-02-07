#!/usr/bin/env groovys

pipeline {
    agent any

    stages {
        stage ('Clone') {
          steps {
            git url: 'https://github.com/ksqartechinc/selenium-automation-testing.git', branch: 'master'
          }
        }

        stage('Build') {
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


        stage('Test') {

          steps {
            // building the docker image
            sh '''
            set +e

            rm -rf test-output/
            rm Test_Execution_Report.html
            docker run --env SELENIUM_HUB=192.168.7.121 --name container-test infoloblabs/gap-oracle-selenium:latest || error=true

            docker cp container-test:/usr/share/tag/test-output/ .
            docker cp container-test:/Test_Execution_Report.html .

            docker rm -f container-test


            if [ $error ]
            then
            	exit -1
            fi
            '''

          }

        }

        // stage('Publishing') {
        //   steps {
        //
        //
        //   }
        //
        // }
        //
        // stage('Reporting Results') {
        //   steps {
        //
        //
        //   }
        //
        // }  
    }

}
