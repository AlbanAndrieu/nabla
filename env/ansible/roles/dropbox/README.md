ansible-dropbox
==============

A role for installing dropbox.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-dropbox.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-dropbox)

## Actions

- Ensures that dropbox is installed (using `apt`)

Usage example
------------
```
  - name: Install dropbox
    hosts: dropbox
    connection: local
    sudo: yes
    sudo_user: "{{ user }}"
    
    roles:
      - dropbox

```

Hosts example
------------

    [dropbox:vars]
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

Are [welcome](https://github.com/AlbanAndrieu/ansible-dropbox/issues)!
