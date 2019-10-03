# -*- coding: utf-8 -*-
import re

import urllib2
from BeautifulSoup import BeautifulSoup
plugin_matrix_file = open('plugin_matrix_file.csv', 'wb')
plugins_links = []
url = 'https://wiki.jenkins-ci.org/display/JENKINS/Plugins'
page = urllib2.urlopen(url)
page = page.read()
links = re.findall(r"<a.*?\s*href=\"(.*?)\".*?>(.*?)</a>", page)
for link in links:
    if (link[0].find('+Plugin') != -1):
        print('href: {}, HTML text: {}'.format(link[0], link[1]))
        plugins_links.append(link[0])
for plugin_link in plugins_links:
    line_to_add = ''
    print('%s' % plugin_link)
    if (plugin_link.find('http') == 0):
        plugin_link2 = plugin_link.split('/')
        plugin_link3 = plugin_link2[3:]
        plugin_link = '/' + '/'.join(plugin_link3)
    base_url = 'https://wiki.jenkins-ci.org'
    url2 = base_url + str(plugin_link)
    print('URL: %s' % url2)
    if (url2.find('JENKINS') != -1):
        line_to_add += url2.split('display/JENKINS/')[1]
    if (url2.find('HUDSON') != -1):
        line_to_add += url2.split('display/HUDSON/')[1]
    page2 = urllib2.urlopen(url2)
    page2 = page2.read()
    soup = BeautifulSoup(page2)
    tableData = soup.find('table', attrs={'class': 'confluenceTable'})
    if (tableData):
        print('\n====\n')
        # print "td: %s" %tableData
        tableRows = tableData.findAll('tr')
        tableRows_len = len(tableRows)
#        print tableRows_len
        row1 = tableRows[0]
        td1 = row1.findAll('td')
        if (tableRows_len > 1):
            row2 = tableRows[1]
            td2 = row2.findAll('td')
        if (td1):
            #          print "td1: %s" %td1
            #          print "\n"
            #          print "td2: %s" %td2
            td11 = td1[0]
            plugin_id = td11.find(text=True)
#          print "td11: %s" %td11
#          print "PI: %s\n" %plugin_id
            line_to_add += ';' + str(plugin_id)
        if (td2):
            td21 = td2[0]
            plugin_version = td21.findAll(text=True)
#          print "td21: %s" %td21
            print('PV: %s\n' % plugin_version)
            line_to_add += ';' + str(plugin_version[0])
            for numb in range(0, len(plugin_version)):
                print('{} -> {}'.format(numb, plugin_version[numb]))
            if (len(plugin_version) > 4):
                dependency = ''
                for num in range(4, len(plugin_version)):
                    if (plugin_version[num] != ' '):
                        dependency += plugin_version[num] + ';'
                    else:
                        print('ALA: %s' % plugin_version[num])
                splited_dependency = dependency.split(';')
                for j in range(0, len(splited_dependency)):
                    if (j % 2 == 1):
                        pair = splited_dependency[
                            j -
                            1
                        ] + splited_dependency[j]
                        line_to_add += ';' + str(pair)

#            line_to_add+=";"+str(dependency)
#          line_to_add+=";"+str(plugin_version[0])
    print('Line_to_add: %s' % line_to_add)
    plugin_matrix_file.write(str(line_to_add + '\n'))
#          plugin_version=re.findall(r"<.*?>",str(td11))
#          print "plugin version: %s" % plugin_version
#          print "%s" % str(td11).strip()
plugin_matrix_file.close()
#    tables=re.findall(r"<table.*?>(.*?)</table>",page2)
#    print "tables: %s" %tables
