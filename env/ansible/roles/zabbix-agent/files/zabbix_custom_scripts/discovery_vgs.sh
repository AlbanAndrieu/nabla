#!/bin/bash
#
# Orignal script of ZFS discovery by Neptunus from zabbix forum adapted  for lvm VGS

# Author: Adham Helal


n=0
#for i in $(/sbin/zpool list -H -o name) ; do
for i in $(sudo vgs --noheadings -o vg_name) ; do
  pools[$n]="$i"
  #echo "Pool: $n = $i"     #to confirm the entry
  let "n= $n + 1"
done

# Get length of an array
length=${#pools[@]}

echo "{"
echo -e "\t\"data\":[\n"

for (( i=0; i<${length}; i++ ))
do
   if [ $i == $length ]; then
     echo -e "\t{ \"{#VGNAME}\":\"${pools[$i]}\" }"
   else
     echo -e "\t{ \"{#VGNAME}\":\"${pools[$i]}\" },"
   fi
done

echo -e "\n\t]\n"
echo "}"