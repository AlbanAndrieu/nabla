# Introduction #

How to install and configure eclipse.

# JAVA Installation #

Download Eclipse Indigo (Eclipse IDE for Java EE Developers, 212 MB) for
Windows 32 Bit at :
http://www.eclipse.org/downloads/

Unzip and install it to :
C:\eclipse-j2ee-3.7

Create a workspace folder at :
C:\workspace\users\workspace-eclipsej2ee3.7-application

Once started update eclipse.

To do so go to menu and click :
Help > Check for Updates

# C++ Installation #

Download Eclipse Indigo : Eclipse IDE for C/C++ Developers (includes Incubating components), 108 MB) for
Windows 32 Bit at :
http://www.eclipse.org/downloads/

Unzip and install it to :
C:\eclipse-cpp-3.7

Create a workspace folder at :
C:\workspace\users\workspace-eclipse-cpp-3.7-application

Once started update eclipse.

To do so go to menu and click :
Help > Check for Updates

# JAVA Plugins #

Install usefull plugins.

Go to menu and click :
Help > Eclipse Marketplace...

http://marketplace.eclipse.org/

Plugins on Marketplace are :
  * JBoss Tools
  * Subversive with SVNKit or Subclipse 1.10.05
  * Groovy-Eclipse for Juno 2.7.1
  * PyDev
  * EPIC (Perl)
  * Maven Integration for Eclipse 1.5
  * Scala IDE 3.0.x
  * Java Profiler 10.7 (VisualVM)

Do not install (it failed with maven integration plugin)
  * SonarQube 3.4.0

If plugins not found on Eclipse Marketplace, go to :
Help > Install New Software...

Plugins links are :
  * Maven Integration for Eclipse Update Site - http://download.eclipse.org/technology/m2e/releases
  * Maven Integration for Eclipse Update Extras Site - http://m2eclipse.sonatype.org/sites/m2e-extras
  * Google Update Site for Eclipse 3.7 - http://dl.google.com/eclipse/plugin/3.7
  * CheckStyle - http://eclipse-cs.sf.net/update
  * FindBugs - http://findbugs.cs.umd.edu/eclipse
  * EclEmma - http://update.eclemma.org
  * PMD - http://pmd.sf.net/eclipse
  * VeloEdit - http://veloedit.sourceforge.net/updates
  * Hudson - http://hudson-eclipse.googlecode.com/svn/trunk/hudson-update
  * Sonar Integration for Eclipse (update-site) - http://dist.sonar-ide.codehaus.org/eclipse
  * TestNG (go to : http://marketplace.eclipse.org/content/testng-eclipse)
  * Clover -  http://update.atlassian.com/eclipse/clover
  * m2e-scala - http://alchim31.free.fr/m2e-scala/update-site/
  * yourkit - http://www.yourkit.com/download/yjp2014_for_eclipse/

# C++ Plugins #

Install usefull plugins.

Go to menu and click :
Help > Eclipse Marketplace...

http://marketplace.eclipse.org/

Plugins on Marketplace are :
  * CMakeEd : http://cmakeed.sourceforge.net/eclipse/

If plugins not found on Eclipse Marketplace, go to :
Help > Install New Software...

Plugins links are :
  * SConsolidator - http://www.sconsolidator.com/update (http://scons.org/wiki/EclipsePlugin)
  * Python Dev - http://pydev.org/updates
  * EPIC Perl - http://e-p-i-c.sf.net/updates

# Settings #

Usefull settings.

Go to :
Windows > Preferences...
  * General -> Show heap status
  * General -> Editors -> Text Editors -> Show line numbers
  * Install/Updates -> Automatic updates -> Automatic find new updates and notify me
  * Install/Updates -> Automatic updates -> Download new updates automatically...
  * Java -> Installed JREs -> Add... Standard VM C:\Program Files (x86)\Java\jre6

# Hibernate/JPA #

Add Hibernate Configuration
In prpject properties
  * Hibernate Settings -> Enable Hibernate support
  * Hibernate Configuration -> Common -> Shared file -> select your project
  * Hibernate Configuration -> Options-> Database Dialect -> H2
  * Hibernate Configuration -> Main-> Type -> JPA
  * Hibernate Configuration -> Main-> Hibernate Version -> 3.6
  * Hibernate Configuration -> Main-> Database connection -> H2 Generic JDBC
  * Hibernate Configuration -> Main-> Property file -> \your project\hibernate-console.properties
  * Hibernate Configuration -> Main-> Persistence Unit -> your persistence unit

Add JPA Facet
  * Platform Generic 2.0
  * JPA Implementation -> Disable Library Configuration
  * JPA Implementation -> Connection -> H2 Generic JDBC

Commit generated file :
  * your project-1.0.launch
  * hibernate-console.properties