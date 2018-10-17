#!/bin/bash
set -xv

brew install terraform

cd nabla-servers-bower-sample
terraform init

#Echo organisation : Banbou - https://github.com/Banbou
terraform apply

terraform show

exit 0
