def call() {
    pipeline {
        agent {
            node {
                label "workstation"
            }
        }
        parameters {
            string(name: 'INFRA-ENV', defaultValue: '', description: 'Input as dev or prod')
        }
        stages {
            stage("terraform init") {
                steps {
                    sh "terraform init -backend-config = env-${INFRA-ENV}/state.tfvars"
                }



            }
        }
    }
}