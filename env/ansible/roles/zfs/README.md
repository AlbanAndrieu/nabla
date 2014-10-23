# ansible-zfs

A role for installing zfs.

[![Build Status](https://api.travis-ci.org/AlbanAndrieu/ansible-zfs.png?branch=master)](https://travis-ci.org/AlbanAndrieu/ansible-zfs)
[![Galaxy](http://img.shields.io/badge/galaxy-zfs-blue.svg?style=flat-square)](https://galaxy.ansible.com/list#/roles/1175)
[![Tag](http://img.shields.io/github/tag/AlbanAndrieu/ansible-zfs.svg?style=flat-square)]()

## Actions

- Ensures that zfs is installed (using `apt`)

Usage example
------------

    - name: Install zfs
      hosts: zfs
      remote_user: root
    
      roles:
        - zfs      

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

Are [welcome](https://github.com/AlbanAndrieu/ansible-zfs/issues)!
