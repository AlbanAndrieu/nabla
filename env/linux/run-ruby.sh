#!/bin/bash
set -xv

sudo apt install ruby-bundler

#See https://github.com/guard/guard

bundle
bundle exec guard init

sudo gem install guard-livereload

bundle exec guard

exit 0
