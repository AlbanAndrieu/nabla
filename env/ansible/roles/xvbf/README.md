# ansible-xvbf

A role for installing xvbf.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-xvbf.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-xvbf)

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
