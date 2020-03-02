/*** BEGIN META {
  "name" : "Search Job Configuration",
  "comment" : "Searches job names and configurations for a matching plain text for regexp pattern",
  "parameters" : ['pattern', 'details', 'disabled'],
  "core": "1.300",
  "authors" : [
    { name : "Sebastian Schuberth" }
  ]
} END META**/
import java.util.regex.Pattern;
import java.util.regex.Matcher;

count = 0
pattern = "/.*Jenkinsfile.*/"
details= true
disabled=false
local_file = false
local_file_start = false
jenkinsfile_source_repo=""
repo_creds_id=""
jenkinsfile_path = ""
branch = ""
branches = []
jobs = []

if (pattern.startsWith('/') && pattern.endsWith('/')) {
  echo "Searching jobs for regexp ${pattern}..."
  pattern = pattern.substring(1, pattern.length() - 1)
  search = 'matches'
} else {
  echo "Searching jobs for string '${pattern}'..."
  search = 'contains'
}
def isFolder(item) {
  item instanceof jenkins.branch.OrganizationFolder
}
// def isFolder(item) {
//   item instanceof com.cloudbees.hudson.plugins.folder.Folder
// }
def isMaven(item){
  item instanceof hudson.maven.MavenModuleSet
}
def isMultiBranch(item){
  item instanceof org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject
}
def isFreestyle(item){
  item instanceof hudson.model.FreeStyleProject
}
def isJob(item) {
   item instanceof hudson.matrix.MatrixProject || item instanceof com.tikal.jenkins.plugins.multijob.MultiJobProject || item instanceof org.jenkinsci.plugins.workflow.job.WorkflowJob || item instanceof org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject || item instanceof hudson.maven.MavenModuleSet
 }
 def parseJenkinsfile(filecontent){
    Pattern pat = Pattern.compile("node.*|label.*");
    Matcher matcher = pat.matcher(filecontent);
    matches = []
    while(matcher.find()) {
          matches.add(matcher.group())
    }
    return matches
 }
 def getLabelName(match){
    Pattern pat = Pattern.compile("((\'|\").*(\'|\"))|(&apos;.*&apos;)|(&quot;.*&quot;)");
    Matcher matcher = pat.matcher(match);
    if(matcher.find()) {
          match = matcher.group()
    }else{
      echo "Couldn't parse label name. Possibly variable?"
      return
    }
    return match
 }
