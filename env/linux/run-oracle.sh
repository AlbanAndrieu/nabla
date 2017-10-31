#!/bin/bash
set -xv

#http://blog.whitehorses.nl/2014/03/18/installing-java-oracle-11g-r2-express-edition-and-sql-developer-on-ubuntu-64-bit/

#See https://help.ubuntu.com/community/Oracle%20Instant%20Client

sudo su -

apt-get install alien libaio1 unixodbc

sudo alien -i oracle-instantclient12.2*-basic-*.rpm
sudo alien -i oracle-instantclient12.2*-devel-*.rpm
sudo alien -i oracle-instantclient12.2*-sqlplus-*.rpm

echo /usr/lib/oracle/12.2/client64/lib > /etc/ld.so.conf.d/oracle.conf
sudo ldconfig

#/usr/lib/oracle/12.2/client64/bin/sqlplus --version

export ORACLE_CLIENT_HOME=/usr/lib/oracle/12.2/client64
#export ORACLE_CLIENT_HOME=/opt/oracle/instantclient_12_2
export LD_LIBRARY_PATH=${ORACLE_CLIENT_HOME}/lib:$LD_LIBRARY_PATH
export PATH=${ORACLE_CLIENT_HOME}/bin:$PATH

#TODO

#memory
#pga (program global area) and sga (system global area)
#listeners
lsnrctl status
lsnrctl start
lsnrctl stop
#use file listener.ora
cd ${ORACLE_HOME}/NETWORK/ADMIN
#do not use localhost
#SID = instance
#start your listeners first then start your services (for automatic registration of your instance in your listeners)
#or do it by hand
#SQL > alter system register
#tns = aliases
#tnsnames.ora
#INSTANCE_NAME = (advice to use the same name as the database)
#SID = uniq instance name
#SERVICE_NAME = TOTO can be connected to ORCL and ORCL1 and ORCL2 (use SERVICE_NAME instead of SID)
#ORACLE_UNQNAME = variable that define your database (should be the same as DBNAME)
#DBNAME = identifier of your database = ORCL and ORCL1 (replication of ORCL) and ORCL2 (replication of ORCL)
#ORCL and ORCL1 and ORCL2 are replications for load balancing purpose
#SQL developer (better than TOAD for oracle) it is free
#inside sqldeveloper folder find sqldeveloper.conf
#change language by adding
AddVMOption -Duser.language=en
#Database connection
#tip about connection name user@myserver
#use below variable to point to the right tns
$TNS_ADMIN

show pagesize
set pagesize 50000
set linesize 9999

select * from dba_datapump_jobs
select 'drop table' || owner_name || '.' || job_name || ';' from dba_datapump_jobs

#under windows
set ORACLE_HOSTNAME=albandri.nabla.mobi
set ORACLE_UNQNAME=oracle
emctl status dbconsole

#interface
dbca

#See https://github.com/oracle/docker-images
#https://github.com/oracle/docker-images/tree/master/OracleDatabase

#See https://store.docker.com/profiles/nabla/content/sub-b4503f3c-7a0b-45ed-af61-9c433c23009a
docker pull store/oracle/database-instantclient:12.2.0.1
#See https://store.docker.com/profiles/nabla/content/sub-2569546c-bd90-4101-872c-1a21cfdcd2a6
docker pull store/oracle/database-enterprise:12.2.0.1

exit 0
