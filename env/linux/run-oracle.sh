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
