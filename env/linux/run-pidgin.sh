#!/bin/bash
set -xv

#messaging
#http://mylinuxbook.com/how-to-get-pidgin-working-with-gtalk/
sudo apt-get install pidgin pidgin-sipe pidgin-skype pidgin-indicator
#Add my google account

#Username alban.andrieu
#Domain nabla.mobi
#Resource home
#Resource: (left this blank as default)
#In advanced tab
#Connection security Use old-style SSL
#Connect port 5223
#Connect server  talk.google.com

#Add my misys account

#Protocol Office Communicator
#Username alban.andrieu@misys.com
#Login alban.andrieu@misys.com

#Add my Skype account

#Username alban.andrieu
#Local Alias Alban Andrieu

#Add my Facebook account
#http://www.webupd8.org/2015/08/use-facebook-chat-in-pidgin-with-purple.html
sudo sh -c "echo 'deb http://download.opensuse.org/repositories/home:/jgeboski/xUbuntu_$(lsb_release -rs)/ /' >> /etc/apt/sources.list.d/jgeboski.list"
cd /tmp && wget  http://download.opensuse.org/repositories/home:/jgeboski/xUbuntu_$(lsb_release -rs)/Release.key
sudo apt-key add - < Release.key  
sudo apt-get install purple-facebook
