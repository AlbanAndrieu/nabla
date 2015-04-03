# Introduction #

It is assumed here that you already have a running [Glassfish](http://glassfish.java.dev.net) instance. While developing we used version 2.1 so it is garantueed to work with that version.

  1. Checkout the code from the repository
  1. run 'mvn clean install'
  1. start database
    * goto $J2EE\_HOME/javadb/bin
    * run 'startNetworkServer.bat'
  1. goto the checkout directory again
  1. goto the setup directory
  1. run 'setup.bat'
  1. goto apps directory
  1. run mvn clean install
  1. run mvn glassfish:deploy
  1. Open webbrowser and goto http://localhost:8090/ab

That should be it to run and deploy the application. For all the steps taken this is the same. (Check the branches in subversion to checkout a certain step).