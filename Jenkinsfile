pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x gradle
'''
        sh './gradle build'
      }
    }

  }
}