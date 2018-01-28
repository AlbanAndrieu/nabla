#!/bin/bash
#############################################
#
# VMware vRealize Automation client CLI v0.2
#
# Dependencies: bash, python, curl, ping
#
#############################################

#############################################
#
# Default values
#
#############################################

VCACTENANT="vsphere.local"
VRA=""
VCACUSER=""
VCACPASS=""
FORCE="0"
MEMORY="1"
CPU="1"
DISK="25"
DESC="Created by CLI"

#############################################
#
# Login
#
#############################################

function login {
if [ "$VRA" == "" ]
then
  echo -n "VRA host: "
  read VRA
fi

if [ "$VCACUSER" == "" ]
then
  echo -n "User for $VRA: "
  read VCACUSER
fi

if [ "$VCACPASS" == "" ]
then
  echo -n "Password for $VCACUSER at $VRA: "
  read -s VCACPASS
  echo ""
fi

echo "Authenticate to $VRA..."
VCACAUTH="Bearer $(curl --insecure -H "Accept: application/json" -H "Content-Type: application/json" \
--data '{"username":"'"${VCACUSER}"'","password":"'"${VCACPASS}"'","tenant":"'"${VCACTENANT}"'"}' \
https://$VRA/identity/api/tokens 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['id'];" 2>/dev/null)"
if [ "$VCACAUTH" == "Bearer " ]
then
  echo "Failed."
  exit 1
else
  echo "Ok."
fi
}

#############################################
#
# VMs
#
#############################################

function vms {
echo "List of VMs:"
echo ""
REQUEST="https://$VRA/catalog-service/api/consumer/resources"
curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
$REQUEST 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(n!=len(obj['content'])-1):
 n=n+1
 print 'Name : '+obj['content'][n]['name']
 print 'Label: '+obj['content'][n]['catalogItem']['label']
 if obj['content'][n]['description'] is not None:
  print 'Desc : '+obj['content'][n]['description']
 print 'Org  : '+obj['content'][n]['organization']['subtenantLabel']
 if obj['content'][n]['owners'][0]['value'] is not None:
  print 'Owner: '+obj['content'][n]['owners'][0]['value']
 print ''
" 2>/dev/null
}

#############################################
#
# Status
#
#############################################

function status {
echo -n "Status of $HOST: "
FILTER="https://$VRA/catalog-service/api/consumer/resources?\$filter=name%20eq%20'$HOST'"
ID=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
$FILTER 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['content'][0]['id'];")
REQUEST="https://$VRA/catalog-service/api/consumer/resources/$ID"
curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
$REQUEST 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(obj['resourceData']['entries'][n]['key']!='MachineStatus'):
 n=n+1
print obj['resourceData']['entries'][n]['value']['value']
" 2>/dev/null
}

#############################################
#
# Blueprints
#
#############################################

function blueprints {
echo "List of available blueprints:"
echo ""
curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
https://$VRA/catalog-service/api/consumer/entitledCatalogItems 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(n!=len(obj['content'])-1):
 n=n+1
 print 'Desc: '+obj['content'][n]['catalogItem']['description']
 print 'Name: '+obj['content'][n]['catalogItem']['name']
 print 'Org : '+obj['content'][n]['catalogItem']['organization']['subtenantLabel']
 print 'ID  : '+obj['content'][n]['catalogItem']['id']
 print ''
" 2>/dev/null
}

#############################################
#
# Create
#
#############################################

