:: delete native launchers
del "$INSTALL_PATH\bin\*.exe"
del "$INSTALL_PATH\.installationinformation"

:: remove file associations
ftype Nabla= 
assoc .nabla=
