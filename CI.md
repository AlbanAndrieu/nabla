# Introduction #

# Jenkins #

See sample [Jenkins Nabla](http://home.nabla.mobi:8380/jenkins)

Add in maven :
  * -s ${WORKSPACE}/.m2/settings.xml
  * maven.repo.local=~/.m2/repository
  * -Xms256m -Xmx512m -XX:PermSize=80M -XX:MaxPermSize=256M
  * -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby

Do not use goals (it does not works) :
  * javancss:report
  * jdepend:generate

Do not use report (it does not works) :
  * JavaNCSS
  * JDepend

For clover and dashboard add :
  * java.awt.headless=true

# Sonar #

See sample [Sonar Nabla](http://home.nabla.mobi:9000/)

## Ubuntu ##

Install Jenkins on ubuntu

```
sudo apt-get install jenkins
```

# Jenkins best practices #

How to use Jenkins for Nabla project.
Please have a look to following best practices at : http://narkisr.github.io/jenkins-scaling/

Jenkins High Availability with gearman.
See http://gearman.org/getting-started/
And https://wiki.jenkins-ci.org/display/JENKINS/Gearman+Plugin

Redundancy with Heartbeat and Mon at : http://wiki.monitoring-fr.org/opennms/redondance

# Jenkins Plugins used #

See file : installedPlugins.xml

# TODO #
Selenium and Fitness