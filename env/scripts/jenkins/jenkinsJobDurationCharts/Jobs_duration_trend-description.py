#!/usr/bin/python
# -*- coding: utf-8 -*-

jobs = [line.strip() for line in open('job.list')]

print('<table>')

for job in jobs:
    print('<tr>')
    print('	<td>' + job + '</td>')
    print(
        '	<td><img src=\"http://home.nabla.mobi:8381/job/' +
        job + '/buildTimeGraph/png\"/></td>',
    )
    print('</tr>')

print('</table>')
