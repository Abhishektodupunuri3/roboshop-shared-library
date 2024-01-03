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
        stage('code compile') {
            steps {
                    //sh "mvn clean compile"
            }
        }                                         // end of stages
     }
   }
}