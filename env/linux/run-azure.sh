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

exit 0
