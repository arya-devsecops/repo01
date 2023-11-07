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

        
       stage('Azure Login') {
           steps {
               script {
                   // Load Azure credentials from Jenkins credentials
                   withCredentials([azureServicePrincipal(credentialsId: 'e7e08133-d73a-4ace-80b0-d8f7a5251879', varAzureSubscriptionId: '44072bee-09d8-4fd1-9150-46a2662697d7', varAzureTenantId: '3cc22669-453b-4e89-8eb5-29528e2c8a69', varAzureClientSecret: 'bby8Q~PkAce0duYn8MmipT7~9UT0uUSpiKzKIbSP', varAzureClientId: 'daca292c-896c-4ee2-a083-c6cfbc08acf1')]) {
                       // Login to Azure
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
}

