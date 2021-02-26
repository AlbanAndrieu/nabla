#!/bin/bash
set -xv

sudo apt-get remove libodbc1:i386 libodbc1
sudo apt-get remove unixodbc unixodbc-dev
sudo apt-get remove msodbcsql mssql-tools

# See https://docs.microsoft.com/fr-fr/sql/connect/odbc/linux-mac/installing-the-microsoft-odbc-driver-for-sql-server?view=sql-server-ver15#ubuntu17
curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add -
curl https://packages.microsoft.com/config/ubuntu/20.04/prod.list > /etc/apt/sources.list.d/mssql-release.list
rm /etc/apt/sources.list.d/mssql-release.list
sudo apt-get update
# optional: for unixODBC development headers
sudo apt-get install unixodbc-dev

sudo ACCEPT_EULA=Y apt-get install msodbcsql17
# optional: for bcp and sqlcmd
sudo ACCEPT_EULA=Y apt-get install mssql-tools
echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bash_profile
echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc
source ~/.bashrc

#Run odbcinst -j to get the location of the odbcinst.ini and odbc.ini
odbcinst -j

odbcinst -q -d

odbcinst -q -s

#freetds
tsql -C
Compile-time settings (established with the "configure" script)
                            Version: freetds v0.91
             freetds.conf directory: /etc/freetds
     MS db-lib source compatibility: no
        Sybase binary compatibility: yes
                      Thread safety: yes
                      iconv library: yes
                        TDS version: 4.2
                              iODBC: no
                           unixodbc: yes
              SSPI "trusted" logins: no
                           Kerberos: yes

#list available connection

tsql -LH DATABASESRV01
     ServerName DATABASESRV01
   InstanceName MSSQLSERVER
    IsClustered No
        Version 13.0.1601.5
            tcp 1433


tsql -H DATABASESRV01 -p 1433 -U 'sa' -P 'microsoft'

isql -v DATABASESRV01_2016 'sa' 'microsoft'

osql -S DATABASESRV01_2016 -U 'sa' -P 'microsoft'
