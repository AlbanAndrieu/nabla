ansible-zap
====================

A role for installing zap.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-zap.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-zap)

## Actions

- Ensures that zap is installed (using `apt`)

Usage example
------------

    - name: Install zap
      hosts: zap
      user: root
    
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
