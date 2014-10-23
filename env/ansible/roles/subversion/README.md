ansible-subversion
====================

A role for installing subversion.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-subversion.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-subversion)
[![Galaxy](http://img.shields.io/badge/galaxy-subversion-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/1511)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-subversion.svg?style=flat-square)]()

## Actions

- Ensures that subversion is installed (using `apt`)

Usage example
------------

```
  - name: Install subversion
    hosts: subversion
    user: root
  #  connection: local
    
    roles:
      - subversion      

    #use the following in order to get a previous version of subversion
    vars:
        subversion_previous_enabled: true   
        subversion_previous_codename: precise
        subversion_rabbitvcs_enabled: no
        subversion_major    : '1'
        subversion_minor    : '6'
        subversion_revision : '17'
        subversion_version : "{{subversion_major}}.{{subversion_minor}}.{{subversion_revision}}"
        subversion_ubuntu: '{{ subversion_version }}dfsg-3ubuntu3'
      
      
```

Requirements
------------

none

Dependencies
------------

none

License
-------

MIT

#### Feedback, bug-reports, requests, ...

Are [welcome](https://github.com/AlbanAndrieu/ansible-subversion/issues)!
