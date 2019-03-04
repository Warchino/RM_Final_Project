pipeline {
    agent any

    stages {
        stage('Build') {
			try{
				steps {
                echo 'Building...'

		        sh './gradlew clean build'
                archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true

		        sh './gradlew jar'
		        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            	}
				currentBuild.result = "SUCCESS"	
			} catch(e) {
				currentBuild.result = "FAILED"
				throw e
			}
            
        }
        stage('Test') {
			try{
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
				currentBuild.result = "SUCCESS"	
			} catch(e) {
				currentBuild.result = "FAILED"
				throw e
			}
        }

        stage('Code Quality Analysis') {
			try{
				steps {
                echo 'Analyzing....'
                sh './gradlew sonarqube'
            	}
				currentBuild.result = "SUCCESS"	
			} catch(e) {
				currentBuild.result = "FAILED"
				throw e
			}
        }
    }
    post {
            always {
                echo 'Email notification'
				if (currentBuild.result =="FAILED"){
					notifyFailed()
				} else{
					notifySuccessful()
				}
            }
        }
}
def notifySuccessful() {
	  emailext (
		  subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
		  body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
			<p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
		  recipientProviders: [[$class: 'DevelopersRecipientProvider']]
		)
	}
def notifyFailed() {
  emailext (
	  subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
	  body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
		<p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
	  recipientProviders: [[$class: 'DevelopersRecipientProvider']]
	)
}
