pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                script{
                    sh 'mvn clean install -DskipTest'
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }
        stage('Unit Testing'){
            steps {
                script{
                    sh 'mvn clean test'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}