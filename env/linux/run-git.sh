#!/bin/bash
set -xv

#http://tutoriels.itaapy.com/wiki/tutoriel-git/

sudo apt-get install git-core git-doc git-email gitweb gitk

sudo gem install git-smart
#in order to use git smart-pull

#enhance prompt
curl https://raw.github.com/git/git/master/contrib/completion/git-prompt.sh -o ~/.git-prompt.sh
nano .bashrc
source ~/.git-prompt.sh
PS1='\[\e[1;32m\][\u\[\e[m\]@\[\e[1;33m\]\h\[\e[1;34m\] \w]\[\e[1;36m\] $(__git_ps1 " (%s)") \$\[\e[1;37m\] '

ssh-keygen -t rsa -b 4096 -C "your_email@example.com"

git config --global user.email "alban.andrieu@free.fr"
git config --global user.name "Andrieu, Alban"
git config --global core.autocrlf input
#git config --global credential.helper 'cache --timeout=86400' # 86400 seconds is 24 hours
#git config --global credential.helper 'cache --timeout=3600' # 1 hour
git config --unset credential.helper
git config --global credential.helper store

git config --global help.autocorrect 8
git config --global color.ui auto
git config --global branch.master.rebase true
git config --global branch.autosetuprebase always
#git mergetool --tool-help
#git config --global merge.tool kdiff3
git config --global merge.tool meld
#git config --global difftool.prompt false
git config --global push.default simple
git config --globa merge.renamelimit 10000
git config --global --list
#git config --global http.postBuffer 157286400
#See https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration#Formatting-and-Whitespace
#git config --global core.whitespace trailing-space,-space-before-tab,indent-with-non-tab,tab-in-indent,cr-at-eol
git config --global core.whitespace trailing-space,-space-before-tab,indent-with-non-tab,cr-at-eol

#for Windows
git config --global http.sslVerify false
git config --system core.longpaths true
git config --global pack.packsizelimit 2g
git config --system core.autocrlf false

# For issue https://github.com/git-lfs/git-lfs/issues/3171
git config lfs.contenttype 0
#git config core.ignoreStat true
#git config core.fscache true

#See http://omerkatz.com/blog/2013/5/23/git-hooks-part-2-implementing-git-hooks-using-python
git config --global init.templatedir /workspace/users/albandri30/nabla-hooks/hooks

git config user.email "alban.andrieu@free.fr"
git config user.name "Andrieu, Alban"
git config --local -l

#for maven
git config --global maven-scm.maildomain nabla.mobi
git config --global maven-scm.forceUsername true

git remote --verbose

#See hook https://dzone.com/articles/an-in-depth-look-at-git-hooks
cp hook/* .git/hooks
#chmod +x prepare-commit-msg

#Use meld
git config --global diff.external meld

git difftool
#disable meld
git diff --no-ext-diff

#JIRA
#https://pypi.python.org/pypi/jira/
#https://github.com/pycontribs/jira
#https://jira.readthedocs.io/en/master/examples.html#transitions

#See http://pre-commit.com/#advanced
sudo pip install pre-commit
sudo pip install pre-commit-hooks
#pre-commit install
pre-commit autoupdate

pre-commit run --all-files
#pre-commit run

#Jenkins declarative pipeline and BitBucker
#Please note that I have followed : https://community.atlassian.com/t5/Bitbucket-questions/Bitbucket-Server-integration-with-jenkins/qaq-p/307023
#
#For triggering build in Jenkins automatically once changes done into Bitbucket SCM you have to install
#
#1. "Bitbucket Server Webhook to Jenkins" in Bitbucket ...
#2. If already installed then you have to enable "Post Receive" Hook on that particular repo.
#3. Once you are done this In Jenkins Job you have to add "poll SCM".

#Revert a revert
#git reset --hard f357b81dc4c
#git reset --soft HEAD@{1}
#git commit -m "Revert to f357b81dc4c"

#gitlab-ee
#https://about.gitlab.com/installation/#ubuntu
#curl https://packages.gitlab.com/install/repositories/gitlab/gitlab-ee/script.deb.sh | sudo bash
#sudo EXTERNAL_URL="https://gitlab.com/AlbanAndrieu" apt-get install gitlab-ee

#See https://tecadmin.net/install-gitlab-ce-on-ubuntu/ for gitlab-ce
curl -sS https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.deb.sh | sudo bash
sudo apt-get install gitlab-ce

#Checkout BitBucket PR
#See https://gist.github.com/piscisaureus/3342247
#Locate the section for your github remote in the .git/config file. It looks like this:
#[remote "origin"]
#	fetch = +refs/heads/*:refs/remotes/origin/*
#	url = git@github.com:joyent/node.git
#Now add the line fetch = +refs/pull/*/head:refs/remotes/origin/pr/* to this section.
#Obviously, change the github url to match your project's URL. It ends up looking like this:
#[remote "origin"]
#	url = ssh://git@scm-git-eur.misys.global.ad:7999/risk/fr-arc.git
#	fetch = +refs/heads/*:refs/remotes/origin/*
#	fetch = +refs/pull-requests/*/from:refs/remotes/origin/PR-*
git fetch origin

for d in $(find . -type d -name .git); do (mr register $d/..); done
mr update

# See https://hub.github.com/
alias git=hub

exit 0
