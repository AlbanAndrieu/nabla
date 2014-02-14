#!/bin/bash

BACKUP_SOURCE="/jenkins"
BACKUP_TARGET="albandri@freenas:/mnt/dpool"

#rsync -arv --del --stats --progress $BACKUP_SOURCE $BACKUP_TARGET
rsync --delete -arv --chmod=Fa-w --stats --progress $BACKUP_SOURCE $BACKUP_TARGET

echo "Synchronization to freenas NABLA done"
