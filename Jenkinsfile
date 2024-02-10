pipeline {
    agent any
    environment {
        PATH= "/usr/bin:$PATH"
    }

    stages {
        stage('Clone Code') {
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
                echo 'Deploying...'
            }
        }
    }
}
