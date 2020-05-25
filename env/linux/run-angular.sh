#!/bin/bash
set -xv

sudo npm install -g @angular/cli
ng build --prod

exit 0
