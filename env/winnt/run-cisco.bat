echo Install Cisco IP Communicator
REM http://www.cisco.com/c/en/us/products/collaboration-endpoints/ip-communicator/index.html
REM http://www.cisco.com/c/en/us/support/docs/voice-unified-communications/ip-communicator/50994-ip-communicator.html

REM http://10.0.2.15/

#Map drive to \\naspar2\PUBLIC\Cisco\Cisco ip com+agent desktop\ with user alban.andrieu@misys.com
Here you will find the software package (CiscoIPCommunicatorSetup.exe) and also the installation guide.
After the installation finishes, open IP Communicator, right click on it, and click on preferences.
Once you click preferences, you will get a screen with the "Network" tab.
Select the second option, "use this device name", and enter: CIPC-lemiere
For the TFTP servers, select "use these TFTP servers", and enter: 10.120.120.50 in the first field, and leave the second one blank (0.0.0.0)
Use this device name: CIPC-aandrieu
TFTP server 1: 10.120.120.50
