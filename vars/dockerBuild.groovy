def call(String imageName, String imageTag) {
    echo "Building and pushing Docker image..."

    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-creds',
        usernameVariable: 'USER',
        passwordVariable: 'PASS'
    )]) {
        sh """
        docker login -u $USER -p $PASS
        docker build -t ${imageName}:${imageTag} .
        docker push ${imageName}:${imageTag}
        """
    }
}