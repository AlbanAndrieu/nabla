#!/bin/bash
set -xv

#https://github.com/koalaman/shellcheck/wiki/Integration

sudo apt-get install shellcheck
shellcheck -f checkstyle  *.sh -s bash
