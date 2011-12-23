#!/bin/csh -f

#*---------------------------------------------------------------------*/
#*    Set K+ KIS Server aliases                             */
#*---------------------------------------------------------------------*/

alias launchKis${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest/not_packaged/launch_kis.sh"
alias shutdownKis${KPLUSTP_MAJOR_VERSION} "/usr/local/bin/sudo /kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest/not_packaged/shutdown_kis.sh"


#*---------------------------------------------------------------------*/
#*    Set K+TP Application aliases                                  */
#*---------------------------------------------------------------------*/

alias launchLatest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest/not_packaged/launchAll.sh"
alias shutdownLatest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest/not_packaged/shutdownAll.sh"
alias aliveLatest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/latest/not_packaged/aliveAll.sh"

alias launchInstalled${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/installed/not_packaged/launchAll.sh"
alias shutdownInstalled${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/installed/not_packaged/shutdownAll.sh"
alias aliveInstalled${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/x86_installed/not_packaged/aliveAll.sh"

alias launchTest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/test/not_packaged/launchAll.sh"
alias shutdownTest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/test/not_packaged/shutdownAll.sh"
alias aliveTest${KPLUSTP_MAJOR_VERSION} "/kplustp/deploy/${KPLUSTP_MAJOR_VERSION}/test/not_packaged/aliveAll.sh"

#*---------------------------------------------------------------------*/
#*    Set Kondor+ Application aliases                                  */
#*---------------------------------------------------------------------*/

alias DealManager 'DealManager -D ${KPLUS_CONFIG_PATH}'
alias Admin 'Admin -D ${KPLUS_CONFIG_PATH}'
alias KplusBatch 'KplusBatch -D ${KPLUS_CONFIG_PATH}'
alias DataManager 'DataManager -D ${KPLUS_CONFIG_PATH}'
alias RealTimeManager 'RealTimeManager -D ${KPLUS_CONFIG_PATH}'
alias ReportManager 'ReportManager -D ${KPLUS_CONFIG_PATH}'
alias CommManager 'CommManager -D ${KPLUS_CONFIG_PATH}'
alias CapitalManager 'CapitalManager -D ${KPLUS_CONFIG_PATH}'
alias GlobalRiskManager 'GlobalRiskManager -D ${KPLUS_CONFIG_PATH}'
alias GlobalRiskBatch 'GlobalRiskBatch -D ${KPLUS_CONFIG_PATH}'
alias KreditNet 'KreditNet -D ${KPLUS_CONFIG_PATH}'
alias ReportBatch 'ReportBatch -D ${KPLUS_CONFIG_PATH}'
alias AutoPatcher 'AutoPatcher -D ${KPLUS_CONFIG_PATH}'
