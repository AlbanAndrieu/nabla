# ansible-xvbf

A role for installing xvbf.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-xvbf.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-xvbf)
[![Galaxy](http://img.shields.io/badge/galaxy-xvbf-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/1174)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-xvbf.svg?style=flat-square)]()

## Actions

- Ensures that xvbf is installed (using `apt`)

Usage example
------------

    - name: Install xvbf
      hosts: xvbf
      remote_user: root
    
      roles:
        - xvbf      

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-xvbf/issues)!
