pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/Arya5596/repo02',
                    credentialsId: 'github'
                )
            }
        }
        stage('init') {
            steps {
                script {
                    sh 'terraform init'
                }
            }
        }
    }
}

