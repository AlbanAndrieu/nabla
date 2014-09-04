#http://doc.ubuntu-fr.org/xrdp

#sudo /etc/init.d/xrdp restart

#configure the  VM inside VirtualBox
#https://www.youtube.com/watch?v=mFk0Stw3EZQ

#https://www.virtualbox.org/manual/ch07.html
VBoxManage modifyvm "Windows7Misys" --vrde on
VBoxManage modifyvm "Windows7Misys" --vrdeport 5000,5010-5012
VBoxManage showvminfo  "Windows7Misys"
vboxmanage modifyvm "Windows7Misys" --vrdeproperty "Security/Method=negotiate"

Display -> Remote Display
Server port : 5000
Authentification method : Guest

NAT
Port forwrding rule
RDP TCP 10 .25 .40 .139 5000 10 .0  .2  .15  3389

#In your RDP client (remmina), you must enter:
#dedicated_host_name_or_IP:RDP_port_number_of the_VM
#for instance:
localhost:5001 # if I connect a VM running on my Virtual Box server.
10.25.40.139:5000 # IP adress of my dedicated server not of the VM.

With RDP
Username : aandrieu
Domain : MISYSROOT

Advanced -> Security : RDP
Advanced -> Disable clipboard sync

#On windows enable ping 
#cmd
netsh advfirewall firewall add rule name="All ICMP V4" protocol=icmpv4:any,any dir=in action=allow
netsh advfirewall firewall add rule Profile=public name="Allow WinRM HTTPS" dir=in localport=5986 protocol=TCP action=allow
NetSH ADVFirewall Set AllProfiles Settings remotemanagement Enable

#see https://github.com/diyan/pywinrm
winrm set winrm/config/client/auth @{Basic="true"}
winrm set winrm/config/service/auth @{Basic="true"}
winrm set winrm/config/service @{AllowUnencrypted="true"}
#powershell
Get-ExecutionPolicy -Scope CurrentUser
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned

#remmina is a client to connect with RDP or VNC
#
rm -Rf ~/.freerdp

#http://askubuntu.com/questions/157723/cannot-rdp-to-windows-7-with-remmina-on-12-04
#When I edited the connection properties, I looked on the "advanced" tab and changed the security from "negotiate" to "TLS", and voila, everything works.
#Strangely, "negotiate" still works on the laptop, but at least I'm back in business with my bigger monitor 

#Save configuration
#~/.remmina

#vino
pkill vino
export DISPLAY=:0.0
/usr/lib/vino/vino-server &
3389
