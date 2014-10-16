# ansible-dns

A role for installing dns.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-dns.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-dns)

## Actions

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
