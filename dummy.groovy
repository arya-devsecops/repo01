pipeline {
    agent any
    stages {
    stage('Checkout') {
        steps {
            git(
                branch: 'main',
                url: 'https://github.com/Arya5596/repo02',
                credentialsId: 'github',
        )
    }
 }
        stage('init') {
            steps {
                // Use Terraform plugin to initialize Terraform
#                terraformInit(
                    //credentialsId: 'e7e08133-d73a-4ace-80b0-d8f7a5251879', // Specify your Terraform credentials
    sh 'terraform init'
                )
            }
        }
    }
}
