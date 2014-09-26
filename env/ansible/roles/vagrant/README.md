ansible-vagrant-role
====================

An ansible role for installing vagrant on Ubuntu

This is necessary because the vagrant package is outdated in Ubuntu, and the
vagrant authors do not provide a PPA.

[![Build Status](https://travis-ci.org/klynch/ansible-vagrant-role.png?branch=master)](https://travis-ci.org/klynch/ansible-vagrant-role)

Usage example
------------

Add this to your playbook:

    - name: Setup for vagrant boxes
      hosts: all
      gather_facts: true
      roles:
        - ansible-vagrant-role   
      
      vars:
        vagrant_libvirt_enabled: true #In order to enable libvirt plugin    
        
Requirements
------------

none

Role Variables
--------------

Defaults is:

    vagrant_url: https://dl.bintray.com/mitchellh/vagrant/vagrant_1.6.3_x86_64.deb

Description:

- ` vagrant_url` - A URL to the vagrant DEB package 

Dependencies
------------

none

License
-------

MIT
