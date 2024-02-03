pipeline {
    agent any
    tools {
        maven "3.8.5"

    }
    stages {
        stage('Compile and Clean') {
            steps {
                // Run Maven on a Unix agent.

                sh "mvn clean compile"
            }
        }
        stage('deploy') {

            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){

            steps {
                echo "Hello Java Express"
                sh 'ls'
                sh 'docker build -t  meetkanakia5/productservice:9a72f7bf7483 .'
            }
        }
        stage('Docker Login'){

            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u meetkanakia5 -p ENErique@1"
                }
            }
        }
        stage('Docker Push'){
            steps {
                sh 'docker push meetkanakia5/productservice:9a72f7bf7483'
            }
        }
        stage('Docker deploy'){
            steps {

                sh 'docker run -itd -p  8081:8080 meetkanakia5/productservice:9a72f7bf7483'
            }
        }
        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}