#!/bin/bash
set -xv

#See https://www.crowdstrike.com/

#falcon agent
    
#cd /tmp; wget http://10.22.212.139/falcon/Redhat.zip; unzip Redhat.zip; cd Redhat; wget http://10.22.212.139/falcon/libnl-1.1.4-3.el7.x86_64.rpm; rpm -i libnl-1.1.4-3.el7.x86_64.rpm; rpm -i falcon-sensor-5.28.0-9205.el7.x86_64.rpm; /opt/CrowdStrike/falconctl -s --cid=A0DDF149ED9147C9844E012249585DD9-EF; systemctl start falcon-sensor.service; systemctl status falcon-sensor.service
#cd /tmp; wget http://10.22.212.139/falcon/Redhat.zip; unzip Redhat.zip; cd Redhat; rpm -i falcon-sensor-5.28.0-9205.el6.x86_64.rpm; /opt/CrowdStrike/falconctl -s --cid=A0DDF149ED9147C9844E012249585DD9-EF; service falcon-sensor start; service falcon-sensor status
#cd /tmp; wget http://10.22.212.139/falcon/Ubuntu.zip; unzip Ubuntu.zip; cd Ubuntu; dpkg -i falcon-sensor_5.28.0-9205_amd64.deb; /opt/CrowdStrike/falconctl -s --cid=A0DDF149ED9147C9844E012249585DD9-EF; systemctl start falcon-sensor.service; systemctl status falcon-sensor.service
#cid=A0DDF149ED9147C9844E012249585DD9-EF

# Check server is reported in http://crowdstrike.provides.io/

exit 0
