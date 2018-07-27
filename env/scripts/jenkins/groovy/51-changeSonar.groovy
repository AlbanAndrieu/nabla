import jenkins.model.*
import hudson.plugins.sonar.*
import hudson.plugins.sonar.model.*

def globalConfig = Jenkins.getInstance().getDescriptor(SonarGlobalConfiguration.class)

def defaultInstallation = SonarInstallation.get('{{ jenkins_remote_sonar_name }}')
def installation = new SonarInstallation(
        defaultInstallation.getName(),
	    defaultInstallation.getServerUrl().replace('{{ jenkins_remote_sonar_url_old }}', '{{ jenkins_remote_sonar_url_new }}'),
        defaultInstallation.getServerVersion(),
        "",
        '{{ jenkins_remote_sonar_jdbc }}',
        defaultInstallation.getDatabaseLogin(),
        defaultInstallation.getDatabasePassword(),
        defaultInstallation.getMojoVersion(),
	    defaultInstallation.getAdditionalProperties(),
        new TriggersConfig(),
        defaultInstallation.getSonarLogin(),
        defaultInstallation.getSonarPassword(),
        "")

globalConfig.setInstallations(installation)
globalConfig.save()
