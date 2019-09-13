@Library('CpsGlobal@develop') _

import groovy.time.*;
import jenkins.model.Jenkins

def updateMonthOrYear(month, year){
  month= month + 1
  if(month>12){
    month= month -12
    year +=1
  }
  return [month, year]
}
node('release'){
try{

  withCredentials([
            [$class         : 'UsernamePasswordMultiBinding',
            credentialsId   : "jenkins",
            passwordVariable: 'GIT_PASSWORD',
            usernameVariable: 'GIT_USERNAME']]) {
            //paramters

            //constants
            def issueType = 'Story'
            def projectKey = "NABLA"
            def url = "https://jira/rest/api/2/issue/createmeta?projectKeys=NABLA&expand=projects.issuetypes.fields"

            //variables
            def internalProducts = []
            def components = []
            def dueDate
            def summary
            def description
            def jsonFile
            def scrumTeam =[]
            def resposne

            def failedIssueURL
            def issue_category = []
            def label = []

            stage('Clean workspace'){
              cleanWs()
            }

            stage('Pre-prepare parameters'){
              def upstream
              try{
                upstream = currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause)
              }catch(e){
                echo "Couldn't upstream."
              }
              def matcher = (env.JOB_URL=~ /.*\/jenkins\// )
              if (matcher.find())
              {
                 failedIssueURL = matcher.group(0)
              }
              failedIssueURL += upstream?.getUpstreamUrl()
              echo failedIssueURL
              project_name = upstream?.getShortDescription().find(/".*"/)
              summary = project_name + " failed"
              description = "The following job has failed : " + upstream?.getUpstreamUrl().split('/')[-1] + " to be found:\n"+failedIssueURL+"\nPlease take action.\n" +upstream?.getShortDescription()+"\n More about here:\n https://jira/browse/TEST-0001"
            }

            stage('Get JSON'){
              retry(3){
                jsonFile = utils.jsonParse(utils.stashRestCall(url, GIT_USERNAME, GIT_PASSWORD, "GET", ""))
              }
           }
          //
           stage ('Preprate data'){
             def componentsAllowedValues =jsonFile.get("projects")[0].get("issuetypes")[2].get("fields").get("components").get("allowedValues")

             components << componentsAllowedValues[6]
             def allowedValues = jsonFile.get("projects")[0].get("issuetypes")[2].get("fields").get("customfield_13001").get("allowedValues")
             internalProducts << allowedValues[0]
             evenMonth = [4,6,9,11]
             dueDate= new Date().format("yyyy-MM-dd").toString().split("-")
             year = Integer.parseInt(dueDate[0])
             month =Integer.parseInt(dueDate[1])
             day =Integer.parseInt(dueDate[2])
             day+=14

             isEven = false
             evenMonth.eachWithIndex{
               evenItem ->
               if(month == evenItem){
                 isEven=true
               }
             }

            if(isEven){
              if(day>30){
                day = day-30
                (month, year)=updateMonthOrYear(month, year)
              }
            }else{
              if(month == 2){
                if(day>28){
                  day= day -28
                  updateMonthOrYear(month, year)
                }
              }
              if(day>31){
                day = day -31;
                updateMonthOrYear(month, year)
              }

            }
            newDate = year + "-"
            if(month<10){
             newDate+="0"+month + "-"
            }else{
              newDate+=month + "-"
            }
            if(day<10){
              newDate+="0"+day
            }else{
              newDate+= day
            }
            dueDate = newDate
            scrumTeam << jsonFile.get("projects")[0].get("issuetypes")[2].get("fields").get("customfield_16100").get("allowedValues")[7]
            issue_category[0] = jsonFile.get("projects")[0].get("issuetypes")[2].get("fields").get("customfield_13065").get("allowedValues")[2]
            label[0]="Stabilization"
          }

           stage('Create ticket'){

                esdIssue = ["fields": [ "project": ["key": projectKey],
                                        "summary": summary,
                                        "description": description,
                                        "issuetype": ["name": issueType],
                                        "customfield_13001": internalProducts,
                                        "components": components,
                                        "duedate": dueDate,
                                        "assignee":[
                                             "name":"aandrieu"
                                        ],
                                        "customfield_13065": issue_category,
                                        "labels":label,
                                        "customfield_16100": scrumTeam
                                      ]
                            ]

             response = jiraNewIssue  issue: esdIssue, site: 'Jira'


           }
       }
     }
     catch(Exception ex){}
     finally{
        echo "Build number: {}".format(BUILD_NUMBER)
         def currentResult = currentBuild.result ?: 'SUCCESS'
         if (currentResult == 'FAILURE') {
           script {
             println "Sending informational e-mail to alban.andrieu@free.fr"
             def KEY = response.data.get("key")
             def link = "https://nabla/jira/browse/"+KEY
             mail "body": "Creation of a JIRA ticket has been interrupted due to some issues. Please look-up: https://jenkins/jenkins/job/on-build-fail-JIRA-creator/{} ".format(BUILD_NUMBER),
                    "from": 'alban.andrieu@free.fr',
                    "subject": "ON-FAIL-CREATE-JIRA failed",
                    "to": "alban.andrieu@free.fr",

                 }
          }
       }
  }
