#!/bin/bash
set -xv

#dbus-update-activation-environment: setting JAVA_OPTS=-Djava.io.tmpdir=/target/tmp
#dbus-update-activation-environment --systemd --all
systemctl --user show-environment

exit 0
