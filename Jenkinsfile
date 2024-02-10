pipeline {
    agent any

    stages {
        stage('Compile and clean') {
            steps {
                sh "mvn clean compile"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                sh "mvn package"
            }
        }
    }
}
