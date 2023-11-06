pipeline {
    agent any
    stage('Checkout') {
        steps {
            git(
                branch: 'main',
                url: 'https://github.com/Arya5596/repo02',
                credentialsId: 'github',
                tool: 'YourGitInstallationName'
        )
    }
 }
}
