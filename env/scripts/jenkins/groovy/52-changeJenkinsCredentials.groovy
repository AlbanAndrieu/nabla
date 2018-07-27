import hudson.*
import jenkins.*
import jenkins.model.Jenkins

import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey
import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey.FileOnMasterPrivateKeySource
import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.CredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain

def creds = CredentialsProvider.lookupCredentials(
        com.cloudbees.plugins.credentials.common.StandardUsernameCredentials.class,
        Jenkins.getInstance(),
        null,
        null)

for (c in creds) {
    println(c.id + ": " + c.description + ", " + c.getClass().getName())
    if (c instanceof BasicSSHUserPrivateKey) {
        //if (c.id in ['0cf26350-00db-4398-8a57-10fb4d38769a','99f9a06d-0747-45e9-8092-4d155376010f']) {
        //    def sshCredentials = new BasicSSHUserPrivateKey(
        //            c.getScope(),
        //            c.getId(),
        //            c.getUsername(),
        //            new FileOnMasterPrivateKeySource('/var/jenkins_home/.ssh-keys/id_rsa'),
        //            c.getPassphrase().getPlainText(),
        //            c.getDescription())
        //
        //    SystemCredentialsProvider.StoreImpl store = new SystemCredentialsProvider.StoreImpl()
        //    store.updateCredentials(Domain.global(), c, sshCredentials)
        //}
    }
}
