sudo ifconfig

sudo ifconfig wlan1 down
sudo iwconfig wlan1 mode monitor
sudo ifconfig wlan1 up

sudo apt-get install aircrack-ng

sudo airmon-ng start wlan1

sudo iwconfig
