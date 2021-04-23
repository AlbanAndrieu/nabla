#!/bin/bash
set -xv

# See https://github.com/lensapp/lens/releases/tag/v4.1.3

sudo snap install kontena-lens --classic

#See https://github.com/roboll/helmfile/releases

wget https://github.com/roboll/helmfile/releases/download/v0.138.2/helmfile_linux_amd64
sudo cp helmfile_linux_amd64 /usr/local/bin/helmfile
sudo chmod +x /usr/local/bin/helmfile

# See https://helm.sh/docs/community/related/#helm-plugins

helm plugin install https://github.com/databus23/helm-diff
#helm plugin install https://github.com/futuresimple/helm-secrets
helm plugin install https://github.com/karuppiah7890/helm-schema-gen.git

#See https://kubectl.docs.kubernetes.io/installation/kustomize/binaries/

curl -s "https://raw.githubusercontent.com/\
kubernetes-sigs/kustomize/master/hack/install_kustomize.sh"  | bash
sudo cp kustomize /usr/local/bin/kustomize

sudo chmod +x /usr/local/bin/kustomize

# See https://github.com/norwoodj/helm-docs#installation
#NOK GO111MODULE=on go get github.com/norwoodj/helm-docs/cmd/helm-docs
wget https://github.com/norwoodj/helm-docs/releases/download/v1.5.0/helm-docs_1.5.0_linux_amd64.deb

# See https://github.com/ksync/ksync
# As root
curl https://ksync.github.io/gimme-that/gimme.sh | bash

exit 0
