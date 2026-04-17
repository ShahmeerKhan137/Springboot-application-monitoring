@Library('my-shared-lib') _

pipeline {
    agent any

    environment {
        GIT_URL = "https://github.com/ShahmeerKhan137/Springboot-application-monitoring.git"
        IMAGE_NAME = "shahmeer138/springboot-app"
        IMAGE_TAG = "latest"
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_URL}"
            }
        }

        stage('Build & SonarQube') {
            steps {
                buildApp()
            }
        }

        stage('Docker Build & Push') {
            steps {
                dockerBuild(IMAGE_NAME, IMAGE_TAG)
            }
        }

        stage('Deploy with Helm') {
            steps {
                deployHelm(IMAGE_NAME, IMAGE_TAG)
            }
        }
    }
}