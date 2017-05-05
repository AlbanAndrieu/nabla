#!/bin/bash
set -xv

#http://www.cyberciti.biz/faq/howto-use-linux-truss-strace-command/
strace -o /tmp/output.txt tail -f /workspace/users/albandri30/nabla-servers/sample/jsf-simple/deploy.log
#use truss on solaris
/usr/bin/truss -f -o /var/tmp/syslog.truss.out /opt/csw/bin/vim test.log
#scp /var/tmp/syslog.truss.out albandri@albandri:~
