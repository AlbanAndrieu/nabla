ansible-zap
====================

A role for installing zap.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-zap.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-zap)

## Actions

- Ensures that [zap](https://code.google.com/p/zaproxy/) is installed (using `ansible`)
- Once zaproxy is installed using ansible, a docker image is automatically created, so please do not hesitate to enhance ansible script it will then improve docker image.

Usage example
------------

    - name: Install zap
      hosts: zap
      remote_user: root
    
      roles:
        - zap      
        
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

Are [welcome](https://github.com/AlbanAndrieu/ansible-zap/issues)!
