#!/usr/bin/python
# -*- coding: utf-8 -*-

jobs = [line.strip() for line in open('job.list')]

for job in jobs:
    print('<img src=\"http://home.nabla.mobi:8381/view/nabla-admin/job/nabla-jobs-duration-charts-admin/lastSuccessfulBuild/artifact/Scripts/Python/jenkinsJobDurationCharts/' + job + '.png\" />')  # noqa: ignore=E501
    print('<br />')
