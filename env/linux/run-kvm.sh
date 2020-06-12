#!/bin/bash
set -xv

#See https://help.ubuntu.com/community/KVM/Installation

egrep -c '(vmx|svm)' /proc/cpuinfo
egrep -c ' lm ' /proc/cpuinfo

sudo apt-get install qemu-kvm libvirt-daemon-system libvirt-clients bridge-utils

sudo kvm-ok

sudo apt-get install virt-viewer

sudo adduser `id -un` libvirt
sudo adduser `id -un` kvm

virsh list --all

sudo rmmod kvm
sudo modprobe -a kvm

exit 0
