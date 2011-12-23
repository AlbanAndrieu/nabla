Installation Domain KarmaSample
1. Extract the karmaSample.zip into your favourite installation Jboss ex: C:\jboss-4.2.2.GA\server
2. Go to JBOSS_INSTALLATION\server\karmaSample
3. Double-click on run.bat script (a command line window will open), the application webserver will be launched.
When the message "INFO  [Server] JBoss (MX MicroKernel) [4.2.2.GA (build: SVNTag=JBoss_4_2_2_GA date=...)] Started in ..." appears on the command line, 
4.Open an internet explorer windows then go to http://localhost:8180/karma
5.Finally, click on Login (You don't need username or password)
6.If you want to change the port 8180, you have to edit the port-bindings-service.xml:
- Go to  <server name="karma">
- At the line : 
<service-config name="jboss.mq:service=InvocationLayer,type=HTTP"
    delegateClass="org.jboss.services.binding.AttributeMappingDelegate">
    <delegate-config portName="URLPort"/>
    <binding port="8180"/>
</service-config>
- Change the port 8180 into you specific port. 
- Do not use the following ports : 8183, 3973, 1199, 4544, 4545, 1200, 4544, 4548, 3628, 19101, 1262, 1261, 8193