def lintchecks(){
    sh'''
           echo Installing JSlint
           npm i jslint
           node_modules/jslint/bin/jslint.js server.js || true
    '''
}

def call(){
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