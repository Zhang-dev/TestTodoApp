pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                bat "git clone https://github.com/Zhang-dev/TestTodoApp.git"
                bat "mvn clean -f TestTodoApp"
            }
        }
        stage('Test') { 
            steps {
                bat "mvn test -f TestTodoApp"
            }
        }
        stage('Deploy') { 
            steps {
                echo "sucess"
            }
        }
    }
}