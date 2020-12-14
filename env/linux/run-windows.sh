#!/bin/bash
set -xv

Get-Item -Path "C:\Program Files\Git\usr\bin\*.exe" | %{ Set-ProcessMitigation -Name $_.Name -Disable ForceRelocateImages }
Get-ChildItem -Path C:\tools\msys64 -Recurse -Include *exe | %{ Set-ProcessMitigation -Name $_.Name -Disable ForceRelocateImages }

Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux

sudo apt-get install libevtx-utils
evtxeport Security.evtx > security-evtx_export.txt

exit 0
