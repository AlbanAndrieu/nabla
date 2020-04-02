#!/bin/bash
set -xv

#See https://blog.ithasu.org/2019/01/monitoring-de-la-livebox-4-avec-grafana/

###########################################
# Firmware Livebox 4 = 3.4.10 g0-f-sip-fr #
#     Script mis a jour le 06/04/2018     #
###########################################

WORKING_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

#############################
# Declaration des variables #
#############################
myLivebox=192.168.1.1
myPassword=${LIVEBOX_PASSWORD}

#myBashDir=/volume1/web/cacti/scripts/
myBashDir=${WORKING_DIR}

myOutput=$myBashDir/myOutput.txt
myCookies=$myBashDir/myCookies.txt

########################################
# Connexion et recuperation du cookies #
########################################
curl -s -o "$myOutput" -X POST -c "$myCookies" -H 'Content-Type: application/x-sah-ws-4-call+json' -H 'Authorization: X-Sah-Login' -d "{\"service\":\"sah.Device.Information\",\"method\":\"createContext\",\"parameters\":{\"applicationName\":\"so_sdkut\",\"username\":\"admin\",\"password\":\"$myPassword\"}}" http://$myLivebox/ws > /dev/null

##################################################
# Lecture du cookies pour utilisation ulterieure #
##################################################
myContextID=$(tail -n1 "$myOutput" | sed 's/{"status":0,"data":{"contextID":"//1'| sed 's/",//1' | sed 's/"groups":"http,admin//1' | sed 's/"}}//1')

###############################################################################################
# Envoi des commandes pour recuperer les informtations et ecriture dans un fichier TXT separe #
###############################################################################################
getDSLStats=`curl -s -b "$myCookies" -X POST -H 'Content-Type: application/x-sah-ws-4-call+json' -H "X-Context: $myContextID" -d "{\"service\":\"NeMo.Intf.dsl0\",\"method\":\"getDSLStats\",\"parameters\":{}}" http://$myLivebox/ws`
getMIBs=`curl -s -b "$myCookies" -X POST -H 'Content-Type: application/x-sah-ws-4-call+json' -H "X-Context: $myContextID" -d "{\"service\":\"NeMo.Intf.data\",\"method\":\"getMIBs\",\"parameters\":{}}" http://$myLivebox/ws`
echo $getDSLStats > $myBashDir/DSLStats.txt
echo $getMIBs > $myBashDir/MIBs.txt

#######################################################
# Deconnexion et suppression des fichiers temporaires #
#######################################################
curl -s -b "$myCookies" -X POST http://$myLivebox/logout
rm "$myCookies" "$myOutput"

#############################################################################
# Extraction des informations. A commenter ou decommenter selon les besoins #
#############################################################################
# Extraction des informations pour le traffic temps reel
ReceiveBlocks=`echo $getDSLStats | cut -d":" -f3 | cut -d"," -f1`
TransmitBlocks=`echo $getDSLStats | cut -d":" -f4 | cut -d"," -f1`

# Extraction des caracteristiques de la ligne
ErroredSecs=`echo $getDSLStats | cut -d":" -f10 | cut -d"," -f1`
SeverelyErroredSecs=`echo $getDSLStats | cut -d":" -f11 | cut -d"," -f1`
FECErrors=`echo $getDSLStats | cut -d":" -f12 | cut -d"," -f1`
ATUCFECErrors=`echo $getDSLStats | cut -d":" -f13 | cut -d"," -f1`
HECErrors=`echo $getDSLStats | cut -d":" -f14 | cut -d"," -f1`
ATUCHECErrors=`echo $getDSLStats | cut -d":" -f15 | cut -d"," -f1`
CRCErrors=`echo $getDSLStats | cut -d":" -f16 | cut -d"," -f1`
ATUCCRCErrors=`echo $getDSLStats | cut -d":" -f17 | cut -d"," -f1 | cut -d"}" -f1`

# Extraction de l'uptime debit et marge de bruit
Uptime=`echo $getMIBs | cut -d":" -f134 | cut -d"," -f1`
UpstreamCurrRate=`echo $getMIBs | cut -d":" -f236 | cut -d"," -f1`
DownstreamCurrRate=`echo $getMIBs | cut -d":" -f237 | cut -d"," -f1`
UpstreamMaxRate=`echo $getMIBs | cut -d":" -f239 | cut -d"," -f1`
DownstreamMaxRate=`echo $getMIBs | cut -d":" -f240 | cut -d"," -f1`
UpstreamNoiseMargin=`echo $getMIBs | cut -d":" -f245 | cut -d"," -f1`
DownstreamNoiseMargin=`echo $getMIBs | cut -d":" -f246 | cut -d"," -f1`

###########################################
# Ecriture des informations pour RRDTools #
###########################################
printf "ReceiveBlocks:%s TransmitBlocks:%s ErroredSecs:%s SeverelyErroredSecs:%s FECErrors:%s ATUCFECErrors:%s HECErrors:%s ATUCHECErrors:%s CRCErrors:%s ATUCCRCErrors:%s Uptime:%s UpstreamCurrRate:%s DownstreamCurrRate:%s UpstreamMaxRate:%s DownstreamMaxRate:%s UpstreamNoiseMargin:%s DownstreamNoiseMargin:%s\n" $ReceiveBlocks $TransmitBlocks $ErroredSecs  $SeverelyErroredSecs $FECErrors $ATUCFECErrors $HECErrors $ATUCHECErrors $CRCErrors $ATUCCRCErrors $Uptime $UpstreamCurrRate $DownstreamCurrRate $UpstreamMaxRate $DownstreamMaxRate $UpstreamNoiseMargin $DownstreamNoiseMargin
