# Introduction #

Below are listed what I did on ubuntu.
Kind of reminder...

# Basics #

Ubuntu + ZFS native + root filesystem
[here](http://blog.blinkss.com/42577898)

## Add a user ##

```
sudo adduser albandri
sudo gedit /etc/passwd
#change /home/albandri by /workspace/users/albandri10 in /etc/passwd
```

## Prepare workspace ##

```
cd /
sudo mkdir repo
sudo mkdir -p /workspace/users/albandri10
cd /workspace/users/
sudo chown -R albandri.root albandri10/
```

## Package install ##

```
sudo apt-get install xxdiff nis ntp autofs tcsh libssl log4cxx curl
sudo apt-get install fuse libfuse2 libfuse-dev build-essential cifs-utils
sudo apt-get autoremove
```

## How to grant yourself sudoer rights ##

The sudo command allow to temparily elevate your privilege to execute administrative commands. This avoid having to login as root.

Notes: we use visudo to edit **/etc/sudoers** because it checks that the change are correct before saving.

```
su – root
visudo
```

Then add the following line at the end of the file, replacing baplepil by your login. Remarks: this is a tab after your login. (type ':i' to pass in insert mode, then go to the end of the file using arrow key and type the text. Then ESC+':x' to save, or ESC+':q!' to exit and discard.)

albandri ALL=(ALL) NOPASSWD: ALL

or the line below if you prefer input your password each time you do a sudo:

```
albandri ALL=(ALL) ALL
```

# Development tools #

## Install CloneZilla ##

Install CloneZilla [here](http://wi-phye.com/featured/how-to-setup-clonezilla-on-linux-ubuntu-quick-start-guide/)

or

Install CloneZilla Live [here](http://clonezilla.org/clonezilla-live.php) with [tuxboot](http://tuxboot.org/about/) on a USB key


## Install Maven 3 ##

[maven-3-install](http://yarovoy.com/post/14363197336/maven-how-to-install-maven-3-on-ubuntu-11-10)