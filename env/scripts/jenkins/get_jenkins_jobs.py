# -*- coding: utf-8 -*-
"""Python get_jenkins_jobs.py

Create excel with Jenkins job stats (name, last build etc). Needs some more work,
requires a list of jobs in jenkins_disk_space.txt file with data. Switched to urllib3
because of extremely slow ssl checking with jenkins and requests library.

Username:password auth is removed for the same reason. SSL certificate is sufficient
for connection.

Usage: create_new_html [-hv]

Options:
    -h --help                  Show this message and exit
    -v --version               Show version and exit
"""

__author__ = 'albandri'
__version__ = '1.0'

from datetime import datetime
from bs4 import BeautifulSoup
#import re
import urllib3
import json
#import paramiko
from functools import partial
from multiprocessing.pool import ThreadPool as Pool
import pandas as pd
from common.docopt import docopt
from common.api import urljoin, pretty
from openpyxl import Workbook
from openpyxl.styles import Font, Border, Side  # Color, PatternFill, colors
from openpyxl.utils.dataframe import dataframe_to_rows


def add_job_properties(jenkins_job, http=None) -> dict:
    """
    Add job details to base jenkins job dict (which contaions only name, url and _class
    """
    requested_job_properties = [
        'description', 'buildable', 'lastBuild', 'lastSuccessfulBuild', 'lastUnsuccessfulBuild',
    ]

    try:
        url = urljoin(jenkins_job['Url'], 'api/json')
        r = http.request('GET', url)
        jobs_details = json.loads(r.data.decode('utf-8'))

        # Add additional job properties - lastBuild, lastSuccessfulBuild etc...
        for property in requested_job_properties:
            try:
                jenkins_job[property] = jobs_details[property]
                if property == 'description':
                    try:
                        soup = BeautifulSoup(jenkins_job[property])
                        jenkins_job[property] = soup.get_text()
                        print(soup.get_text())
                        #jenkins_job['property'] = re.sub(r'\n|\t|\r', '', jenkins_job['property'])
                    except:
                        jenkins_job['property'] = ''
                if 'Build' in property:
                    try:
                        jenkins_job[property] = jenkins_job[property]['number']
                    except:
                        pass
            except KeyError:
                jenkins_job[property] = 'n.a.'

        # Get details on last build timestamps
        for last_build in ['lastBuild', 'lastSuccessfulBuild', 'lastUnsuccessfulBuild']:
            last_build_date = last_build + 'Date'
            try:
                url = urljoin(jenkins_job['Url'], last_build, 'api/json')
                r = http.request('GET', url)
                last_build_details = json.loads(r.data.decode('utf-8'))

                jenkins_job[last_build_date] = datetime.fromtimestamp(
                    int(last_build_details['timestamp']) / 1000,
                ).strftime('%Y-%m-%d')

            except:
                jenkins_job[last_build_date] = ''
    except:
        return jenkins_job

    print('jenkins job with properties', jenkins_job)

    return jenkins_job


def append_disk_space(jobs) -> dict:
    """
    Add disk space information to all jobs dict (requires valid jenkins_disk_space
    """
    disk_space = {}
    with open('jenkins_disk_space.txt', 'r') as f_in:
        for line in f_in.readlines():
            block_space, job_name = line.split('\t')
            block_space = int(block_space)
            job_name = job_name.strip()
            disk_space[job_name] = block_space
    for job, details in jobs.items():
        try:
            details['Disk'] = disk_space[job]
        except (KeyError, TypeError):
            details['Disk'] = 0
            print(job, details)
        jobs[job] = details
    return jobs