def splitBranchName(branch){
    def result = ""
    if(branch.contains("develop")){
      // echo "Develop branch"
      try{
       result = (branch =~ /develop.*/)[0]
         return result
     }catch(Exception ex ){
       echo "Keep on looking for right branch"
     }
    }
    if(branch.contains("master")){
      // echo "Master branch"
      try{
       result = (branch =~ /master.*/)[0]
         return result
      }catch(Exception ex ){
         echo "Keep on looking for right branch"
       }
    }
    if(branch.contains("release")){
     // echo "Release branch"
      try{
         result = (branch =~ /release\/\d.*/)[0]
         return result
      }catch(Exception ex ){
        echo "Keep on looking for right branch"
      }
    }
    if(branch.contains("feature")||branch.contains("bugfix")){
      // echo "Test branch"
      try{
         result = (branch =~ /feature\/.*/)[0]
           return result
      }catch(Exception ex){
         result = (branch =~ /bugfix\/.*/)[0]
           return result
      }
    }
}
def mergeNewUrl(username, password, url){
  split_size = url.split("//").size()
    url_new = url.split("//")[0]+"//"+username+":"+password+"@"+url.split("//")[1]
    if(split_size>2){
      for (int i =2 ; i < split_size; i++){
          url_new=url_new+"/"+url.split("//")[i]
      }
    }
    url = url_new
    return url
}
def processRepo(url, creds, path, job_name, branch){
   row = ""
   echo "JOB:"+job_name
   job_name = job_name.trim()
   if(job_name =="ARC CentOS7 Build"){
     echo "ARC CentOS7 Build not supported"
     return
   }
    // echo "URL: "+url
    // echo "PATH: "+path
    // echo "BRANCHES: "+branches.toString()
    // echo "CREDS: "+creds


   if(creds == "jenkins-ssh-scm"|| creds == "jenkins-ssh" || url.contains("ssh") ){
     //ssh key connection
     if (creds == "8aaa3139-bdc4-4774-a08d-ee6b22a7e0ac"){
       creds = "jenkins-ssh-scm"
     }
      withCredentials([ sshUserPrivateKey(credentialsId: creds, keyFileVariable: 'GIT_KEY', passphraseVariable: 'GIT_PASS', usernameVariable: 'GIT_USER')]) {
          try{
            sh "git clone -n --depth=2 ${url} ${WORKSPACE} --single-branch --branch ${branch}"
             sh "git checkout HEAD ${path}"
           }catch(Exception ex){
             echo "Exception found, skipping this JOB"
             echo ex.toString()
             cleanWs()
             row=job_name+";FILE NOT FOUND;"
             row +=path+";"
             row+=url+";"
             row+=branch+";\n"
             // echo "ROW:"
             // // echo row
             return row
           }
            file1 = readFile path
            matches = parseJenkinsfile(file1)
            Set labels=[]
            matches.each{match->
                if (getLabelName(match)!=null){
                  match = getLabelName(match)
                  match = match.substring(1,match.length()-1)
                  labels.add(match)
                }
            row=job_name+";"
            labels.each{label->
              row+=label+", "
            }
            row +=";"+path+";"
            row+=url+";"
            row+=branch+";\n"
            cleanWs()
        }

       }
   }
   else{
     withCredentials([
                  usernamePassword(credentialsId: creds, passwordVariable: 'PASSWORD', usernameVariable: 'USER')
                ]) {
                  url_old = url
                  if(url.contains("@")){
                      url = url.split("@")[0]+":"+PASSWORD+"@"+url.split("@")[1]
                  }else{
                    url = mergeNewUrl(USER,PASSWORD,url)
                  }
                    try{
                      if(url.contains("buildmasters")){
                        sh "git clone -n --depth=1 ${url} ${WORKSPACE} --single-branch --branch ${branch}"
                      }else{
                        sh "git clone -n --depth=2 ${url} ${WORKSPACE} --single-branch --branch ${branch}"
                      }
                      sh "git checkout HEAD ${path}"
                     }catch(Exception ex){
                       echo "Exception found, skipping this JOB "
                       echo ex.toString()
                       cleanWs()
                       row=job_name+";FILE NOT FOUND;"
                       row +=path+";"
                       row+=url_old+";"
                       row+=branch+";\n"
                       return row
                     }
                     jenkinsfile_name = path.split("/")[-1].trim()
                      file1 = readFile path
                      matches=parseJenkinsfile(file1)
                      Set labels=[]
                      matches.each{match->
                        if (getLabelName(match)!=null){
                          match = getLabelName(match)
                          match = match.substring(1,match.length()-1)
                          labels.add(match)
                        }
                      }
                      row=job_name+";"
                      labels.each{label->
                        row+=label+","
                      }
                      row +=";"+path+";"
                      row+=url_old+";"
                      row+=branch+";\n"
                      cleanWs()
                  }
               }


   return row;
 }
