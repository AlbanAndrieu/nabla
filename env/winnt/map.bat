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
NET USE X: \\PTXSKPLUSTP040\kzone-export

REM WORKSTATION SAMBA
NET USE X: \\Ptxw12662\share

pause