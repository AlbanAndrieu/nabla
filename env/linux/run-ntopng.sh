#http://www.ntop.org/products/traffic-analysis/ntop/

#See http://localhost:3000/

#http://stackoverflow.com/questions/6133781/disabling-lro-using-ethtool
sudo ethtool -k eth1
sudo ethtool -k eth1 | grep large-receive-offload
#Fixed
#sudo ethtool -K eth1 lro off
