 def call() {
     pipeline  {

         agent {
             label 'workstation'
         }
         stages  {
             stage('Compile/Build') {
                 steps {
                     echo 'hello from hello compile stage'
                 }
             }



             stage('Unit tests') {
                 steps{
                     echo 'hello from hello unit stage'
                 }
             }


             stage('Quality control') {
                 steps{
                     echo 'hello from hello quality stage'
                 }
             }


             stage('Storing in centralized palce') {
                 steps{
                     echo 'hello from hello centralised stage'
                 }
             }
         }
         post{
             always {
                 echo 'send an email'
             }
         }
     }
 }