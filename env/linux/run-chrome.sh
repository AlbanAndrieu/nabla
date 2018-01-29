#!/bin/bash
set -xv

#Add DevTools terminal
#https://chrome.google.com/webstore/detail/devtools-terminal/leakmhneaibbdapdoienlkifomjceknl?hl=en

#Chrome remote desktop
#https://chrome.google.com/webstore/detail/chrome-remote-desktop/gbchcmhmhahfdphkhkmpfmihenigjmpp?hl=en

#Secure shell
#https://chrome.google.com/webstore/detail/secure-shell/pnhechapfaindjhompbnflcldabbghjo/related?hl=en

#Switchy omega
#https://chrome.google.com/webstore/detail/proxy-switchyomega/padekgcemlokbadohgkifijomclgjgif/related?hl=en

#RECX Security Analyzer
#https://chrome.google.com/webstore/detail/recx-security-analyser/ljafjhbjenhgcgnikniijchkngljgjda/related?hl=en

#[ubuntu] Bizarre Chromium/Chrome black screen problem
#Click drop-down menu on top-right corner –> click “Settings” –> click “Show advanced settings…” on the bottom –> scroll to the bottom, and uncheck “Use hardware acceleration when available”.

#See chrome://net-internals
#To disable HTS
#See chrome://net-internals/#hsts

gnome-keyring-daemon &
/usr/bin/google-chrome

#chrome://flags/#allow-insecure-localhost
