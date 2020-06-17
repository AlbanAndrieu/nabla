#!/bin/bash
set -xv

# See https://saas.whitesourcesoftware.com/Wss/WSS.html#!login

#WHITESOURCE_TOKEN is the apikey

# See https://whitesource.atlassian.net/wiki/spaces/WD/pages/33718339/Unified+Agent#UnifiedAgent-Installation

cd ~
wget https://unified-agent.s3.amazonaws.com/wss-unified-agent-20.2.1.jar

ls -lrta wss-unified-agent.config
java -jar ~/wss-unified-agent-20.2.1.jar -c ~/wss-unified-agent.config -apiKey b09995d800424b36a685f75dd7dd2c8856d7a465bae94a27b0e0ab89930f5248 -product "FusionRisk" -project "FR UXP Components"

exit 0
