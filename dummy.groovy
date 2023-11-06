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
                    withCredentials([azureServicePrincipal(credentialsId: 'e7e08133-d73a-4ace-80b0-d8f7a5251879', variable: 'AZURE_CREDENTIALS')]) {
                        def credentials = binding['AZURE_CREDENTIALS']
                        def clientId = credentials.getClientId()
                        def clientSecret = credentials.getClientSecret()
                        def subscriptionId = '44072bee-09d8-4fd1-9150-46a2662697d7'
                        def tenantId = credentials.getTenant()

                        // Login to Azure
                        sh "az login --service-principal -u ${clientId} -p ${clientSecret} --tenant ${tenantId}"
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

