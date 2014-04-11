#this will sync localtime with ntp
#there are two dashes before systohc

/etc/init.d/ntpd stop
ntpdate timehost
hwclock --systohc
hwclock --show
/etc/init.d/ntpd start
