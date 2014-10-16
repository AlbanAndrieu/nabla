# ansible-cmake

A role for installing workstation.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-workstation.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-workstation)

## Actions

- Ensures that workstation is installed (using `apt`)

Usage example
------------

    - name: Install workstation
      hosts: workstation
      remote_user: root
    
      roles:
        - workstation      

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-workstation/issues)!
