# nabla

### Migration
Automatically exported from code.google.com/p/alban
BUT divided in git submodule project :
https://github.com/search?utf8=%E2%9C%93&q=user%3AAlbanAndrieu+nabla-&type=Repositories&ref=searchresults

### Description

I have created a Mavenized AndroMDA project based on the Timetracker sample.

Main goals of this project are :
 * From an UML2 model sample, the "Timetracker" generate java code
 * Use this model (the same) to generate code with different AndroMDA cartridges
 * Have a full mavenized project, using the best maven features with site generation, sonar, nexus, JIRA, Confluence, Crucible, Fisheyes, Stahs, Crowd, OpenGrok ...) fully integrated with eclipse 3.7 on an ubuntu 13
 * Full automation using Ansible around Jenkins, Build farm easily scalable with AWS EC2 instance
 * A enhanced copy of the AndroMDA project have released as 3.4 (to be get rid of the SNAPSHOT version)
 * Use the AndroMDA EJB3 - Seam cartridges
 * Use/Create an AndroMDA GWT - (Seam/Errai) cartridges
 * Use/Create an Ansible, NodeJs - (Seam/Errai) cartridges
 * Use OpenEJB/Tomcat 7, JBoss 5x,7x, Jetty with cargo
 * Unit testing, integration testing, functional testing, end to end testing, mutation testing (using PIT), TestNG, DBUnit, Selenium HQ, WebDriver, RemoteWebDriver (Grid), NodeJs, npm, yeoman, grunt, bower, karma, phantomJS, Jasmine, Fitness...
 * Use Oracle, Sybase, MySQL, Derby, H2
 * Use JBPM, Drools, Seam/Errai...
 * Use OSGI and SSO
 * Use best practice as much as possible

I felt that it was only right to make the project available to the public, and put together a google code project, as everything I used are OpenSource.

As of now the project is aimed at running on the any of Jetty/JBoss-7.1.1.x/Tomcat application servers deployed as an war project. Project must also not be tied to any database.

We welcome fellow AndroMDA + Seam + Maven fans to this project. Whether you want to use ideas in this project to develop your own projects, or you want to contribute to the project, we invite you to check out the code.

CheckOut

= CONTINUOUS INTEGRATION =

See sample [https://home.nabla.mobi/jenkins/ Jenkins Nabla]

= IN PROGRESS =

 * Finalize the timetracker-ejb3 project.
  Run with :
  - Integrate Ansible POC (with all javascripts tooling)
  - Automatic deploy to JBoss 5.1.0.GA
  - Eclipse 3.7 with JBoss Tools plugins
  - H2 Database with Hibernate to create drop database and insert basic data (all hibernate database supported).
  - EJB 3 - JPA - Seam with OpenEJB for automate test
  - Possibility to call Service from GWT 2.4 (not generated automatically by the cardrige yet)
  - Gui JSP/Facelets Richfaces (not generated automatically by the cardrige yet)

= TODO =

 * JBoss 7.x as is it much quicker to launch (fix EJB issues with Arquillian)
 * Selenium not working with latest version of firefox (26) on Ubuntu 13
 * Get newrelic license for opensource project
 * Find better performance tools than JunitPerf and Jmeter
 * Find testing tools for Repsonsive Design like bootstrap on Mobile/iPad
 * Jasmine vs Fitness POC
 * Add OpenEJB to Tomcat 7
 * Add JBPM, Drools
 * Finish OSGI and SSO POC (add facebook and google account connection)
 * Improve threading with java 7 ConcurrentHashMap with guava (cf book Well Grounded Java Developer)
 * Improve UML generator using Java MethodHandler to use less PermGenSpace
 * Try to integrate galaxy ansible with openstack
 * Use https://code.google.com/p/google-styleguide/

### Eclipse

How to install and configure eclipse.

#### JAVA Installation

Use https://github.com/AlbanAndrieu/ansible-eclipse

It will download and install eclipse on your Ubuntu workstation

For windows:

Download Eclipse Indigo (Eclipse IDE for Java EE Developers, 212 MB) for Windows 32 Bit at : http://www.eclipse.org/downloads/

Unzip and install it to : C:\eclipse-j2ee-3.7

Create a workspace folder at : C:\workspace\users\workspace-eclipsej2ee3.7-application

Once started update eclipse.

To do so go to menu and click : Help > Check for Updates

#### C++ Installation

Download Eclipse Indigo : Eclipse IDE for C/C++ Developers (includes Incubating components), 108 MB) for Windows 32 Bit at : http://www.eclipse.org/downloads/

