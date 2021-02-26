#!/bin/bash
set -xv

sudo apt-get install libpam-oath

sudo nano /etc/pam.d/sshd
@include common-auth
#To also enable one-time password authentication, add the following two lines.

#One-time password authentication via Google Authenticator
#auth required pam_google_authenticator.so
auth sufficient pam_oath.so usersfile=/etc/users.oath window=10 digits=6

sudo touch /etc/users.oath
sudo chmod go-rw /etc/users.oath

# ON play store install freeotp plus
#OR
#See https://www.linuxbabe.com/ubuntu/two-factor-authentication-ssh-key-ubuntu
sudo apt install libpam-google-authenticator

sudo apt-get install oathtool caca-utils qrencode

git clone https://github.com/mcepl/gen-oath-safe.git
gen-oath-safe/gen-oath-safe aandrieu totp

sudo nano /etc/ssh/sshd_config
#UsePAM yes
#ChallengeResponseAuthentication yes
#AuthenticationMethods publickey,keyboard-interactive
sudo systemctl restart sshd.service

exit 0
