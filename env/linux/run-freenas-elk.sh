#!/bin/bash
set -xv

#See https://blog.gufi.org/2016/02/15/elk-first-part/

pkg install textproc/elasticsearch
pkg install sysutils/logstash
#textproc/kibana43
pkg install kibana5
#pkg install kibana5-search-guard
#pkg install kibana5-x-pack
pkg install www/nginx
pkg install node
pkg install npm
pkg install suricata

echo 'elasticsearch_enable="YES"' > /etc/rc.conf.d/elasticsearch
printf 'logstash_enable="YES"\nlogstash_log="YES"\nlogstash_log_file="/var/log/logstash.log"' > /etc/rc.conf.d/logstash
echo 'kibana_enable="YES"' > /etc/rc.conf.d/kibana
echo 'nginx_enable="YES"' > /etc/rc.conf.d/nginx

pkg install suricata

To run tcsd automatically, add the following line to /etc/rc.conf:

tcsd_enable="YES"

You might want to edit /usr/local/etc/tcsd.conf to reflect your setup.

If you want to use tcsd with software TPM emulator, use the following
configuration in /etc/rc.conf:

tcsd_enable="YES"
tcsd_mode="emulator"
tpmd_enable="YES"

To use TPM, add your_account to '_tss' group like following:

# pw groupmod _tss -m your_account
Message from suricata-4.0.0:
===========================================================================

If you want to run Suricata in IDS mode, add to /etc/rc.conf:

	suricata_enable="YES"
	suricata_interface="<if>"

NOTE: Declaring suricata_interface is MANDATORY for Suricata in IDS Mode.

However, if you want to run Suricata in Inline IPS Mode in divert(4) mode,
add to /etc/rc.conf:

	suricata_enable="YES"
	suricata_divertport="8000"

NOTE:
	Suricata won't start in IDS mode without an interface configured.
	Therefore if you omit suricata_interface from rc.conf, FreeBSD's
	rc.d/suricata will automatically try to start Suricata in IPS Mode
	(on divert port 8000, by default).

Alternatively, if you want to run Suricata in Inline IPS Mode in high-speed
netmap(4) mode, add to /etc/rc.conf:

	suricata_enable="YES"
	suricata_netmap="YES"

NOTE:
	Suricata requires additional interface settings in the configuration
	file to run in netmap(4) mode.

RULES: Suricata IDS/IPS Engine comes without rules by default. You should
add rules by yourself and set an updating strategy. To do so, please visit:

 http://www.openinfosecfoundation.org/documentation/rules.html
 http://www.openinfosecfoundation.org/documentation/emerging-threats.html

You may want to try BPF in zerocopy mode to test performance improvements:

	sysctl -w net.bpf.zerocopy_enable=1

Don't forget to add net.bpf.zerocopy_enable=1 to /etc/sysctl.conf
