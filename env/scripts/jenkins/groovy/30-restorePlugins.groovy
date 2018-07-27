/*
 * Installs or updates Jenkins plugins based on
 * ThinBackup's "installPlugins.xml" file.
 */
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.logging.Level
import java.util.logging.Logger

import jenkins.model.Jenkins;
import hudson.PluginManager;
import hudson.model.Hudson;
import hudson.model.UpdateCenter;
import hudson.model.UpdateCenter.UpdateCenterJob;
import hudson.model.UpdateSite;
import hudson.model.UpdateSite.Plugin;
import hudson.model.UpdateCenter.UpdateCenterJob;
import hudson.model.UpdateCenter.DownloadJob;
import hudson.model.UpdateCenter.DownloadJob.InstallationStatus;
import hudson.model.UpdateCenter.DownloadJob.Pending;

import org.jvnet.hudson.plugins.thinbackup.backup.PluginList;

@Singleton
class PluginInstaller {
    enum State {
        NOTHING,
        INSTALL,
        UPDATE,
        ERROR
    }


    private static Logger LOGGER = Logger.getLogger(PluginInstaller.class.getName())


    private static def timeout = 10 * 1000 // 10 seconds


    private def load() {
        Jenkins.getInstance().getUpdateCenter().updateAllSites()
    }


    private def install(def name) {
        def pluginManager = Jenkins.getInstance().getPluginManager()
        def updateCenter = Jenkins.getInstance().getUpdateCenter()


        def wrapper = pluginManager.getPlugin(name)

        if (!wrapper) {
            def plugin = updateCenter.getPlugin(name)

            if(plugin) {
                plugin.deploy()
                LOGGER.info(name + " plugin is scheduled to be installed.")
                return PluginInstaller.State.INSTALL
            } else {
                LOGGER.severe(name + " plugin couldn't be found.")
                return PluginInstaller.State.ERROR
            }
        } else {
            if (wrapper.hasUpdate()) {
                def plugin = updateCenter.getPlugin(name)

                if(plugin) {
                    plugin.deploy()
                    LOGGER.info(name + " plugin is scheduled to be updated.")
                    return PluginInstaller.State.UPDATE
                } else {
                    LOGGER.severe(name + " plugin couldn't be updated.")
                    return PluginInstaller.State.ERROR
                }
            } else {
                LOGGER.info(name + " plugin is already in the latest version.")
                return PluginInstaller.State.NOTHING
            }
        }

        return PluginInstaller.State.NOTHING
    }


    private def save() {
        def pendingJobs = 1


        Jenkins.getInstance().save()

        while (pendingJobs) {
            pendingJobs = 0

            sleep(timeout)

            LOGGER.info("Checking pending jobs...")
            for (UpdateCenterJob job : Jenkins.getInstance().getUpdateCenter().getJobs()) {
                if (job instanceof DownloadJob) {
                    if (!job.status.isSuccess()) {
                        pendingJobs++
                    }
                }
            }

            LOGGER.warning("There are still ${pendingJobs} pending jobs...")
        }
    }


    private def restart() {
        Jenkins.getInstance().doSafeRestart()

        while (true) {
            LOGGER.warning("Jenkins is restarting...")
            sleep(timeout)
        }
    }

    static def run() {
        def installer = PluginInstaller.instance
        def restart = false

        installer.load()
        restart = ((installer.install("thinBackup") == PluginInstaller.State.UPDATE) || restart)

        if (!restart) {
            restart = !restart && installer.install("swarm") == PluginInstaller.State.UPDATE

            // Parse `installedPlugins.xml` file.
            File backupedPlugins = new File(Jenkins.getInstance().getRootDir(), "{{ jenkins_remote_installed_plugin }}")

            PluginList pluginList = new PluginList(backupedPlugins)
            pluginList.load()
            Map<String, String> toRestorePlugins = pluginList.getPlugins()

            // Install or Update required plugins.
            for (Entry<String, String> entry : toRestorePlugins.entrySet()) {
                def pluginName = entry.getKey()

                restart = ((installer.install(pluginName) == PluginInstaller.State.UPDATE) || restart)
            }
        }

        installer.save()

        if (restart) {
            installer.restart()
        }
    }
}

PluginInstaller.run()
