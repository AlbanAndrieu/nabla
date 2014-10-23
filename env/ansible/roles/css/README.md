# ansible-css

A role for installing css.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-css.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-css)
[![Galaxy](http://img.shields.io/badge/galaxy-css-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/1547)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-css.svg?style=flat-square)]()

## Actions

- Ensures that css is installed (using `apt`)

Usage example
------------

    - name: Install css
      hosts: css
      remote_user: root
    
      roles:
        - css      

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-css/issues)!
