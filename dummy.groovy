pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: 'main',  // Update branch name if needed
                    url: 'https://github.com/Arya5596/repo02',
                    credentialsId: 'github'
                )
            }
        }
    }
        stage('Azure Login') {
            steps {
                script {
                    withCredentials([azureServicePrincipal(credentialsId: 'e7e08133-d73a-4ace-80b0-d8f7a5251879', 
                                    varAzureSubscriptionId: '44072bee-09d8-4fd1-9150-46a2662697d7',
                                    varAzureTenantId: '3cc22669-453b-4e89-8eb5-29528e2c8a69',
                                    varAzureClientSecret: 'bby8Q~PkAce0duYn8MmipT7~9UT0uUSpiKzKIbSP',
                                    varAzureClientId: '99442c11-70a0-4ce9-a51d-1dbdc4f7d339')]) {
                        sh "az login --service-principal -u \$AZURE_CLIENT_ID -p \$AZURE_CLIENT_SECRET --tenant \$AZURE_TENANT_ID"
                    }
                }
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
