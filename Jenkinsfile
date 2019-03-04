pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'

		        sh './gradlew clean build'
                archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true

		        sh './gradlew jar'
		        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'

                sh './gradlew check'

                // Publis the JUnit test Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'JUnit Report'
                  ]
                junit 'build/test-results/**/*.xml'

                sh './gradlew jacocoTestReport'

                // Publish the Java Code Coverage Report
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/jacoco',
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
    post {
            always {
                echo 'Email notification'

                emailext (
                    subject: "Job '${env.JOB_NAME} ${env.BUILD_NUMBER}'",
                    body: """<p>Check console output at <a href="${env.BUILD_URL}">${env.JOB_NAME}</a></p>""",
                    to: "rodrigo.menacho@fundacion-jala.org",
                    from: "menacho.devops@gmail.com"
                )
            }
        }

}
