#!/bin/bash
# Script "ClamAV Temps Réel", par HacKurx
# http://hackurx.wordpress.com
# Licence: GPL v3
# Dépendance: clamav-daemon inotify-tools
# Recommandé pour PC de bureau: libnotify-bin

DOSSIER=$HOME
QUARANTAINE=/tmp
LOG=$HOME/.clamavd-tr.log

while :
do

inotifywait -q -r -e  create,modify,move,delete,open,close,access  "$DOSSIER" --format '%w%f|%e' | sed --unbuffered 's/|.*//g' |

while read FICHIER; do
    clamdscan -m -v --fdpass "$FICHIER" --move=$QUARANTAINE
        if [ "$?" == "1" ]; then
            echo "`date` - Malware trouvé dans le fichier '$FICHIER'. Le fichier a été déplacé dans $QUARANTAINE." >> $LOG
            echo -e "\033[31mMalware trouvé!!!\033[00m" "Le fichier '$FICHIER' a été déplacé en quarantaine."
            if [ -f /usr/bin/notify-send ]; then
                notify-send -u critical "ClamAV Temps Réel" "Malware trouvé!!! Le fichier '$FICHIER' a été déplacé en quarantaine."
            fi
        fi
done
done

exit 0