def get_jenkins_jobs(server):
    """ Get excel sheet with statistics of jenkins jobs
    """
    columns = [
        'name', 'Url', 'Type', 'Color', 'Disk', 'description',
        'buildable', 'lastBuild', 'lastBuildDate', 'lastSuccessfulBuild',
        'lastSuccessfulBuildDate', 'lastUnsuccessfulBuild', 'lastUnsuccessfulBuildDate',
    ]
    ca_certificates = '/etc/ssl/certs/nabla.crt'
    headers = {
        'Accept': 'application/json',
    }

    # Use urllib3 instead of requests, no ssl or auth required for general requests to jenkinsapi
    http = urllib3.PoolManager()

    url_main = urljoin(server, 'api/json')

    r = http.request('GET', url_main)
    print(type(r.data.decode('utf-8')))
    jenkins_content = json.loads(r.data.decode('utf-8'))

    jobs = {}
    for job in jenkins_content['jobs']:
        if 'color' in job:
            jobs[job['name']] = {
                'name': job['name'],
                'Url': job['url'],
                'Type': job['_class'],
                'Color': job['color'],
            }
        else:
            jobs[job['name']] = {
                'name': job['name'],
                'Url': job['url'],
                'Type': job['_class'],
                'Color': 'none',
            }
        # print(jobs[job["name"]])

    # Add disk space data for all jobs (from local text file):
    jobs = append_disk_space(jobs)

    for i, j in jobs.items():
        print('DISK', j['Disk'], 'JOB', i)

    # "_class" : "hudson.model.ListView"

    # Update all job data

    jenkins_jobs = [jenkins_job for jenkins_job in list(jobs.values())]
    print(jenkins_jobs)
    add_job_properties_partial = partial(add_job_properties, http=http)
    with Pool(processes=8) as pool:
        jobs_updated = {
            jenkins_job['name']: jenkins_job for jenkins_job in pool.map(
                add_job_properties_partial, jenkins_jobs,
            )
        }
    try:
        with open('sample_output.txt', 'w') as f_out:
            f_out.write(json.dumps(jobs_updated))
    except:
        pass

    # Convert urls to excel-style hyperlinks"
    # Convert Disk Blocks to MB
    # Strip Job type to actual job type
    for job in jobs_updated:
        jobs_updated[job]['Disk'] /= 1000
        jobs_updated[job]['Url'] = '=HYPERLINK("{}", "{}")'.format(
            jobs_updated[job]['Url'], jobs_updated[job]['Url'],
        )
        jobs_updated[job]['Type'] = jobs_updated[job]['Type'].split('.')[-1]

    df = pd.DataFrame(columns=columns)
    for job_updated in jobs_updated.values():
        print('job updated', job_updated)
        df = df.append(job_updated, ignore_index=True)

    print(df)

    workbook = Workbook()
    excel_sheet = workbook.active
    for row in dataframe_to_rows(df, index=False, header=True):
        excel_sheet.append(row)

    ### Formatting ###
    lengths = [
        len(name) if len(name) > 7 else 7
        for name in columns
    ]
    lengths.extend([5, 5, 5, 5])

    for index, column_cells in enumerate(excel_sheet.columns):
        excel_sheet.column_dimensions[column_cells[0].column].width = lengths[index]

    for row_cells in excel_sheet.rows:
        excel_sheet.row_dimensions[row_cells[0].row].height = 12

    font_global = Font(name='Arial', size=10)
    font_red = Font(name='Arial', size=10, color='00FF0000')
    font_blue = Font(name='Arial', size=10, color='000000FF')
    font_green = Font(name='Arial', size=10, color='00008000')
    font_yellow = Font(name='Arial', size=10, color='00C9C900')
    font_lgrey = Font(name='Arial', size=10, color='00C0C0C0')
    font_dgrey = Font(name='Arial', size=10, color='00505050')

    font_bold = Font(name='Arial', size=10, bold=True)
    border = Border(bottom=Side(border_style='thin', color='000000'))

    # Fill #f5f5dc

    for row in excel_sheet:
        for cell in row:
            cell.font = font_global

    for cell in excel_sheet['1:1']:
        cell.font = font_bold
        cell.border = border

    for row in excel_sheet.iter_rows(
            'D{}:D{}'.format(excel_sheet.min_row, excel_sheet.max_row),
    ):
        for cell in row:
            if cell.value == 'blue':
                cell.font = font_green
                cell.value = 'green'

            elif cell.value == 'red':
                cell.font = font_red

            elif cell.value == 'yellow':
                cell.font = font_yellow

            elif cell.value == 'disabled':
                cell.font = font_lgrey

    workbook.save('jenkins_test.xlsx')


def main():
    arguments = docopt(__doc__, version=__version__)
    server = 'http://home.nabla.mobi:8381/'
    get_jenkins_jobs(server)


if __name__ == '__main__':
    main()
