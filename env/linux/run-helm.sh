#!/bin/bash
set -xv

# See https://github.com/helm/helm/blob/master/docs/install.md

#brew install kubernetes-helm
sudo snap remove helm
sudo snap install helm --classic

curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh
#/usr/local/bin/helm version --short --client

#The Kubernetes package manager
#
#Common actions for Helm:
#
#- helm search:    search for charts
#- helm pull:      download a chart to your local directory to view
#- helm install:   upload the chart to Kubernetes
#- helm list:      list releases of charts
#
#Environment variables:
#
#+------------------+-----------------------------------------------------------------------------+
#| Name             | Description                                                                 |
#+------------------+-----------------------------------------------------------------------------+
#| $XDG_CACHE_HOME  | set an alternative location for storing cached files.                       |
#| $XDG_CONFIG_HOME | set an alternative location for storing Helm configuration.                 |
#| $XDG_DATA_HOME   | set an alternative location for storing Helm data.                          |
#| $HELM_DRIVER     | set the backend storage driver. Values are: configmap, secret, memory       |
#| $HELM_NO_PLUGINS | disable plugins. Set HELM_NO_PLUGINS=1 to disable plugins.                  |
#| $KUBECONFIG      | set an alternative Kubernetes configuration file (default "~/.kube/config") |
#+------------------+-----------------------------------------------------------------------------+
#
#Helm stores configuration based on the XDG base directory specification, so
#
#- cached files are stored in $XDG_CACHE_HOME/helm
#- configuration is stored in $XDG_CONFIG_HOME/helm
#- data is stored in $XDG_DATA_HOME/helm
#
#By default, the default directories depend on the Operating System. The defaults are listed below:
#
#+------------------+---------------------------+--------------------------------+-------------------------+
#| Operating System | Cache Path                | Configuration Path             | Data Path               |
#+------------------+---------------------------+--------------------------------+-------------------------+
#| Linux            | $HOME/.cache/helm         | $HOME/.config/helm             | $HOME/.local/share/helm |
#| macOS            | $HOME/Library/Caches/helm | $HOME/Library/Preferences/helm | $HOME/Library/helm      |
#| Windows          | %TEMP%\helm               | %APPDATA%\helm                 | %APPDATA%\helm          |
#+------------------+---------------------------+--------------------------------+-------------------------+

helm version --short --client
#helm init --client-only
#helm init

#sudo dpkg-reconfigure apparmor
sudo nano /etc/apparmor.d/tunables/home.d/albandri
@{HOMEDIRS}+=/data1/home/
sudo systemctl restart apparmor.service

helm repo add stable https://kubernetes-charts.storage.googleapis.com/
#helm repo add custom --username aandrieu --password XXX https://registry-tmp.misys.global.ad/chartrepo/kondor
helm repo add custom --username aandrieu --password XXX https://registry-tmp.misys.global.ad/chartrepo/fusion-risk
helm repo add harbor http://albandrieu:6532/chartrepo/library

helm search repo harbor
helm fetch finastra/treasury --version 348.20.0-20200307T050112.shae5a6f0c.166
#(find ./ -type d -name charts |sort -u |while read x; do ls -1d $x/*; done ) |while read c; do helm template $c |grep global-bakery >/dev/null && echo $c; done

#export HELM_TLS_ENABLE=false

kubectl config view --raw
helm init --service-account=tiller --history-max 200

#See http://127.0.0.1:8879/charts

#Now, add the public stable helm repo for installing the stable charts.
helm repo list

#See https://helm.sh/blog/migrate-from-helm-v2-to-helm-v3/
helm plugin install https://github.com/helm/helm-2to3
helm plugin list
helm 2to3

#See https://hub.helm.sh/

# See https://mydeveloperplanet.com/2018/10/03/create-install-upgrade-rollback-a-helm-chart-part-1/
helm create testChart
helm lint testChart

helm package testChart
mkdir testChartDir
mv testChart-0.1.0.tgz testChartDir/
helm repo index  testChartDir/ --url http://albandrieu:6532/chartrepo/library

helm repo update
helm install --name my-release harbor/testchart

# Cleaning
helm list

#helm plugin install https://github.com/chartmuseum/helm-push.git
#helm chart push albandrieu:6532/library/testChart:0.1.0

#helm push testChart --version="$(git log -1 --pretty=format:%h)" harbor --username admin --password microsoft
#--verify
helm install harbor/testChart --generate-name --debug --version 0.1.0

sudo apt-get install bash-completion
## Bash
echo 'source <(kubectl completion bash)' >>~/.bashrc
#helm completion bash > /etc/bash_completion.d/helm

# See https://artifacthub.io/packages/search?page=1&repo=helm-stable

helm search repo stable

# See https://www.jenkins.io/doc/book/installing/kubernetes/
helm repo add jenkinsci https://charts.jenkins.io
helm repo update
helm search repo jenkinsci

exit 0
