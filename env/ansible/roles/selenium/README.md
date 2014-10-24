ansible-selenium
====================

A role for installing selenium.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-selenium.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-selenium)
[![Galaxy](http://img.shields.io/badge/galaxy-selenium-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/1993)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-selenium.svg?style=flat-square)]()

## Actions

- Ensures that selenium is installed (using `apt`)

Usage example
------------

    - name: Install selenium
      connection: local  
      hosts: workstation
      remote_user: albandri
      
      roles:
        - role: selenium           
        
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

Are [welcome](https://github.com/AlbanAndrieu/ansible-selenium/issues)!