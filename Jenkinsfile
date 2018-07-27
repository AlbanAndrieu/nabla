#!/usr/bin/env groovy
/*
    Point of this Jenkinsfile is to:
    - build java project
*/
def utils

def isReleaseBranch() {
    env.BRANCH_NAME ==~ /develop/ || env.BRANCH_NAME ==~ /master/ || env.BRANCH_NAME ==~ /release\/.*/
}

pipeline {
    //properties([pipelineTriggers([snapshotDependencies()])])
    agent { label 'docker-inside' }
    triggers {
        cron '@daily'
        pollSCM '@hourly'
    }
    parameters {
        //string(defaultValue: 'develop', description: 'Default git branch to override', name: 'GIT_BRANCH_NAME')
        string(defaultValue: 'LATEST_SUCCESSFULL', description: 'Create a TAG', name: 'TARGET_TAG')
        booleanParam(defaultValue: false, description: 'Clean before run', name: 'CLEAN_RUN')
    }
    environment {
        JENKINS_CREDENTIALS = 'todo'
        //GIT_BRANCH_NAME = "${params.GIT_BRANCH_NAME}"
        CLEAN_RUN = "${params.CLEAN_RUN}"
        TARGET_PROJECT = sh(returnStdout: true, script: "echo ${env.JOB_NAME} | cut -d'/' -f -1").trim()
        BRANCH_NAME = "${env.BRANCH_NAME}".replaceAll("feature/","")
        PROJECT_BRANCH = "${env.GIT_BRANCH}".replaceFirst("origin/","")
        BUILD_ID = "${env.BUILD_ID}"
        SONAR_BRANCH = sh(returnStdout: true, script: "echo ${env.BRANCH_NAME} | cut -d'/' -f 2-").trim()
        GIT_AUTHOR_EMAIL = "${env.CHANGE_AUTHOR_EMAIL}"
        GIT_COMMIT = "TODO"
    }
    options {
        disableConcurrentBuilds()
        timeout(time: 45, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Cleaning') {
            steps {
                script {
                    if (params.CLEAN_RUN == true) {
                        stage('Clean everything') {
                            echo "Delete everything at start"
                            deleteDir()
                        }
                    }
                }
            }
        }
        stage('Preparation') { // for display purposes
            steps {
                checkout scm

                script {
                    utils = load "Jenkinsfile-vars"
                    if (! isReleaseBranch()) { utils.abortPreviousRunningBuilds() }
                    //properties(vars.createPropertyList())
                    sh "git rev-parse --short HEAD > .git/commit-id"
                    GIT_COMMIT = readFile('.git/commit-id')
                }

                echo "GIT_COMMIT: ${GIT_COMMIT}"
                echo "SONAR_BRANCH: ${SONAR_BRANCH}"
                echo "PROJECT_BRANCH: ${PROJECT_BRANCH}"
                echo "BRANCH_NAME: ${env.BRANCH_NAME}"
                //echo "GIT_BRANCH_NAME: ${env.GIT_BRANCH_NAME}"

                script {
                    currentBuild.displayName = [
                        '#',
                        BRANCH_NAME,
                        ' (',
                        GIT_COMMIT,
                        ', ',
                        currentBuild.displayName,
                        ')'
                    ].join("")
                }

                ansiColor('xterm') {
sh '''
set -e
#set -xve

echo BUILD_NUMBER: ${BUILD_NUMBER}
echo BUILD_ID: ${BUILD_ID}


exit 0
'''
                } //ansiColor
                echo "${env.SONAR_BRANCH}"
                echo "${env.RELEASE_VERSION}"
            } //step
        }

        stage('Build') {
            //environment {
            //    MAVEN_ROOT_POM = "${WORKSPACE}/${TARGET_PROJECT}/pom.xml"
            //    MAVEN_SETTINGS_FILE = "${WORKSPACE}/${TARGET_PROJECT}/settings.xml"
            //    SONAR_MAVEN_COMMANDS = "sonar:sonar"
            //}
            steps {
                ansiColor('xterm') {
sh '''
set -e
#set -xve

echo -e "${red} ${double_arrow} DO TEST WORKSPACE ${NC}"

exit 0
'''
                } //ansiColor
            } //steps
        } // stage Build

        stage('SonarQube analysis') {
            environment {
                SONAR_SCANNER_OPTS = "-Xmx1g"
            }
            steps {
                sh "pwd"
                sh "/usr/local/sonar-runner/bin/sonar-scanner -D sonar-project.properties"
            }
        }

        stage('Results') {
            steps {
                //warnings canComputeNew: false, canResolveRelativePaths: false, categoriesPattern: '', consoleParsers: [[parserName: 'Java Compiler (javac)'], [parserName: 'Maven']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', messagesPattern: '', unHealthy: ''

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
                        script: 'shellcheck -f checkstyle *.sh > checkstyle.xml',
                        returnStdout: true,
                        returnStatus: true
                    )
                    sh "echo ${shellcheckExitCode}"
                } // script

                step([
                    $class: 'CheckStylePublisher',
                    //pattern: '**/eslint.xml',
                    pattern: '**/checkstyle.xml',
                    unstableTotalAll: '0',
                    usePreviousBuildAsReference: true
                    ])

            }
        } // stage Results

        stage('Archive Artifacts') {

            steps {
                script {
                    //sshagent(['jenkins-ssh']) {
                    //    String versionInfo = "${TARGET_PROJECT}: BUILD: ${BUILD_ID} BRANCH: ${BRANCH_NAME} SHA1: ${GIT_COMMIT}"
                    //    String versionFile = "${env.WORKSPACE}/${TARGET_PROJECT}_VERSION.TXT"
                    //    sh "echo ${versionInfo} > ${versionFile}"
                    //}

                    String ARTIFACTS = ['*_VERSION.TXT',
                                    '**/target/*.swf',
                                    '**/target/*.log',
                                    'reports/*',
                                    '**/MD5SUMS.md5',
                                    'Jenkinsfile'].join(', ')

                    if ((BRANCH_NAME == 'develop') || (BRANCH_NAME ==~ /feature\/.*/)) {
                        ARTIFACTS << ",**/target/*SNAPSHOT.jar, **/target/*SNAPSHOT.war, **/target/*SNAPSHOT*.zip"
                        ARTIFACTS << ",**/target/*test.jar"
                    }

                    if ((BRANCH_NAME ==~ /release\/.*/) || (BRANCH_NAME ==~ /master\/.*/)) {
                        ARTIFACTS << ",**/target/*test.jar"
                    }

                    if ((BRANCH_NAME == 'develop') || (BRANCH_NAME ==~ /release\/.*/) || (BRANCH_NAME ==~ /master\/.*/)) {
                        archiveArtifacts artifacts: "${ARTIFACTS}", excludes: null, fingerprint: true, onlyIfSuccessful: true

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
                          reportDir: 'target/*',
                          reportFiles: 'gc.png speed.har CHANGELOG.html',
                          reportName: "Reports"
                        ])
                    }

                } //script
            }
        } // stage Archive Artifacts

        stage("Git Tag") {
            agent { label 'docker-inside' }
            steps {
                script {
                    utils.gitTagLocal()
                    utils.gitTagRemote()

                    utils.setBuildName()
                    utils.createVersionTextFile("${env.TARGET_PROJECT}_VERSION.TXT")
               } // script
            } // steps
        } // stage Git Tag
    }
    post {
        // always means, well, always run.
        always {
            node('docker-inside') {
                echo "Hi there"
                script {
                    utils.notifyMe()
                    try {
                      sh '''docker system prune -f;"'''
                      //docker rmi "${DOCKER_BUILD_IMG}:${DOCKER_TAG}
                    } catch(exc) {
                      echo 'Warn: There was a problem Cleaning local docker repo. '+exc.toString()
                    }
                }
            } // node
        }
        failure {
            echo "I'm failing"
            //bitbucketStatusNotify(
            //  buildState: 'FAILED',
            //  buildKey: 'build',
            //  buildName: 'Build',
            //  buildDescription: 'Something went wrong with build!'
            //)
        }
        // changed means when the build status is different than the previous build's status.
        changed {
            echo "I'm different"
            //bitbucketStatusNotify(
            //  buildState: 'FAILED',
            //  buildKey: 'test',
            //  buildName: 'Test',
            //  buildDescription: 'Something went wrong with tests!'
            //)
        }
        // success, failure, unstable all run if the current build status is successful, failed, or unstable, respectively
        success {
            node('docker-inside') {
                echo "I succeeded"
                //bitbucketStatusNotify ( buildState: 'SUCCESSFUL' )
                //archive "**/*"
                script {
                    if (! isReleaseBranch()) { cleanWs() }
                }
            } //node
        }
    }
}
