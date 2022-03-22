pipeline {
    agent {
        label "master"
    }

    stages {
        stage('checkout:git') {
            steps {
                 git credentialsId: '15983b9a-5411-410b-bed1-3bb1c7ecdb34', url: 'https://github.com/phvieira124/sre-docker-lab.git'
            }
        }

        stage('deploy:docker_compose') {
            steps {
                sh 'sudo docker-compose build'
                sh 'sudo docker-compose up -d'
            }
        }

        stage('metrics:prometheus') {
            steps {
                sh 'docker run -itd -p 9090:9090 -v ./prometheus.yaml:/etc/prometheus/prometheus.yml prom/prometheus'
            }
        }
    }
}
