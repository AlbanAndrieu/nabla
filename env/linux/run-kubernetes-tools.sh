#!/bin/bash
set -xv

#See https://github.com/roboll/helmfile/releases

wget https://github.com/roboll/helmfile/releases/download/v0.138.2/helmfile_linux_amd64
sudo cp helmfile_linux_amd64 /usr/local/bin/helmfile
sudo chmod +x /usr/local/bin/helmfile

# See https://helm.sh/docs/community/related/#helm-plugins
# See https://github.com/search?q=topic%3Ahelm-plugin&type=Repositories

helm plugin install https://github.com/databus23/helm-diff
#helm plugin install https://github.com/futuresimple/helm-secrets
helm plugin install https://github.com/karuppiah7890/helm-schema-gen
helm plugin install https://github.com/ContainerSolutions/helm-monitor
helm plugin install https://github.com/ContainerSolutions/helm-convert
helm plugin install https://github.com/lrills/helm-unittest
helm plugin install https://github.com/aslafy-z/helm-git
#helm plugin remove helm-git

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

# See https://www.kubeval.com/
wget https://github.com/instrumenta/kubeval/releases/latest/download/kubeval-linux-amd64.tar.gz
tar xf kubeval-linux-amd64.tar.gz
sudo cp kubeval /usr/local/bin

# See https://krew.sigs.k8s.io/docs/user-guide/setup/install/

(
  set -x; cd "$(mktemp -d)" &&
  curl -fsSLO "https://github.com/kubernetes-sigs/krew/releases/latest/download/krew.tar.gz" &&
  tar zxvf krew.tar.gz &&
  KREW=./krew-"$(uname | tr '[:upper:]' '[:lower:]')_$(uname -m | sed -e 's/x86_64/amd64/' -e 's/arm.*$/arm/' -e 's/aarch64$/arm64/')" &&
  "$KREW" install krew
)

export PATH="${KREW_ROOT:-$HOME/.krew}/bin:$PATH"

kubectl krew version

kubectl krew search

kubectl krew install flame
kubectl krew install graph
#kubectl graph pods --field-selector status.phase=Running -n kube-system | dot -T svg -o pods.svg
kubectl graph pods --field-selector status.phase=Running -n fr-standalone-aandrieu --kubeconfig=$HOME/.kube/config | dot -T svg -o pods.svg

kubectl krew install ctx
kubectl krew install ns
#kubectl krew install sniff
# bash <( curl -sfL https://raw.githubusercontent.com/boz/kail/master/godownloader.sh) -b "$GOPATH/bin"

kubectl krew install tree
kubectl tree deployment my-develop-helm-sample -n fr-standalone-aandrieu --kubeconfig=$HOME/.kube/config

kubectl krew install score
helm template packs/helm-sample/charts/ | kubectl score -

kubectl plugin list

# External repo

helm --debug repo add bitnami https://charts.bitnami.com/bitnami --force-update
helm --debug repo add jenkins https://charts.jenkins.io --force-update

POPEYE_REPORT_DIR=$(pwd) popeye --kubeconfig ~/.kube/config --namespace fr-standalone-aandrieu --cluster treasury-trba --save --out html --output-file report.html

# Ingress
#run : kubectl create -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-0.32.0/deploy/static/provider/cloud/deploy.yaml
#or with helm :
# See https://kubernetes.github.io/ingress-nginx/deploy/
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install my-nginx ingress-nginx/ingress-nginx

exit 0
