def lintchecks(){
    sh'''
           echo Installing JSlint for ${COMPONENT}
           npm i jslint
           node_modules/jslint/bin/jslint.js server.js || true
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
                sh "npm install"
            }
        }                                         // end of stages
     }
   }
}