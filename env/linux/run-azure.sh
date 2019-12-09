#!/bin/bash
#set -xv

# See https://docs.microsoft.com/fr-fr/cli/azure/install-azure-cli-apt?view=azure-cli-latest

curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash

az login --use-device-code --allow-no-subscriptions
https://microsoft.com/devicelogin

exit 0
