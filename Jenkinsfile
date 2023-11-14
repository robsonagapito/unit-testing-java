pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                script{
                    sh 'export M2_HOME=/maven && export PATH=$M2_HOME:$PATH'
                    sh 'mvn clean install -DskipTests -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8'
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }
        stage('Unit Testing'){
            steps {
                script{
                    sh 'mvn test -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Integration Testing') {
            steps {
                script {
                    sh 'if [ -d integration-testing-java ]; then rm -rf integration-testing-java; fi'
                    sh 'git clone https://github.com/robsonagapito/integration-testing-java.git'
                    sh 'cd integration-testing-java && git checkout gft && mvn verify -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8'
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