#!/bin/bash
#Script to remove workspaces of jobs that no longer exist
#go to workspaces dir (e.g. on master it is /local/Jenkins-slave/workspace) and run the scrip

for job in `ls`
do
    if [ -d $job ]; then
       response=`wget --server-response -O /dev/nullhttp://home.nabla.mobi:8380/jenkins/job/$job/ 2>&1 | awk '/^  HTTP/{print $2}'`
       echo $job $response
       if [ $response = "404" ]; then
         echo "Remove directory $job"
         rm -rf $job
       fi
    fi
done
