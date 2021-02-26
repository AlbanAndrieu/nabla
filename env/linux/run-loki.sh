#!/bin/bash
set -xv

# See https://github.com/Neo23x0/Loki

#wget https://github.com/Neo23x0/Loki/releases/download/0.32.1/loki_0.32.1.zip
git clone https://github.com/Neo23x0/Loki.git
cd Loki/

source /opt/ansible/env/bin/activate
pip install yara-python psutil netaddr pylzma colorama
#pip install psutil netaddr wmi colorama pylzma pycrypto yara-python pywin32 rfc5424-logging-handler setuptools==19.2 pyinstaller==2.1
/opt/ansible/env/bin/python loki-upgrader.py  --sigsonly
/opt/ansible/env/bin/python loki.py -p /opt/ -l loki-report.log --nolisten --onlyrelevant --dontwait --noprocscan

exit 0
