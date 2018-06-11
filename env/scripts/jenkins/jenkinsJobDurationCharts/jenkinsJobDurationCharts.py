#!/usr/bin/python
# -*- coding: utf-8 -*-
import csv
import json
import urllib.request
from array import array
from os.path import isfile

import pygal


# jobs = ['1_NABLA_TEST']
jobs = [line.strip() for line in open('job.list')]

for job in jobs:
    print('Processing Jenkins job ' + job)
    buildTimes = {}
    csvFile = job + '.csv'

    print('Reading ' + csvFile)
    # load existing csv file if exists
    if isfile(job + '.csv'):
        with open(job + '.csv', 'rb') as csvfile:
            reader = csv.reader(csvfile, delimiter=',')

            for row in reader:
                number = int(row[0])
                duration = int(row[1])
                buildTimes[number] = duration

    # load values from url
    url = 'http://home.nabla.mobi:8381/job/' + \
        job + '/api/json?tree=builds[number,duration]'
    print('Reading data from ' + url)
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())

    for i in data['builds']:
        buildTimes[i['number']] = i['duration'] / 60000

    # store buildTimes dictionary as csv file
    print('Writing ' + csvFile)
    with open(job + '.csv', 'wb') as csvfile:
        writer = csv.writer(csvfile, delimiter=',')

        for key in sorted(buildTimes):
            writer.writerow([key, buildTimes[key]])

    # create chart data
    print('Creating chart file ' + job + '.png')
    build = array('l')
    duration = array('l')

    for key in sorted(buildTimes):
        build.append(key)
        duration.append(buildTimes[key])

    chart = pygal.Line(width=1200, height=800)
    chart.title = job
    chart.x_labels = build
    chart.add(job, duration)

    chart.render_to_png(job + '.png')
    print
