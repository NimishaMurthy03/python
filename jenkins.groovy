pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/NimishaMurthy03/python.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the project..."
                // Add your build commands here
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                // Add testing commands (e.g., pytest)
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying the project..."
                // Add deployment commands here (e.g., copy to server, start service)
            }
        }
    }
}
 stage('Deploy') {
            steps {
                echo "Deploying the project..."
                // Add deployment commands here (e.g., copy to server, start service)
            }
        }
    }
}
