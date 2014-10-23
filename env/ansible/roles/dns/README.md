# ansible-dns

A role for installing dns.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-dns.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-dns)
[![Galaxy](http://img.shields.io/badge/galaxy-dns-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/0000)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-dns.svg?style=flat-square)]()

## Actions

- This role is more a sample than a real role has it is specific to my need. it can be used as a template.
- Ensures that dns is installed (using `apt`)

Usage example
------------

    - name: Install dns
      hosts: dns
      remote_user: root
    
      roles:
        - dns      

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-dns/issues)!
