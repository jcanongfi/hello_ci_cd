pipeline {
    agent any
    stages {
        stage('Build') {
            agent {
              docker {
                image 'maven:3.3.3'
              }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
            }
        }
        stage('Test') {
           agent {
              docker {
                image 'maven:3.3.3'
              }
            }
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Image') {
            agent {
              docker {
                image 'docker:18.03-dind'
              }
            }
            steps {
                sh 'docker build -t mon_appli:latest .'
            }
        }
        stage('Push') {
            steps {
                sh 'sleep 10'
            }
        }
    }
}

