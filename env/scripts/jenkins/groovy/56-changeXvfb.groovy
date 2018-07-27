import jenkins.model.Jenkins
import org.jenkinsci.plugins.xvfb.*

def installation = new XvfbInstallation('{{ jenkins_remote_xvbf_name }}', '/usr/bin', null)

Jenkins.getInstance()
       .getDescriptorByType(Xvfb.XvfbBuildWrapperDescriptor.class)
       .setInstallations(installation)
