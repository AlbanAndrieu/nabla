# nabla-project-interview-visma
Java project for an interview request for visma

The challenge
================

Here is the programming challenge:

### Payment schedule

Problem Description
 
    Below, please find a simple development task which we use for new employments in the development department. 
    
    The task should be solved using Java.
    The solution should be returned with full source and if possible also as an executable under Windows or on a web server accessible using MS Internet Explorer.
     
    Programming test 
    Create a simple application which can be used for calculation of the cost from a housing loan.
     
    The application should have a simple user interface where the user can specify the desired amount and the payback time in years. 
    For simplicity we assume a fixed interest of 5.5% per year during the complete payback time. 
    The interest should be connected to the loan type in such a manner that different loan types can have different interests. 
    When selecting amount and payback time, the application should generate a monthly payback plan based on the series loan principle, i.e. you pay back an equal amount each month and add the generated interest. 
    The interest is calculated every month.
     
    The application should be made in such a manner that it can easily be extended to calculate a payment plan for other types of loans, for instance car loan, spending loan etc. with different interests. Also bear in mind that it should be easy to extend the application to cover other payback schemes as well. We do not expect this to be implemented.
     
    Feel free to choose this being a desktop application or a web application, but we expect that you demonstrate reasonable use of the available language functionality for abstraction, interfaces, inheritance, a good class structure and show a good programming practice. We are focused on code quality and good design, so it is nice if you add a design sketch. 
    You will not be judged for correctness in the interest calculation or a fancy GUI:

------------------

### Result

Please find below output of this sample:

- Source code repository : [github](https://github.com/AlbanAndrieu/nabla-project-interview-visma)

- Jenkins : [jenkins](http://home.nabla.mobi:8380/jenkins/job/nabla-project-interview-visma/) 

- Sonar metrics : [sonar](http://home.nabla.mobi:9000/dashboard/index/2831)

Remarks : visma installer is produced during the jenkins build , especially [here](http://home.nabla.mobi:8380/jenkins/job/nabla-installer-visma/).
In order to install, double click on the [VISMAInstaller.jar](http://home.nabla.mobi:8380/jenkins/job/nabla-installer-visma/lastSuccessfulBuild/artifact/visma-installer/target/VISMAInstaller.jar)

On unix, please make sure you can execute the installer :

    chmod 777 VISMAInstaller.jar
    sudo ./VISMAInstaller.jar
    
Once installed :

    cd /usr/local/visma-installer-1.0.1-SNAPSHOT
    sudo chmod 777 ./run.sh
    sudo ./run.sh start
    
You can find a basic GUI at http://localhost:9090/loan.xhtml
Enjoy!!!

------------------

Other resources can be found on my [googlecode](https://code.google.com/p/alban/w/list) wiki:

- Set up your workstation : [workstation](https://github.com/AlbanAndrieu/ansible-workstation) 

- Set up your build environement : [servers](https://github.com/AlbanAndrieu/ansible-nabla) 

- Nexus : [nexus](http://home.nabla.mobi:8081/nexus/index.html#welcome)

- Phpmyadmin : [phpmyadmin](http://home.nabla.mobi:7070/phpmyadmin)

Only for local user to the network :

- Elasticsearch / Logstash / Kibana: [logstash](http://192.168.0.29:80/)

- Monit monitoring: [monit](http://192.168.0.29:3737)

- Mon monitoring: [mon](http://192.168.0.29:7070/cgi-bin/mon.cgi)

- Supervisor: [supervisor](http://192.168.0.29:9042/)

- Statistic : [awstats](http://192.168.0.29:7070/cgi-bin/awstats.pl?config=home.nabla.mobi)

- Disk usage : [philesight](http://192.168.0.29:7070/cgi-bin/philesight.cgi)

------------------

### My opensource projects

On GitHub I have mostly Ansible roles. 

I am trying to contribute as much as possible (instead of creating new project).

All the roles I am using are gathered inside this one https://github.com/AlbanAndrieu/ansible-nabla which is using them as git submodule.

This role is creating an Continuous Delivery build farm and everything needed for a dev, sysadmin, qa, ui, release manager guy to work.

Jenkins, Sonar, Nexus, Docker, Eclipse, Logstash. 

You will even have stuff like Eclipse (with basic plugins), ZaProxy, Jmeter, VisualVM tools, and a FrontEnd Apache with mod pagespeed, fail2ban, DeniedOfService, AWStats, a Varnish load balancer, Zabbix, Mon, Monit, Supervisor, Jboss, Tomcat, Selenium and Xvfb ready and more.

Mostly, there is a bit more than the basic tools for a production, staging, dev environment all setted to work together with as much security as possible.


My "old" project https://code.google.com/p/alban/ which is using http://www.andromda.org/index.html is an UML code generator. 
I am now more using this project because it generate a lot of code and it is resource demanding for my devops environment. 
This project is using JBoss, Seam, Hibernate, Spring,GWT, JSF, Arquillian, ... So it was is quite hard to get Jacoco with mutation testing working with it.

Have a quick look at the below project (it has some of the quality metric that I am using at work, like unit test, integration test, mutation test, perf test, load testing, end2end test, functional testing)
Jenkins -> http://home.nabla.mobi:8380/jenkins/job/nabla-project-interview-visma/
Sonar -> http://home.nabla.mobi:9000/dashboard/index/418

Visma is a very basic code done for an interview that you can easilly install using IZPack at http://home.nabla.mobi:8380/jenkins/job/nabla-installer-visma/lastSuccessfulBuild/artifact/visma-installer/target/ 
Goal is to provide an easy maven starter with basic integration and metric for any code interview working.
Goal is also to have as much testing tools ready to work altogether (like junit, mock, selenium, cucumber). Because there is always one incompatiblity between them...
GUI is working on jetty! It is basic, but it has coverage, debug mode, monitoring (JMX and NewRelic) and even some perf testing.
Code is not yet using the best tool like REST, and AngularJS and has no database. 
It is just not realistic to have the cutting edge technology for an interview whithin a few hours.
So at least a dev can mesure quality of his work.
It takes 1 hour to build for 1000 line of code on an old laptop...

Because writing code is just one step among the others : building, testing, releasing, packaging, deploying, monitoring
But I keep thinking that a developer who his not using great tools cannot be a great developer.

Thanks for reading

***

Alban Andrieu
fr.linkedin.com/in/nabla/
