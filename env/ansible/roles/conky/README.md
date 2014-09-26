ansible-conky
====================

A role for installing conky.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-conky.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-conky)

## Actions

- Ensures that conky is installed (using `apt`)

Usage example
------------

    - name: Install conky
      hosts: workstation
      user: root
    
      roles:
        - conky      
      
    vars:      
        conky_home: '/workspace/users/albandri10/.conky'      

Hosts example
------------

    [workstation]
    albandri-laptop-misys

    [workstation:vars]
    user=albandri
    version=10
    home=/workspace/users/{{ user }}{{ version }}/

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-webmin/issues)!
