#!/bin/bash

BACKUP_SOURCE="/jenkins"
BACKUP_TARGET="albandri@freenas:/mnt/dpool/jenkins"

rsync -arv --del --stats --progress $BACKUP_SOURCE $BACKUP_TARGET

echo "Synchronization to freenas NABLA done"
