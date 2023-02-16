def call() {
    pipeline {
        agent {
            node {
                label 'workstation'
            }
            options {
                ansiColor('xterm')
            }
        }
        parameters {
            string(name: 'INFRA_ENV', defaultValue: '', description: 'Input as dev or prod')
        }
        stages {
            stage ('terraform Init') {
                steps {
                    sh "terraform init -backend-config=env-${INFRA_ENV}/state.tfvars"
                }



            }
        }
    }
}