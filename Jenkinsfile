pipeline {
    agent any
    environment {
        ARM_CLIENT_ID         = "b90f940f-e258-4200-906e-55e1f693b73f"
        ARM_CLIENT_SECRET     = "tnY8Q~TJVyOMPnN0ZnTDm.zK9P5b3sQL1K1msb4V"
        ARM_SUBSCRIPTION_ID   = "44072bee-09d8-4fd1-9150-46a2662697d7"
        ARM_TENANT_ID         = "3cc22669-453b-4e89-8eb5-29528e2c8a69"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Arya5596/repo01']])
                
            }
        }
        stage('Terraform Init') {
            steps {
                script {
                    sh 'terraform init'
                }
            }
        }
        stage('validate') {
            steps {
                script {
                    sh 'terraform validate'
                }
            }
        }    
        stage('Terraform Plan') {
            steps {
                script {
                    sh 'terraform plan'
                }
            }
        }
        stage('Terraform Apply') {
            steps {
                script {
                    sh 'terraform apply'
                }
            }
        }
        post {
            allways {
                script {
                    sh 'terraform destroy'
                }
            }
    }
}
}
