#!/bin/bash
set -xv

#See https://code.vmware.com/web/dp/tool/cloudclient/4.4.0
#See https://github.com/jakkulabs/PowervRA

#See https://github.com/jenkinsci/vmware-vrealize-automation-plugin/blob/master/README.md
#See https://theithollow.com/2016/05/02/use-vrealize-automation-jenkins/

#We have 5 jump hosts what we are using for remote access (RDP). I have added the above security group as Local Administrators on these host, so all of the above user can login.
#In these machines we have all the tools what needed for fixing broken machines and can access vCenters from. See machine details below:

#Jump Host

#IP
#fr.albandrieu.com

#The above security group was added to vCenters in (Paris, Bangalore, Gdynia, Manila, UK).
#Group members can connect to our vCenters and will be able to access VM console and able to manipulate with VMs.
#See connection details below:

#Location
##vCenter URL

#IP
#Paris

#https://parvcf.albandrieu.com/ui/

exit 0
