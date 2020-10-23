#!/bin/bash
set -xv

Get-Item -Path "C:\Program Files\Git\usr\bin\*.exe" | %{ Set-ProcessMitigation -Name $_.Name -Disable ForceRelocateImages }
Get-ChildItem -Path C:\tools\msys64 -Recurse -Include *exe | %{ Set-ProcessMitigation -Name $_.Name -Disable ForceRelocateImages }

Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux

exit 0
