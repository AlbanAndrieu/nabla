#!/usr/bin/python

jobs = [line.strip() for line in open('job.list')]

for job in jobs:
    print '<img src=\"http://home.nabla.mobi:8381/view/nabla-admin/job/nabla-jobs-duration-charts-admin/lastSuccessfulBuild/artifact/Scripts/Python/jenkinsJobDurationCharts/' + job + '.png\" />'
    print '<br />'
