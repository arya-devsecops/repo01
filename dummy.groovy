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

        stage('VALIDATE') {
            steps {
                script {
                    sh 'terraform validate'
                }
            }
        }


        
       stage('Azure Login') {
           steps {
               script {
                   // Load Azure credentials from Jenkins credentials
                   withCredentials([azureServicePrincipal(credentialsId: 'e7e08133-d73a-4ace-80b0-d8f7a5251879', varAzureSubscriptionId: 'AZURE_SUBSCRIPTION_ID', varAzureTenantId: 'AZURE_TENANT_ID', varAzureClientSecret: 'AZURE_CLIENT_SECRET', varAzureClientId: 'AZURE_CLIENT_ID')]) {
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

