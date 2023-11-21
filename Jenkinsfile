parameters([choice(name: 'Action' , choices: ['Plan' , 'Apply' , 'Destroy'] , description: 'Please select the action')])
pipeline {
    agent any
options {
  ansiColor('xterm')
    }
    environment {
        ARM_CLIENT_ID         = "b90f940f-e258-4200-906e-55e1f693b73f"
        ARM_CLIENT_SECRET     = "tnY8Q~TJVyOMPnN0ZnTDm.zK9P5b3sQL1K1msb4V"
        ARM_SUBSCRIPTION_ID   = "44072bee-09d8-4fd1-9150-46a2662697d7"
        ARM_TENANT_ID         = "3cc22669-453b-4e89-8eb5-29528e2c8a69"
        }
    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'repo', url: 'https://github.com/Arya5596/repo01']])
                
            }
        }
          stage('Terraform Init') {
            steps {
                script {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform code format check') {
            steps{
                script {
                    sh 'terraform fmt'
                }
            }
        } 
        stage('Terraform validate') {
            steps {
                script {
                    sh 'terraform validate'
                    switch (params.Action) {
                        
                        case'Plan':
                        stage('Terraform plan'){
                            sh 'terraform plan'
                        }
                        break
                        
                        case'Apply':
                        stage('Terraform Apply') {
                             // terraform plan output saved in plan.output file
                            sh 'terraform plan -out=plan.out'
                            timeout(time: 1,unit: 'MINUTES'){
                                input "Do you want to proceed"
                            }
                             sh 'terraform apply "plan.out"'
                        }
                        break
                        
                        case'Destroy':
                        stage('Terraform Destroy'){
                            sh 'terraform plan'
                            timeout(time: 1,unit: 'MINUTES'){
                                input "Do you want to destroy all resources"
                            }
                            // to destroy the all resource
                            sh 'terraform destroy --auto-approve'
                        }
                    }
                }
            }
        }
    }
}
                
