pipeline{
    agent any
    stages{        
        stage('Build Jars'){
            steps{
                echo 'Building currency exchange service'
               dir('currency-exchange-service') {
                   sh "mvn clean install -DskipTests"
                    }
                echo 'Building currency conversion service'
                dir('currency-conversion-service') {
                   sh "mvn clean install -DskipTests"
                    }
            }
        }
        
        stage('Test'){
            steps{
                echo 'Perform tests'
            }
        }
        
        stage('Build Docker Image'){
            steps{
                script {
                    dir('currency-exchange-service'){
                        exchange_image=docker.build("monicashinde3/currency-exchange-service:${env.BUILD_ID}")
                    }
                    dir('currency-conversion-service'){
                        conversion_image=docker.build("monicashinde3/currency-conversion-service:${env.BUILD_ID}")
                    }
                }
            }
        }

        stage('Push to Docker hub'){
            steps{
                script {
                    docker.withRegistry('https://hub.docker.com/', 'docker-hub-user'){
                        exchange_image.push()
                        conversion_image.push()
                    }
                }
            }
        }
    }
    
}


