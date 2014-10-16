# ansible-css

A role for installing css.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-css.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-css)

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