def processItem(item) {
  local_file=false
  found_config = []
  branches = []
  found_config.add(item.name)
  if(isMaven(item)){
    echo "Maven job - not supported"
    return
  }
  if (isFolder(item)) {
    echo "Folder - process for children"
    item.items.each { processItem(it) }
    return
  } else if (isJob(item)) {
    if (disabled.toBoolean() || !item.disabled) {
      counter = counter + 1
      def match = item.configFile.file.find { it."$search"(pattern) } != null
      File fh1 = new File(item.configFile.file.toString())
      found = false
      text = fh1.getText('UTF-8')
      // if(item.name == "cmr"){
      //   echo item.getFullDisplayName()
      //   echo text
      // }
      lines = fh1.readLines()
      config = false
      jenkinsfile_source_repo = ""
      branch = ""
      has_branch = false
      local_file_content = ""
      for(line in lines){
        if (line.contains("scriptPath")){
          found = true
        }else if(line.contains("<script>")){
            found = true
            local_file=true
            local_file_start=true
            found_config =[]
            found_config.add(item.name)
            found_config.add("local pipeline file")
            found_config.add("local pipeline file")
            found_config.add("local file")
            found_config.add("no branch")
        }
        if(!local_file){
             if( line.contains("<hudson.plugins.git.UserRemoteConfig>")){
              config =true
              jenkinsfile_source_repo=""
              repo_creds_id=""
            }else if(line.contains("</hudson.plugins.git.UserRemoteConfig>")){
              found_config.add(jenkinsfile_source_repo)
              found_config.add(repo_creds_id)
              jenkinsfile_source_repo=""
              repo_creds_id=""
              config = false
            }else if(config){
              if(line.contains("url")){
                  jenkinsfile_source_repo+=line.split(/[\/<>]*url[<>]*/)[1]
              }else if(line.contains("credentialsId")){
                  repo_creds_id=line.split(/[\/<>]*credentialsId[<>]*/)[1]
              }
            }else if(line.contains("<hudson.plugins.git.BranchSpec>")){
              has_branch= true
            }else if(line.contains("</hudson.plugins.git.BranchSpec>")){
              has_branch=false
            }else if(has_branch){
              if(branch==""){
               branch = line.split(/[\/<>]*name[<>]*/)[1]
               if(branch.contains("GIT_BRANCH")){
                 branches.add("develop")
                 branches.add("release/1.7.6")
               }
              }
            }
      }else{
        if(line.contains("</script>")){
          local_file_start=false
          matches = parseJenkinsfile(local_file_content)
          Set labels=[]
          try{
            matches.each{mat->
                if (getLabelName(mat)!=null){
                    mat = getLabelName(mat)
                    mat = mat.substring(6,mat.length()-6)
                    labels.add(mat)
                }
            }
            if(labels.size()==0){
              try{
                  echo "Might have been matrix?"
                  // echo text
                  lab = text.split(/[\/<>]*assignedNode[<>]*/)[1]
                  // echo lab
                  labels.add(lab)
                }catch(Exception ex){
                echo "whoops! this didn't work out..."
              }
            }
            found_config.add(labels)
          }catch(Exception ex){
              echo "COULDNT GET LABEL"
          }
        }else if(local_file_start){
          local_file_content+=line+"\n"
        }
       }
      }
      if(!found){
        echo "Didn't find config for ${item.name}"
        return
      }else{
        if(found_config.size<2){
          if(isMultiBranch(item)){
             url  = text.split(/[\/<>]*serverUrl[<>]*/)[1]
             repo = text.split(/[\/<>]*repoOwner[<>]*/)[1]
             repo_detail = text.split(/[\/<>]*repository[<>]*/)[1]
             creds = text.split(/[\/<>]*credentialsId[<>]*/)[1]
             url = url +"/scm/"+repo.toLowerCase()+"/"+repo_detail+".git"

             found_config.add(url)
             found_config.add(creds)
          }
        }
      }
      if(!local_file){
        if (match || item.name."$search"(pattern)) {
          ++count
          if (details.toBoolean()) {
            item.configFile.file.findAll { it."$search"(pattern) }.each {
              if(!it.trim().contains(" ")){
                found_jenkins+=1
                jenkinsfile_path = it.trim().split(/>/)[1].split(/</)[0]
                found_config.add(jenkinsfile_path)
              }
            }
          }
        }
    }
    }else {
    echo "Disabled ${item.name}\n"
    disabled_count = disabled_count + 1
    return
   }
  } else {
    if(!isFreestyle(item)){
      echo "NOTE: Skipping item '${item.name}' of '${item.getClass()}'.\n"
    }
    // echo "FreestyleJob - not supported"
    not_supported = not_supported + 1
    return
  }
  if(!local_file){
    if (branches.size == 0){
      if(branch == ""){
        branches.add("develop")
        branches.add("release/1.7.6")
      }else {
       branches.add(splitBranchName(branch))
     }
   }
   found_config.add(branches)
  }
  jobs.add(found_config)
}

counter = 0
found_jenkins = 0
not_supported = 0
disabled_count = 0
pipeline {
   agent {label 'flyweight'}
   stages {
         stage('Clean and Prepare workspace') {
           steps {
              script {
             cleanWs()
           }
           }
          }
          stage('Prepare job list') {
            steps {
               script {
                 hudson.model.Hudson.instance.items.each { processItem(it)
                 }
             }
           }
          }
          stage('Read repos') {
            steps {
               script {
                 // println file.text
            rows = []
            jobs.each{job->
              if(job.size()>=6){
                row=job[0]+";"
                job[5].each{label->
                  row+=label+", "
                }
                row +=";"+job[3]+";"
                row+=job[1]+";"
                row+=job[4]+";\n"
                rows.add(row)
              }else{
                job[4].each{branch ->
                  current_row = processRepo(job[1],job[2],job[3],job[0],branch)
                  rows.add(current_row)
                }
                // current_row = processRepo(job[1],job[2],job[3],job[0],job[4])
                // echo current_row
                // rows.add(current_row)
              }
            }
            sh "touch labels.csv"
            text = ""

             rows.each{row->
               if(row != null){
                 text +=row
               }
             }
              writeFile(file: 'labels.csv', text: 'Job_name;label_found;Jenkinsfile_path;Repository;branch;\n'+text)
           }
         }
          }
          stage('Archive artifacts'){
            steps{
              script{
                archiveArtifacts artifacts: 'labels.csv', onlyIfSuccessful: true
              }
            }
          }
          stage('Summary') {
            steps {
               script {
            echo "SUPPORTED ACTIVE JOBS:${counter}"
            echo "FOUND AND DOCUMENTED: ${rows.size().toString()}"
            echo "NOT_SUPPORTED:${not_supported}"
            echo "SUPPORTED BUT DISABLED: ${disabled_count}"
            echo "${count} match(es) in total for regex search"
          }
          }
          }


     }
}
