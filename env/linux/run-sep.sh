#!/bin/bash
set -xv

echo "Symantec Endpoint Protection"

/opt/Symantec/symantec_antivirus
sav info -s
sav info -p 
sav info -e
sav manage -p

#"C:\Program Files (x86)\Symantec\Symantec Endpoint Protection\DoScan" /ScanName "Weekly Scheduled Scan"
#"C:\Program Files (x86)\Symantec\Symantec Endpoint Protection\DoScan" /ScanName "Monday Night Scan"

#HKEY_LOCAL_MACHINE\SOFTWARE\WOW6432Node\Symantec\Symantec Endpoint Protection\AV\LocalScans\934f8e88-0ac7-0545-1f4a-7b6c06834e71\Schedule
#Name

# Check availability to virus definition portal https://sepm.finastra.global/secars/secars.dll?hello,secars

exit 0
