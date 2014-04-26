#!/bin/bash

BACKUP_SOURCE="/jenkins"
BACKUP_TARGET="jenkins@192.168.0.46:/mnt/dpool/jenkins"

#rsync -arv --del --stats --progress $BACKUP_SOURCE $BACKUP_TARGET
rsync --delete -arv --chmod=Fa-w --stats --progress $BACKUP_SOURCE $BACKUP_TARGET

echo "Synchronization to freenas NABLA done"
