#!/bin/bash
set -xv

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
