# Introduction #

Vision is to provide a framework of tools connected for a developer to work with efficiency.

  * Provided environment must be free (open source) and easily maintained.
  * It should be scalable for a larger structure.
  * Environment must be easily clone and recreated from scratch.
  * Each part of the environment can be extracted independently in order to be easily used within another context.
  * It should provide developer tools to work in collaboration with others.
  * It should be a the state of the arts and continuously maintained.

# Install workstation #

Install the image using :
  * CloneZilla via PXE

**Warning** Prepare a specific partition for the image because clonezilla will erase everything on it!

You should have a ready to use workstation ready in less than 30 minutes (depending on the size of the image and your network connection).

All the tools listed below have been configure to works together.

# Details #

Image contains the following :
  * Ubutu latest version
  * GParted/Synaptic/Samba/VNC
  * DHCP server with CloneZilla
  * LDAP (connected with NIS)
  * CROWD (connected to LDAP)
  * ALM Atlassian tools suite JIRA CONFLUENCE CRUCIBLE (connected with CROWD and SVN)
  * Sonar (connected to MySQL and Jenkins)
  * Jenkins (connected to CROWD, Maven, Scons, Quality tools, AWS)
  * Maven (connected to Nexus and Quality tools)
  * Quality tools are Coding style/Checkstyle/Findbugs integrated with Maven/Jenkins/Eclipse (Mutation testing, Cargo deploy)
  * MySQL database
  * Eclipse (connected to SVN, Maven, Scons, Sonar, Quality tools, Jenkins, JIRA)
  * Apache with PHP : phpMyAdmin phpldapadmin (Apache as a reverse proxy with SSL)
  * SVN/GIT repository tools
  * Owncloud (with GoogleDrive and DropBox)
  * ZFS, Synergy, Perl, Python, Ansible, Webmin, Usermin, Disk quota, Nagios or Zabbix, Cacti, Geany...

# What should be possible #

  * Easily switch C++ build from CMake to Scons
  * Switch from JIRA to BugZilla.
  * Switch Confluence to MediaWiki
  * Switch SVN to GIT

# System administration toolbox #

Usefull live CD can be found at : http://livecdlist.com/ultimate-boot-cd
or http://livecdlist.com/parted-magic which is smaller

# Ansible #

Each shareable features has been put in a separated role : ZFS, JBoss, Tomcat, MySQL Jenkins, Sonar, Nexus.

In order to run Ansible script to configure your workstation, please do the following:

```
cd env/ansible/
./setup.sh
```

# TODO #

Add Eclipse role
Create cerficate for SSL.
Easily deactivate features like NIS, DHCP, ALM tools (All those feature cannot run all together on my Laptop)