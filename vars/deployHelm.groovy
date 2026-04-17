def call(String imageName, String imageTag) {
    echo "Deploying application with Helm..."

    sh """
    helm upgrade --install my-app ./helm-chart \
    --set image.repository=${imageName} \
    --set image.tag=${imageTag}
    """
}