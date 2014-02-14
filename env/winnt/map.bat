cls
REM En tant que root
 
REM Demonter le path
REM umount f <path>
 
REM remonter les map
REM automount -v

NET USE I: /delete /yes
NET USE J: /delete /yes

NET USE I: \\ptxsnas01\project\dev_obj\users\albandri10
NET USE J: \\ptxsnas02\project\dev\users\albandri10

REM KZONE
NET USE Q: /delete /yes
NET USE Q: \\PTXSVKGR175\kzone-export

REM WORKSTATION SAMBA
NET USE X: \\Ptxw12662\share

NET USE X: \\192.168.0.28\share

NET USE P: \\kgrdb01\albandri  mysecretpw  /user:albandri /persistent:no

NET USE Z: /delete /yes
REM NET USE Z: \\nom_ou_IP_du_NAS\nom_du_partage /USER:utilisateur
NET USE Z: \\freenas\image /USER:albandri

pause