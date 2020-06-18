#!/usr/bin/env groovy
@Library(value='jenkins-pipeline-scripts@master', changelog=false) _

String DOCKER_REGISTRY="index.docker.io/v1".trim()
String DOCKER_ORGANISATION="nabla".trim()
String DOCKER_TAG="latest".trim()
String DOCKER_NAME="ansible-jenkins-slave-docker".trim()

String DOCKER_REGISTRY_URL="https://${DOCKER_REGISTRY}".trim()
String DOCKER_REGISTRY_CREDENTIAL=env.DOCKER_REGISTRY_CREDENTIAL ?: "hub-docker-nabla".trim()
String DOCKER_IMAGE="${DOCKER_ORGANISATION}/${DOCKER_NAME}:${DOCKER_TAG}".trim()

def utils

def isReleaseBranch() {
    BRANCH_NAME ==~ /develop/ || BRANCH_NAME ==~ /master/ || BRANCH_NAME ==~ /release\/.*/
}

pipeline {
    //agent { label 'molecule' }
    agent none
    triggers {
        cron '@daily'
        //pollSCM '@hourly'
    }
    parameters {
        booleanParam(defaultValue: false, description: 'Dry run', name: 'DRY_RUN')
    }
    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}".replaceAll("feature/","")
        PROJECT_BRANCH = "${env.GIT_BRANCH}".replaceFirst("origin/","")
    }
    options {
        disableConcurrentBuilds()
        ansiColor('xterm')
        timeout(time: 45, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Preparation') { // for display purposes
            steps {
                node('molecule') {
                    //checkout scm

                    script {
                        utils = load "Jenkinsfile-vars"
                        if (! isReleaseBranch()) { utils.abortPreviousRunningBuilds() }
                            //properties(utils.createPropertyList())
                        sh "git rev-parse --short HEAD > .git/commit-id"
                        GIT_COMMIT = readFile('.git/commit-id')

                        if (!params.DRY_RUN) {
                            ansiColor('xterm') {
sh '''
set -e
#set -xve

echo USER $USER

cd ./env/scripts/jenkins/

echo PATH ${PATH}
echo JAVA_HOME ${JAVA_HOME}
echo DISPLAY ${DISPLAY}

echo BUILD_NUMBER: ${BUILD_NUMBER}
echo BUILD_ID: ${BUILD_ID}
echo IS_M2RELEASEBUILD: ${IS_M2RELEASEBUILD}

./step-2-0-0-build-env.sh || exit 1

./step-2-0-1-build-env-info.sh || exit 1

exit 0
'''
                            } //ansiColor

                            load "${env.WORKSPACE}/env/scripts/jenkins/jenkins-env.groovy"
                        } // DRY_RUN

                    } // script

                    echo "GIT_COMMIT: ${GIT_COMMIT}"
                    echo "PROJECT_BRANCH: ${env.PROJECT_BRANCH}"
                    echo "BRANCH_NAME: ${env.BRANCH_NAME}"
                } // node
            } //steps
        } // Preparation

        stage('SonarQube analysis') {
            environment {
                SONAR_SCANNER_OPTS = "-Xmx1g"
            }
            steps {
                node('molecule') {
                    sh "pwd"
                    sh "/usr/local/sonar-runner/bin/sonar-scanner -D sonar-project.properties"
                } // node
            }
        }

        stage('Results') {
            steps {
                node('molecule') {
                    step([
                            $class: "WarningsPublisher",
                            canComputeNew: false,
                            canResolveRelativePaths: false,
                            canRunOnFailed: true,
                            consoleParsers: [
                                [
                                    parserName: 'Java Compiler (javac)'
                                ],
                                [
                                    parserName: 'Maven'
                                ]
                            ]
                        ])

                    step([
                            $class: "AnalysisPublisher",
                            canComputeNew: false,
                            checkStyleActivated: false,
                            defaultEncoding: '',
                            dryActivated: false,
                            findBugsActivated: false,
                            healthy: '',
                            opentasksActivated: false,
                            pmdActivated: false,
                            unHealthy: ''
                        ])

                    step([
                            $class: 'LogParserPublisher', parsingRulesPath: '/jenkins/deploy-log_parsing_rules', useProjectRule: false
                        ])

                    script {
                        shellcheckExitCode = sh(
                            script: 'shellcheck -f checkstyle ./env/scripts/jenkins/*.sh > checkstyle.xml',
                            returnStdout: true,
                            returnStatus: true
                        )
                        sh "echo ${shellcheckExitCode}"
                    } // script

                    checkstyle canComputeNew: false, defaultEncoding: '', healthy: '50', pattern: '**/checkstyle.xml', shouldDetectModules: true, thresholdLimit: 'normal', unHealthy: '100'

                } // node

            }
        } // stage Results

        stage('Archive Artifacts') {
            steps {
                node('molecule') {
                    script {

                        if ((BRANCH_NAME == 'develop') || (BRANCH_NAME ==~ /release\/.*/) || (BRANCH_NAME ==~ /master\/.*/)) {

                            publishHTML (target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              reportDir: 'reports/',
                              reportFiles: 'JENKINS_ZAP_VULNERABILITY_REPORT-${BUILD_ID}.html',
                              reportName: "ZaProxy Report"
                            ])

                            publishHTML (target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              reportDir: 'build/phantomas/',
                              reportFiles: 'index.html',
                              reportName: "Phantomas Report"
                            ])

                            publishHTML (target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              reportDir: 'screenshots/desktop/',
                              reportFiles: 'index.html.png',
                              reportName: "Desktop CSS Diff Report"
                            ])

                            publishHTML (target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              reportDir: 'screenshots/mobile/',
                              reportFiles: 'index.html.png',
                              reportName: "Mobile CSS Diff Report"
                            ])

                            publishHTML (target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              //reportDir: 'target/*',
                              reportFiles: 'gc.png speed.har CHANGELOG.html',
                              reportName: "Reports"
                            ])

                        }

                    } //script
                } // node
            } // steps
        } // stage Archive Artifacts
    }
    post {
        // always means, well, always run.
        always {
            node('molecule') {
                echo "Hi there"
                //script {
                //    utils = load "Jenkinsfile-vars"
                //    utils.notifyMe()
                //}
            } // node
        }
        failure {
            echo "I'm failing"
        }
        // changed means when the build status is different than the previous build's status.
        changed {
            echo "I'm different"
        }
        // success, failure, unstable all run if the current build status is successful, failed, or unstable, respectively
        success {
          echo "I succeeded"
        }
    }
}
