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
          tools {
            maven 'Maven 3.5.2'
          }

          steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'docker images'

          }
        }

        stage('Test') {
          steps {
            sh '''
              set +e

              rm -rf test-output/
              rm -rf screenshots/
              rm Test_Execution_Report.html

              docker run --env SELENIUM_HUB=192.168.1.129 --name container-test infoloblabs/gap-oracle-selenium:latest || error=true

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
                  sh 'docker push infoloblabs/gap-oracle-selenium:latest'
              }
            }

          }

        }

    }
    post {
    success {
      script {

        def content =  readFile('test-output/emailable-report.html')

        emailext (
            mimeType: "text/html",
            to:"infoloblabs@gmail.com; seema.ahluwalia@infolob.com; girish.mallampalli@infolob.com",
            subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            attachmentsPattern: "screenshots/*.png, Test_Execution_Report.html",
            body: content
        )
      }

    }

    failure {
      script {
        def content =  readFile('test-output/emailable-report.html')

        emailext (
            to:"infoloblabs@gmail.com; seema.ahluwalia@infolob.com; girish.mallampalli@infolob.com",
            subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            attachmentsPattern: "screenshots/*.png, Test_Execution_Report.html",
            body: content
          )

      }
    }
  }
}
