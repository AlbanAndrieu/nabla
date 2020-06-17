#!/bin/bash
set -xv

sudo apt install kgpg kwalletmanager kwalletcli

./run-gpg.sh

nano ~/.config/kwalletrc
#[Wallet]
#Default Wallet=albandrieu
#First Use=false
#Enabled=false

#sudo apt remove kwalletmanager libkf5wallet-bin libkf5wallet-data

exit 0
