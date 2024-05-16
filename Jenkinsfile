pipeline {
    agent any

    tools {
        maven 'Maven 3.8.8'
        jdk 'jdk11'
    }

    stages {
        stage('Clean') {
            steps {
                echo 'Clean del proyecto'
                bat 'mvn clean'
            }
        }

        stage('Verify') {
            steps {
                 echo 'Ejecución de pruebas'
                 bat 'mvn verify'
            }
        }
    }
}