function create {
REQLIST="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
https://$VRA/catalog-service/api/consumer/entitledCatalogItems 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(obj['content'][n]['catalogItem']['id']!='${REQID}'):
 n=n+1
print obj['content'][n]['catalogItem']['organization']['subtenantLabel']+' '+obj['content'][n]['catalogItem']['organization']['subtenantRef']+' '+obj['content'][n]['catalogItem']['providerBinding']['bindingId']
" 2>/dev/null)"

REQNAME="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
https://$VRA/catalog-service/api/consumer/entitledCatalogItems 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(obj['content'][n]['catalogItem']['id']!='${REQID}'):
 n=n+1
print obj['content'][n]['catalogItem']['name']
" 2>/dev/null)"

REQ=($REQLIST)

SURE="y"
if [ "$FORCE" == "0" ]
then
  echo -n "Are you sure you want to create a new VM from \"$REQNAME\" to ${REQ[0]} (y/n)? "
  read SURE
fi
if [ "$SURE" != "y" ]
then
  exit 0
fi

echo "Creating a new VM from \"$REQNAME\" to ${REQ[0]}"
let MEMORY=MEMORY*1024
REQUEST="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" --verbose \
--data '
{
 "@type":"CatalogItemRequest",
 "catalogItemRef":{
  "id":"'"${REQID}"'",
  "label":"'"${REQNAME}"'"
 },
 "organization":{
  "subtenantLabel":"'"${REQ[0]}"'",
  "subtenantRef":"'"${REQ[1]}"'",
  "tenantLabel":"vsphere.local",
  "tenantRef":"vsphere.local"
 },
 "requestedFor":"'"${VCACUSER}"'",
 "state":"SUBMITTED",
 "requestNumber":0,
 "requestData":{
  "entries":[
  {
   "key":"provider-Machine.SSH",
   "value":{
    "type":"string",
    "value":"True"
   }
  },
  {
   "key":"requestedFor",
   "value":{
    "type":"string",
    "value":"'"${VCACUSER}"'"
   }
  },
  {
   "key":"provider-blueprintId",
   "value":{
    "type":"string",
    "value":"'"${REQ[2]}"'"
   }
  },
  {
   "key":"provider-Snapshot.Policy.Limit",
   "value":{
    "type":"string",
    "value":"3"
   }
  },
  {
   "key":"provider-Snapshot.Policy.AgeLimit",
   "value":{
    "type":"string",
    "value":"3"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.MaxCost",
   "value":{
    "type":"string",
    "value":"0"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.TotalStorageSize",
   "value":{
    "type":"decimal",
    "value":'${DISK}'.0
   }
  },
  {
   "key":"provider-provisioningGroupId",
   "value":{
    "type":"string",
    "value":"'"${REQ[1]}"'"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.AssignToUser",
   "value":{
    "type":"string",
    "value":"'"${VCACUSER}"'"
   }
  },
  {
   "key":"provider-VirtualMachine.LeaseDays",
   "value":{
    "type":"integer",
    "value":0
   }
  },
  {
   "key":"provider-VMware.VirtualCenter.Folder",
   "value":{
    "type":"string",
    "value":"'"${REQ[0]}"'"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.Description",
   "value":{
    "type":"string",
    "value":"'"${DESC}"'"
   }
  },
  {
   "key":"provider-VirtualMachine.Disk0.IsClone",
   "value":{
    "type":"string",
    "value":"true"
   }
  },
  {
   "key":"provider-OS",
   "value":{
    "type":"string",
    "value":"rhel7"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.Reason",
   "value":{
    "type":"string",
    "value":""
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.NumberOfInstances",
   "value":{
    "type":"integer",
    "value":1
   }
  },
  {
   "key":"provider-VirtualMachine.CPU.Count",
   "value":{
    "type":"integer",
    "value":'${CPU}'
   }
  },
  {
   "key":"provider-__Notes",
   "value":{
    "type":"string",
    "value":"'"${DESC}"'"
   }
  },
  {
   "key":"provider-VirtualMachine.Disk0.Size",
   "value":{
    "type":"string",
    "value":"'"${DISK}"'"
   }
  },
  {
   "key":"provider-Cafe.Shim.VirtualMachine.MinCost",
   "value":{
    "type":"string",
    "value":"0"
   }
  },
  {
   "key":"provider-VirtualMachine.Memory.Size",
   "value":{
    "type":"integer",
    "value":'${MEMORY}'
   }
  }
  ]
 }
}
' \
https://$VRA/catalog-service/api/consumer/requests 2>&1 |grep Location |cut -d\  -f3 |cut -d$'\r' -f 1)"

if [ "$REQUEST" != "" ]
then
  REQUESTNUM="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
  $REQUEST 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['requestNumber'];" 2>/dev/null)"
  echo "Request number: $REQUESTNUM"
  echo "Waiting for the new VM. (It takes approximately ten minutes...)"
else
  echo "Failed"
  exit 1
fi

STATE="IN_PROGRESS"
while [ "$STATE" == "IN_PROGRESS" ] || [ "$STATE" == "PROVIDER_COMPLETED" ] || [ "$STATE" == "POST_APPROVED" ]
do
  sleep 30
  STATE="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
  $REQUEST 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['state'];" 2>/dev/null)"
  echo $STATE
done

if [ "$STATE" == "SUCCESSFUL" ]
then
  HOST=""
  HOST="$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
  $REQUEST 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['requestCompletion']['completionDetails'];" 2>/dev/null |cut -d\  -f4 |cut -d. -f1)"
  if [ "$HOST" != "" ]
  then
    echo ""
    echo "Waiting for the DNS servers. (It takes approximately ten minutes also...)"
    while [ "0" == "ping -c 1 $HOST 2>/dev/null |grep -c received" ]
    do
      sleep 10
      echo -n "."
    done
    echo ""
    echo "Hostname: $HOST"
    echo "Done."
  else
    echo "Failed."
    exit 1
  fi
else
  echo "Failed."
  exit 1
fi
}

#############################################
#
# Action
#
#############################################

function action {
FILTER="https://$VRA/catalog-service/api/consumer/resources?\$filter=name%20eq%20'$HOST'"
ID=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
$FILTER 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['content'][0]['id'];")

REQUEST="https://$VRA/catalog-service/api/consumer/resources/$ID"
REQLIST=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
$REQUEST 2>/dev/null | python -c "import json,sys
obj=json.load(sys.stdin)
n=0
while(obj['operations'][n]['bindingId']!='$ACTION'):
 n=n+1
print obj['organization']['subtenantRef']+' '+obj['organization']['subtenantLabel']+' '+obj['operations'][n]['id']" 2>/dev/null)

REQ=($REQLIST)

SURE="y"
if [ "$FORCE" == "0" ]
then
  echo -n "Are you sure you want to do $ACTION to $HOST (y/n)? "
  read SURE
fi
if [ "$SURE" != "y" ]
then
  exit 0
fi

echo Doing $ACTION to $HOST

REQUEST=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" --verbose \
--data '
{
 "@type":"ResourceActionRequest",
 "resourceRef":{
  "id":"'${ID}'"
 },
 "resourceActionRef":{
  "id":"'${REQ[2]}'"
 },
 "organization":{
  "tenantRef":"vsphere.local",
  "tenantLabel":"vsphere.local",
  "subtenantRef":"'${REQ[0]}'",
  "subtenantLabel":"'${REQ[1]}'"
 },
 "state":"SUBMITTED",
 "requestNumber":0,
 "requestData":{
  "entries":[]
 }
}
' \
https://$VRA/catalog-service/api/consumer/requests 2>&1 |grep Location |cut -d\  -f3 |cut -d$'\r' -f 1)

if [ "$REQUEST" != "" ]
then
  REQUESTNUM=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
  $REQUEST 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['requestNumber'];" 2>/dev/null)
  echo "Request number: $REQUESTNUM"
  echo "Waiting for the action."
else
  echo "Failed."
  exit 1
fi

STATE="IN_PROGRESS"
while [ "$STATE" == "IN_PROGRESS" ] || [ "$STATE" == "PROVIDER_COMPLETED" ] || [ "$STATE" == "POST_APPROVED" ]
do
  sleep 5
  STATE=$(curl --insecure -H "Accept: application/json" -H "Authorization: $VCACAUTH" -H "Content-Type: application/json" \
  $REQUEST 2>/dev/null | python -c "import json,sys;obj=json.load(sys.stdin);print obj['state'];" 2>/dev/null)
  echo $STATE
done
if [ "$STATE" == "SUCCESSFUL" ]
then
  echo "Done."
else
  echo "Failed."
  exit 1
fi
}

#############################################
#
# Help
#
#############################################

function help {
echo "VMware vRealize Automation client CLI v0.1"
echo ""
echo "Usage: micli.sh <COMMAND> [OPTIONS]"
echo ""
echo "Commands:"
echo "  lm - List of VMs"
echo "  lb - List of available blueprints"
echo "  cm <blueprint ID> [create options]- Create a VM"
echo "  qm <hostname> - Status of a VM"
echo "  sm <hostname> - Shutdown a VM"
echo "  pm <hostname> - Poweroff a VM"
echo "  om <hostname> - Poweron a VM"
echo "  bm <hostname> - Reboot a VM (soft reset)"
echo "  rm <hostname> - Reset a VM (hard reset)"
echo "  dm <hostname> - Destroy a VM"
echo ""
echo "Options:"
echo "  -v|--vra <VRA host>      - VRA host"
echo "                             (for example: -v micloudpar.nabla.mobi)"
echo "  -u|--user <username>     - Username for VRA"
echo "                             (for example: -u john.smith@nabla.mobi)"
echo "  -p|--password <password> - Password for VRA"
echo "  -f|--force               - Force the command"
echo "                             (There will be no confirmation)"
echo ""
echo "Create options:"
echo "  -m|--memory <number>    - Memory size of the new VM (in gigabytes)"
echo "  -c|--cpu <number>       - CPU cores of the new VM"
echo "  -d|--disk <number>      - Disk size of the new VM (in gigabytes)"
echo "                            This feature not works in currently"
echo "  -n|--description <text> - Description of the new VM"
echo ""
echo "Example: micli.sh cm 104eaa9c-d259-41d9-821f-7d7e6611972a -m 4 -c 1 \\"
echo "                  -n \"Example VM\" -v micloudpar.nabla.mobi \\"
echo "                  -u john.smith@nabla.mobi -p password -f"
exit 0
}

case $1 in
 lb)
  CMD=$1
 ;;
 lm)
  CMD=$1
 ;;
 cm)
  REQID=$2
  CMD=$1
 ;;
 qm)
  HOST=$2
  CMD=$1
 ;;
 sm)
  HOST=$2
  ACTION="Infrastructure.Machine.Action.Shutdown"
  CMD=$1
 ;;
 pm)
  HOST=$2
  ACTION="Infrastructure.Machine.Action.PowerOff"
  CMD=$1
 ;;
 om)
  HOST=$2
  ACTION="Infrastructure.Machine.Action.PowerOn"
  CMD=$1
 ;;
 bm)
  HOST=$2
  ACTION="Infrastructure.Machine.Action.Reboot"
  CMD=$1
 ;;
 rm)
  HOST=$2
  ACTION="Infrastructure.Machine.Action.Reset"
  CMD=$1
 ;;
 dm)
  HOST=$2
  ACTION="Infrastructure.Virtual.Action.Destroy"
  CMD=$1
 ;;
 *)
  CMD=$1
 ;;
esac

while [[ $# -gt 0 ]]
do
key="$1"
case $key in
  -v|--vra)
    VRA="$2"
    shift
  ;;
  -u|--user)
    VCACUSER="$2"
    shift
  ;;
  -p|--password)
    VCACPASS="$2"
    shift
  ;;
  -f|--force)
    FORCE="1"
  ;;
  -m|--memory)
    MEMORY="$2"
    shift
  ;;
  -c|--cpu)
    CPU="$2"
    shift
  ;;
  -n|--description)
    DESC="$2"
    shift
  ;;
  -d|--disk)
    DISC="$2"
    shift
  ;;
esac
shift
done

case $CMD in
 lb)
  login
  blueprints
 ;;
 lm)
  login
  vms
 ;;
 cm)
  login
  create
 ;;
 qm)
  login
  status
 ;;
 sm)
  login
  action
 ;;
 pm)
  login
  action
 ;;
 om)
  login
  action
 ;;
 bm)
  login
  action
 ;;
 rm)
  login
  action
 ;;
 dm)
  login
  action
 ;;
 *)
  help
 ;;
esac
