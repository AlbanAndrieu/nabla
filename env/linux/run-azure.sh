#!/bin/bash
#set -xv

# See https://docs.microsoft.com/fr-fr/powershell/scripting/install/installing-powershell-core-on-linux?view=powershell-7.1
sudo apt-get install -y powershell

# See https://docs.microsoft.com/fr-fr/cli/azure/install-azure-cli-apt?view=azure-cli-latest

sudo apt install azure-cli
#curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash

export AZURE_DNS_SUBSCRIPTION=${AZURE_DNS_SUBSCRIPTION:="DEV-C20-001"}
export AZURE_DNS_RSC_GROUP=${AZURE_DNS_RSC_GROUP:="AZR-C21-DV-505-01"}

az login
#az login --use-device-code --allow-no-subscriptions
#https://microsoft.com/devicelogin

az account list --output table
#az account list | grep -s "DEV-C20-001"
az account show
# "id": "a029fbf1-419b-4fbc-8de8-7efd99e5e70a"
#" tenantId": "0b9b90da-3fe1-457a-b340-f1b67e1024fb",
#"name": "alban.andrieu@finastra.com",
az account get-access-token
#"subscription": "a029fbf1-419b-4fbc-8de8-7efd99e5e70a",
az account set --subscription "DEV-C20-001"
#"subscription": "f4c6caf2-122a-491f-928a-ffa197a45fcd",
#"tenant": "e17e2402-2a40-42ce-ad75-5848b8d4f6b6",
az group list --output table
az resource list

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
# on windows SET AZURE_CLI_DISABLE_CONNECTION_VERIFICATION="true"
#First
az login
az acr login --name p21d13401013001 --subscription DEV-C20-001
az acr login --name p21d13401013001 --username $SP_APP_ID --password $SP_PASSWD
az acr login --name p21d50501532001 # pegasus push
# No manage identity
#az identity show --resource-group AZR-C21-DV-505-01 --name p21d50501532001 --query id --output tsv
#az identity show --resource-group AZR-C21-DV-505-01 --name p21d50501532001 --query principalId --output tsv
# But principal
az acr show --name p21d50501532001 --query id --output tsv
#If you don't have X11 on the machine:
#az acr login --name p21d13401013001 --expose-token
docker login p21d13401013001.azurecr.io --username $SP_APP_ID --password $SP_PASSWD
docker login p21d50501532001.azurecr.io

az acr check-health -n p21d13401013001 --yes

#Test
#docker pull p21d13401013001.azurecr.io/global-bakery/deps-alpine3.8

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
az aks get-credentials --name p21d50501533001 --resource-group AZR-C21-DV-505-01

# See https://docs.microsoft.com/en-us/azure/devops/pipelines/build/variables?view=azure-devops&tabs=yaml

#docker login p21d13401013001.azurecr.io
docker pull p21d13401013001.azurecr.io/fusion-risk/ansible-jenkins-slave

sudo az aks install-cli
kubectl version --client

aadgname=todo
az ad group list --filter "displayname eq '$aadgname'" -O table
az aks get-credentials -g AKS-Demo -n aksdemocluster
az aks list

k get no

# Ansible

wget https://raw.githubusercontent.com/ansible-collections/community.general/main/scripts/inventory/azure_rm.py
chmod +x ./azure_rm.py
./azure_rm.py --help

nano $HOME/.azure/credentials

ansible -i azure_rm.py Testing -m shell -a "/bin/uname -a"

exit 0
