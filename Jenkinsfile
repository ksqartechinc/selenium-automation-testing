#!/usr/bin/env groovys

pipeline {
    agent any

    stages {
        stage ('Clone') {
          steps {
            git url: 'https://github.com/ksqartechinc/selenium-automation-testing.git', branch: 'alpha'
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
            rm -rf screenshots/
            rm Test_Execution_Report.html

            docker run --env SELENIUM_HUB=192.168.1.129 --name container-test infoloblabs/gap-oracle-selenium:alpha || error=true

            docker cp container-test:/usr/share/tag/test-output/ .
            docker cp container-test:/Test_Execution_Report.html .
            docker cp container-test:/screenshots/ .

            docker rm -f container-test


            if [ $error ]
            then
            	exit -1
            fi
            '''

          }

        }

        stage('Publishing') {
          steps {
            script {
              docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                  sh 'docker push infoloblabs/gap-oracle-selenium:alpha'
              }
            }

          }

        }

        // stage('Reporting Results') {
        //   steps {
        //
        //
        //   }
        //
        // }
    }

}
