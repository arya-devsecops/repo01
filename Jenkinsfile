pipeline {
    agent any
    environment {
        ARM_CLIENT_ID     = credentials('daca292c-896c-4ee2-a083-c6cfbc08acf1')
        ARM_CLIENT_SECRET = credentials('b39738f5-8b7a-4e48-acbc-59f8368b651b')
        ARM_SUBSCRIPTION_ID = '44072bee-09d8-4fd1-9150-46a2662697d7'
        ARM_TENANT_ID = '3cc22669-453b-4e89-8eb5-29528e2c8a69'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/Arya5596/repo02']])
                
            }
        }
        stage('Terraform Init') {
            steps {
                script {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform Plan') {
            steps {
                script {
                    sh 'terraform plan -out=tfplan'
                }
            }
        }
        stage('Terraform Apply') {
            steps {
                script {
                    sh 'terraform apply -auto-approve tfplan'
                }
            }
        }
    }
}
