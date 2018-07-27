import jenkins.*
import jenkins.model.Jenkins
import hudson.tools.JDKInstaller

def jdkInstallerDesc = Jenkins.getInstance().getDescriptor(JDKInstaller.class)
//jdkInstallerDesc.doPostCredential('lukasz.zachulski@misys.com', '123Aanaliza')
