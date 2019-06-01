pipeline {
	agent{ label 'jenkins-slave-1'}
    stages{        
        stage('Build Jars'){
            agent{ label 'jenkins-slave-1'}
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
                    echo "who am i?"
                    sh "whoami"
                    dir('currency-exchange-service'){
                        exchange_image=docker.build("monicashinde3/currency-exchange-service")
                    }
                    dir('currency-conversion-service'){
                        conversion_image=docker.build("monicashinde3/currency-conversion-service")
                    }
                    
                }
            }
        }

        stage('Push to Docker hub'){
            
            steps{
                script {
                    withDockerRegistry([ credentialsId: "docker-hub-user", url: "" ]){
                        exchange_image.push()
                        conversion_image.push()
                    }
                }
            }
        }

        stage('Deploy in container'){
            agent{ label 'jenkins-slave-2'}
            steps{
                script{
                    checkout scm
                    sh 'docker-compose up -d'
                }
            }
        }
    }
    
}