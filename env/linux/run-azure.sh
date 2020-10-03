#!/bin/bash
#set -xv

# See https://docs.microsoft.com/fr-fr/cli/azure/install-azure-cli-apt?view=azure-cli-latest

sudo apt install azure-cli
#curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash

az login
#az login --use-device-code --allow-no-subscriptions
#https://microsoft.com/devicelogin

az account list --output table
az group list --output table
az resource list

az resource list \
    --resource-group learn-50cfad3d-263a-4640-9086-54ddd2d95ab5 \
    --resource-type Microsoft.Web/sites

az webapp stop \
    --resource-group learn-50cfad3d-263a-4640-9086-54ddd2d95ab5 \
    --name aandrieu-wordpress

az webapp start \
    --resource-group learn-50cfad3d-263a-4640-9086-54ddd2d95ab5 \
    --name aandrieu-wordpress

#az vm create \
#  --resource-group MyResourceGroup \
#  --name TestVm \
#  --image UbuntuLTS \
#  --generate-ssh-keys \
#  ...

# See https://shell.azure.com/
# pwsh

# See https://azure.microsoft.com/fr-fr/downloads/

az --version

az login
#az login --tenant "0b9b90da-3fe1-457a-b340-f1b67e1024fb"
az login --use-device-code
az login --identity

# ACR and helm repo access:
az acr login -n p21d13401013001
docker login p21d13401013001.azurecr.io --username $SP_APP_ID --password $SP_PASSWD

#AZR-C21-DV-134-01

#az account set --subscription PROD-C20-001
#az aks get-credentials --name p21d13401013001 --resource-group AZR-C21-DV-134-01 --admin

#az ad sp reset-credentials
az acr list
az provider operation show --namespace Microsoft.ContainerRegistry
az acr repository show-manifests -n p21d13401013001 --repository fusion-risk/ansible-jenkins-slave --orderby time_desc

# AKS access:
az account set --subscription DEV-C20-001
#NOK az aks get-credentials --name p21d19702515001 --resource-group AZR-C21-DV-197-02
#az account set --subscription DEV-C01-002
#az account set --subscription DEV-C30-001

# See https://docs.microsoft.com/en-us/azure/devops/pipelines/build/variables?view=azure-devops&tabs=yaml

#docker login p21d13401013001.azurecr.io
docker pull p21d13401013001.azurecr.io/fusion-risk/ansible-jenkins-slave

sudo az aks install-cli
kubectl version --client

aadgname=todo
az ad group list --filter "displayname eq '$aadgname'" -O table
az aks get-credentials -g AKS-Demo -n aksdemocluster

k get no

# Ansible

wget https://raw.githubusercontent.com/ansible-collections/community.general/main/scripts/inventory/azure_rm.py
chmod +x ./azure_rm.py
./azure_rm.py --help

nano $HOME/.azure/credentials

ansible -i azure_rm.py Testing -m shell -a "/bin/uname -a"

exit 0
