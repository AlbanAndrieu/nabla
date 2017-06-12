#!/bin/bash
set -xv

#messaging
#http://mylinuxbook.com/how-to-get-pidgin-working-with-gtalk/
sudo apt-get install pidgin pidgin-sipe pidgin-skype pidgin-indicator

#Add my google account

#Using old XMPP
#Username alban.andrieu
#Domain nabla.mobi
#Resource home
#Resource: (left this blank as default)
#In advanced tab
#Connection security Use old-style SSL
#Connect port 5223
#Connect server talk.google.com

#See http://www.webupd8.org/2016/04/use-google-hangouts-with-extra-features.html
#go to https://accounts.google.com/o/oauth2/programmatic_auth?hl=en&scope=https%3A%2F%2Fwww.google.com%2Faccounts%2FOAuthLogin+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&client_id=936475272427.apps.googleusercontent.com&access_type=offline&delegated_client_id=183697946088-m3jnlsqshjhh5lbvg05k46q1k4qqtrgn.apps.googleusercontent.com&top_level_cookie=1
#set-cookie:oauth_code=4/5pjK8qCvxnWefvEuYC1tvQTWBHqAc5ujYGiToVaOhhw; Path=/; Secure; HttpOnly

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
sudo apt-get update
sudo apt-get install purple-facebook
