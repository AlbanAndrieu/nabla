#!/usr/bin/python

jobs = [line.strip() for line in open('job.list')]

print  '<table>'

for job in jobs:
	print '<tr>'
	print '	<td>' + job + '</td>'
	print '	<td><img src=\"http://home.nabla.mobi:7072/jenkins/job/' + job + '/buildTimeGraph/png\"/></td>'
	print '</tr>'

print '</table>'

