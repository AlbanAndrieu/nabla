# Introduction #

How to use VirtualBox for a developer workstation.

# How to resize your disk in VirtualBox #

Extend Ubuntu Disk Volume with GParted after Resizing Hard Drive : http://www.youtube.com/watch?v=cDgUwWkvuIY

Useful information can be found here : https://forums.virtualbox.org/viewtopic.php?f=6&t=46814

```
cd C:\Program Files\Oracle\VirtualBox
VBoxManage modifyhd C:\workspace\users\albandri10\.VirtualBox\HardDisks\Ubuntu.vdi --resize 20480
VBoxManage modifyhd C:\workspace\users\albandri10\.VirtualBox\HardDisks\Open Solaris.vdi --resize 20480
```