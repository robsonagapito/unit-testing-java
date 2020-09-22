pipeline {
    agent any
    stages{
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }
        stage('Unit Testing') {
            steps {
                script {
                    sh 'mvn clean test'
                    junit '**/target/*.xml'
                }
            }
        }
        stage('Integration Testing') {
            steps {
                script {
                    sh 'git clone https://github.com/robsonagapito/integration-testing-java.git &&
                        cd integration-testing-java &&
                        mvn verify'
                    junit '**/target/*.xml'
                }
            }
        }
    }
}