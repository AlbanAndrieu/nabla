import hudson.*
import jenkins.*
import hudson.security.*
import jenkins.security.*
import jenkins.model.Jenkins;

def generator = { String alphabet, int n ->
    new Random().with {
        (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
    }
}

class User {
    static def createUser(userName, userFullName, userEmail, userPassword) {
        def user = jenkins.model.Jenkins.instance.securityRealm.createAccount(userName,
                userPassword)
        user.setFullName(userFullName)
        user.save()

        def userMail = user.addProperty(new hudson.tasks.Mailer.UserProperty(userEmail))

        println "User " + userName +
            " has been updated with default password: " + userPassword + "."
    }
}

def PASSWORD_RESET = "false"
def USER_EMAIL = "{{ jenkins_remote_email }}"
def USER_PASSWORD = "{{ jenkins_remote_password }}"

allowPasswordReset = false
if (PASSWORD_RESET == "true") {
    allowPasswordReset = true
}

def userEmail = USER_EMAIL
def userName = userEmail.split("@")[0].toLowerCase()
def userNameParts = userName.split("[.]")

def userFirstName
def userSurName
if (userNameParts.size() > 1) {
    userFirstName = userNameParts[0].substring(0,1).toUpperCase() +
            userNameParts[0].substring(1)
    userSurName = userNameParts[1].substring(0,1).toUpperCase() +
            userNameParts[1].substring(1)
} else {
    userFirstName = userNameParts[0].substring(0,1).toUpperCase() +
            userNameParts[0].substring(1)
    userSurName = userFirstName
}
def userFullName = userFirstName + " " + userSurName

def userPassword = USER_PASSWORD
if (userPassword.length() == 0) {
    userPassword = generator((('a'..'z')+('A'..'Z')+('0'..'9')).join(), 12)
}

user = hudson.model.User.get(userName, false, null)

try {
    if (user != null) {
        user.impersonate()
    } else {
        println "User " + userName + " is not set!"
    }
} catch (org.acegisecurity.userdetails.UsernameNotFoundException e) {
    println "User " + userName + " is not set!"
    user = null
}

if (user != null) {
    if (allowPasswordReset) {
        println "User " + userName + " already exists!"
        User.createUser(userName, userFullName, userEmail, userPassword)
    } else {
        //throw new hudson.AbortException("User " + userName + " already exists!")
    }
} else {
    println "User " + userName + " doesn't exist."
    User.createUser(userName, userFullName, userEmail, userPassword)
}

def strategy = Jenkins.getInstance().authorizationStrategy

if (strategy instanceof GlobalMatrixAuthorizationStrategy) {
    def sid = "swarm"

    strategy.add(hudson.model.Computer.BUILD, sid)
    strategy.add(hudson.model.Computer.CONFIGURE, sid)
    strategy.add(hudson.model.Computer.CONNECT, sid)
    strategy.add(hudson.model.Computer.CREATE, sid)
    strategy.add(hudson.model.Computer.DELETE, sid)
    strategy.add(hudson.model.Computer.DISCONNECT, sid)
    strategy.add(hudson.model.Computer.EXTENDED_READ, sid)
}
