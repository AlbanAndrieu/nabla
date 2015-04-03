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

# CONTINUOUS INTEGRATION #

See sample [Jenkins Nabla](https://home.nabla.mobi/jenkins/)

# IN PROGRESS #

  * Finalize the timetracker-ejb3 project.
> > Run with :
> > - Integrate Ansible POC (with all javascripts tooling)
> > - Automatic deploy to JBoss 5.1.0.GA
> > - Eclipse 3.7 with JBoss Tools plugins
> > - H2 Database with Hibernate to create drop database and insert basic data (all hibernate database supported).
> > - EJB 3 - JPA - Seam with OpenEJB for automate test
> > - Possibility to call Service from GWT 2.4 (not generated automatically by the cardrige yet)
> > - Gui JSP/Facelets Richfaces (not generated automatically by the cardrige yet)

# TODO #

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