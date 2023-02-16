def call() {
    pipeline {
        agent {
            node {
                label 'ansible'
            }
        }
        parameters {
            string(name: 'INFRA_ENV', defaultValue: '', description: 'Input as dev or prod')
        }
        options {
            ansiColor('xterm')
        }
        stages {
            stage ('terraform Init') {
                steps {
                    sh "terraform init -backend-config=env-${INFRA_ENV}/state.tfvars"
                }
            }
            stage ('terraform Apply') {
                steps {
                    sh "terraform apply -auto-approve -var-file=roboshop-infra/env-${INFRA_ENV}/main.tfvars"
                }
            }


        }
        post {
            always {
                cleanWs()
            }
        }
    }
}