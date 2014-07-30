Bash
========

Install chrome on Ubuntu

Requirements
------------

python-pycurl and python-software-properties installed.

Example Playbook
-------------------------

    - hosts: servers
      roles:
         - role: devbox.chrome
           google_talkplugin_enabled: yes                       # Enable module
           google_agent_pkg_state: installed # Package states: present or installed or latest
License
-------

LGPL

Author Information
------------------

Alex Lourie, djay.il@gmail.com


Taken from
------------------

https://github.com/psgrove/devsetup
