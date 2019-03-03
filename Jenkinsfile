pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'

		        sh './gradlew clean build'
                archiveArtifacts artifacts: '/build/libs/**/*.war', fingerprint: true

		        sh './gradlew jar'
		        archiveArtifacts artifacts: '/build/libs/**/*.jar', fingerprint: true

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'

                sh './gradle-java-at08/gradlew check -p gradle-java-at08'

                // Publis the JUnit test Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: '/build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'JUnit Report'
                  ]

                sh './gradle-java-at08/gradlew jacocoTestReport -p gradle-java-at08'

                // Publish the Java Code Coverage Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: '/build/reports/jacoco/jacocoHtml',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                  ]
            }
        }
        stage('Code Quality Analysis') {
            steps {
                echo 'Analyzing....'
                sh './gradlew sonarqube'
            }
        }
    }

}
