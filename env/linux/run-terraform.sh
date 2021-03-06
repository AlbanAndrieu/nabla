#!/bin/bash
set -xv

#brew install terraform
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=$(dpkg --print-architecture)] https://apt.releases.hashicorp.com $(lsb_release -cs) main"

cd nabla-servers-bower-sample
terraform init

#Echo organisation : Banbou - https://github.com/Banbou
#terraform apply
terraform apply -var 'key_name=terraform' -var 'public_key_path=~/.ssh/id_rsa.pub' -var 'provider.github.organization=Banbou' -var "provider.github_token=${GITHUB_TOKEN}"

terraform show

exit 0
