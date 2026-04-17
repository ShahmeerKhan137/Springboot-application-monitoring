def call() {
    echo "Building app with Maven + SonarQube..."

    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
        sh '''
        mvn clean verify sonar:sonar \
        -Dsonar.host.url=http://host.docker.internal:9000 \
        -Dsonar.login=$SONAR_TOKEN
        '''
    }
}