Unzip and install it to : C:\eclipse-cpp-3.7

Create a workspace folder at : C:\workspace\users\workspace-eclipse-cpp-3.7-application

Once started update eclipse.

To do so go to menu and click : Help > Check for Updates

JAVA Plugins
Install usefull plugins.

Go to menu and click : Help > Eclipse Marketplace...

http://marketplace.eclipse.org/

Plugins on Marketplace are :

 * JBoss Tools
 * Subversive with SVNKit or Subclipse 1.10.05
 * Groovy/Grails Tool Suite (GGTS) for Eclipse 3.6.4.RELEASE
   - Groovy-Eclipse for Juno 2.7.1
 * PyDev
 * EPIC (Perl)
 * Maven Integration for Eclipse 1.5
 * Scala IDE 3.0.x
 * Java Profiler 10.7 (VisualVM)
 * Yedit 1.0.14 (YAML)
 * Enide Studio 2014 (NodeJS http://www.nodeclipse.org/history)
 * Do not install (it failed with maven integration plugin)
 * Bytecode Visualizer
 * Sourcecode Visualizer
 * Memory Analyzer

SonarQube 3.4.0
If plugins not found on Eclipse Marketplace, go to : Help > Install New Software...

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
 * Clover - http://update.atlassian.com/eclipse/clover
 * m2e-scala - http://alchim31.free.fr/m2e-scala/update-site/
 * yourkit - http://www.yourkit.com/download/yjp2014_for_eclipse/
 * C++ Plugins
 * NOK not a free solution - C++ linticator (go to : http://linticator.com/projects/linticator/wiki/Installation) - http://linticator.com/update/v0/
 * Install usefull plugins.

Go to menu and click : Help > Eclipse Marketplace...

http://marketplace.eclipse.org/

Plugins on Marketplace are :

 * CMakeEd : http://cmakeed.sourceforge.net/eclipse/

If plugins not found on Eclipse Marketplace, go to : Help > Install New Software...

Plugins links are :

 * SConsolidator - http://www.sconsolidator.com/update (http://scons.org/wiki/EclipsePlugin)
 * Python Dev - http://pydev.org/updates
 * EPIC Perl - http://e-p-i-c.sf.net/updates

#### Settings

Usefull settings.

Go to : Windows > Preferences...

 * General -> Show heap status
 * General -> Editors -> Text Editors -> Show line numbers
 * Install/Updates -> Automatic updates -> Automatic find new updates and notify me
 * Install/Updates -> Automatic updates -> Download new updates automatically...
 * Java -> Installed JREs -> Add... Standard VM C:\Program Files (x86)\Java\jre6

##### Hibernate/JPA

Add Hibernate Configuration In prpject properties

 * Hibernate Settings -> Enable Hibernate support
 * Hibernate Configuration -> Common -> Shared file -> select your project
 * Hibernate Configuration -> Options-> Database Dialect -> H2
 * Hibernate Configuration -> Main-> Type -> JPA
 * Hibernate Configuration -> Main-> Hibernate Version -> 3.6
 * Hibernate Configuration -> Main-> Database connection -> H2 Generic JDBC
 * Hibernate Configuration -> Main-> Property file -> \your project\hibernate-console.properties
 * Hibernate Configuration -> Main-> Persistence Unit -> your persistence unit
 * Add JPA Facet

Platform Generic 2.0

 * JPA Implementation -> Disable Library Configuration
 * JPA Implementation -> Connection -> H2 Generic JDBC

Commit generated file :

your project-1.0.launch
hibernate-console.properties
