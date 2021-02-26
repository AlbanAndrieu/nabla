#!/bin/bash
set -xv

curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/v1.10.0/skaffold-linux-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin

skaffold version

exit 0
