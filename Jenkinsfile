pipeline {
    agent any
    stage('Build'){
        step {
            script{
                sh 'mvn clean install -DskipTest'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
    stage('Unit Testing'){
        step {
            script{
                sh 'mvn clean test'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

}