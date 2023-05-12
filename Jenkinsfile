pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout do repositório do GitHub
                git 'https://github.com/seu-usuario/seu-repositorio.git'
            }
        }

        stage('Build') {
            steps {
                // Compilação do código usando o Maven
                sh 'mvn -f unicamp_/pom.xml clean compile'
            }
        }

        stage('Test') {
            steps {
                // Execução dos testes JUnit usando o Maven
                sh 'mvn -f unicamp_/pom.xml test'
            }
        }
    }
}
