#!/bin/bash
#set -xv

#See https://doc.ubuntu-fr.org/snap

sudo snap install snap-store
sudo apt install gnome-software-plugin-flatpak
sudo apt-get update
sudo flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo

sudo flatpak list
sudo flatpak update

snap list
snap find libre

# Run
snap-store

#See account https://snapcraft.io/snap-store

snap refresh --time
sudo snap set system refresh.timer=sat,10:00~12:00

#NetworkManager
nmcli d
nmcli c show docker0 | grep "IP"
nmcli c show "Wired connection 1" | grep "IP"

sudo systemctl restart snapd.service
journalctl -u snapd.service
#failed: exceeded maximum runtime of 1m1s
#Lookup api.snapcraft.io: no such host

journalctl    --no-pager --since  "2020-12-15 09:15" --until  "2020-12-15 10:45"
#sudo systemctl status microk8s.daemon-kubelet

sudo snap stop microk8s
sudo snap start microk8s

systemctl status snap.microk8s.daemon-kubelet
sudo journalctl -u snap.microk8s.daemon-kubelet
#https://127.0.0.1:16443/apis/coordination.k8s.io/v1/namespaces/kube-node-lease/leases/albandrieu?timeout=10s
# See https://github.com/ubuntu/microk8s/issues/423
sudo systemctl restart snap.microk8s.daemon-kubelet
sudo systemctl restart snap.microk8s.daemon-flanneld

exit 0
