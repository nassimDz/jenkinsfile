pipeline {
    agent any
    stages {
        stage('clone repository') {
            steps {
                sh'''
                    echo "pulling the project from github repository"
                    [ -d "cours_integration_continue" ] && rm -rf cours_integration_continue
                    git clone https://github.com/nassimDz/cours_integration_continue.git
            '''
            }
        }
        stage('Build') {
            steps {
                sh '''
                    cd cours_integration_continue 
                    mvn test
                '''
            }
        }
        stage('Notify'){
            steps{
                sh '''
                    make -C java/
                    make -C java/ send
                '''
            }
        }
        stage('clean'){
            steps{
                sh '''
                    make -C java/ clean
                    rm -rf cours_integration_continue
                    echo "good bye"
                '''

            }
        }
    }
}
