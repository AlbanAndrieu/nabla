#!/bin/bash
set -xv

#See http://pre-commit.com/#advanced
sudo pip install pre-commit
sudo pip install pre-commit-hooks
#pre-commit install
pre-commit autoupdate

pre-commit run --all-files
#pre-commit run

exit 0
