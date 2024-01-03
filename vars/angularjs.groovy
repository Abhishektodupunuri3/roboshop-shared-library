def lintchecks(){
    sh'''
            echo Installing PYLint for ${COMPONENT}
            echo lint checks completed for ${COMPONENT}
    '''
}

def call(COMPONENT){
    pipeline {
         agent any 
         stages {
         
                stage('Lint Checks') {
            steps {  
                script {
                    lintchecks()
                }
            }
        }     
        stage('code Quality ANalysis') {
            steps {
                    sh "echo code quality analysis is in place"
            }
        }                                         // end of stages
     }
   }
}