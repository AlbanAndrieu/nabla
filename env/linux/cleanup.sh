#!/bin/sh

\rm -Rf /usr/share/tomcat6/.m2/repository/
\rm -Rf ~/.m2/repository/
\rm -Rf .conkyrc-SAV
\rm -Rf ~/.cache/*
#\rm -Rf .eclipse/*
\rm -Rf .cpan/*
\rm -Rf .svn/*
\rm -Rf .thunderbird/*
\rm -Rf .mozilla/*
\rm -Rf .config/*
\rm -f *.db

#\rm -Rf workspace-cpp
#\rm -Rf workspace-j2ee
#\rm -Rf hudson

#find . -type f -name '*~' | xargs rm -r $1
find . -type f -name '*\.log' | xargs rm -r $1
find . -type d -name '.svn' | xargs rm -r $1
find /jenkins -type d -name 'workspace' | grep -v 'builds' | xargs rm -r $1
