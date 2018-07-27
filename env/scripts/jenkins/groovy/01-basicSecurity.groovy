#!groovy
import hudson.security.*
import jenkins.model.*

def instance = Jenkins.getInstance()

//println "--> Checking if security has been set already"

//if (!instance.isUseSecurity()) {
    println "--> creating local user 'admin'"

    def hudsonRealm = new HudsonPrivateSecurityRealm(false)
    hudsonRealm.createAccount('{{ jenkins_admin_username }}', '{{ jenkins_admin_password }}')
    instance.setSecurityRealm(hudsonRealm)

    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    //def strategy = new GlobalMatrixAuthorizationStrategy()
    //strategy.add(Jenkins.ADMINISTER, "admin")
    instance.setAuthorizationStrategy(strategy)

    instance.save()
//}


def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

jenkinsLocationConfiguration.setAdminAddress("Admin {{jenkins_system_config.admin_email}}")

jenkinsLocationConfiguration.save()
