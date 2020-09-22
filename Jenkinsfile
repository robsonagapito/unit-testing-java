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
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Integration Testing') {
            steps {
                script {
                    sh 'git clone https://github.com/robsonagapito/integration-testing-java.git'
                    sh 'cd integration-testing-java'
                    sh 'mvn verify'
                    sh 'cd ..'
                }
            }
        }
        stage ('Cucumber Reports') {
            steps {
                    cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/CucumberReport.json",
                        jsonReportDirectory: 'integration-testing-java/target/reports'

            }
        }
    }
}