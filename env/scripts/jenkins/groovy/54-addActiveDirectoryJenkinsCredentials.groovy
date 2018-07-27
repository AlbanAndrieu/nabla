import groovy.json.JsonSlurper

import hudson.*
import jenkins.*
import jenkins.model.Jenkins

import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

def credentials = new JsonSlurper().parse(
        new File(Jenkins.getInstance().getRootDir(), "{{ jenkins_remote_active_directory_credentials }}"))

credentials.each() { cred ->
    Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(
            CredentialsScope.GLOBAL,
            cred.id,
            cred.description,
            cred.username,
            cred.password)

    SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)
}
