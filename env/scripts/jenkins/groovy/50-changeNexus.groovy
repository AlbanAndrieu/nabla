/*
 Changes default 'nexus' Maven settings by appending
 'preprod-' to repository URLs.
 */
import java.util.logging.Level
import java.util.logging.Logger

import jenkins.model.*

import org.jenkinsci.lib.configprovider.ConfigProvider
import org.jenkinsci.lib.configprovider.model.Config
import org.jenkinsci.plugins.configfiles.ConfigFilesManagement
import org.jenkinsci.plugins.configfiles.maven.MavenSettingsConfig
import org.jenkinsci.plugins.configfiles.maven.MavenSettingsConfig.MavenSettingsConfigProvider
import org.jenkinsci.plugins.configfiles.maven.security.ServerCredentialMapping

Logger LOGGER = Logger.getLogger(ConfigFilesManagement.class.getName())

def configProvider = ConfigProvider.getByIdOrNull(
         MavenSettingsConfig.class.getName())

def configName = "nexus"
def configId = ""

for (Config config: configProvider.getAllConfigs()) {
    if (config.name == configName) {
        configId = config.id
        break
    }
}

//def scriptDir = new File(getClass().protectionDomain.codeSource.location.path).parent
//def content = new File(scriptDir + '/settings.xml').text
def content = new File('~/settings.xml').text

if (configId) {
    def officialSettingsConfig = configProvider.getConfigById(configId)
    def preprodSettingsConfig = new MavenSettingsConfig(
            officialSettingsConfig.id,
            officialSettingsConfig.name,
            officialSettingsConfig.comment,
            content,
            //officialSettingsConfig.content.replace('{{ jenkins_remote_nexus_url_old }}', '{{ jenkins_remote_nexus_url_new }}'),
            Boolean.TRUE,
            Collections.<ServerCredentialMapping>emptyList())

    configProvider.save(preprodSettingsConfig)
    LOGGER.log(Level.INFO, "Configuration file altered matching: name == ${configName}")
} else {
    LOGGER.log(Level.ERROR, "No configuration file found matching: name == ${configName}")
}
