#!/bin/bash
set -xv

# See https://github.com/helm/helm/blob/master/docs/install.md

#brew install kubernetes-helm
#sudo snap install helm --classic

helm version --short --client
helm init --client-only

#See http://127.0.0.1:8879/charts

exit 0
