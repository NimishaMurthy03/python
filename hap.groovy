pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/NimishaMurthy03/Projects.git'
            }
        }

        stage('Unzip Uploaded Projects') {
            steps {
                sh '''
                mkdir -p extracted
                for file in *.zip; do
                    unzip -o "$file" -d extracted/"${file%%.*}"
                done
                '''
            }
        }

        stage('Build Frontend') {
            steps {
                echo 'No actual build step needed for HTML/CSS/JS. Just checking file presence.'
                sh 'ls -l *.html *.css *.js || echo "Some files may be missing."'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/*.html, **/*.css, **/*.js', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully.'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
