#!/bin/bash
set -xv

# See https://docs.microsoft.com/en-us/sql/linux/quickstart-install-connect-docker?view=sql-server-2017&pivots=cs1-bash

docker pull microsoft/mssql-server-linux:latest
#docker pull store/microsoft/mssql-server-linux:2017-GA
#docker pull mcr.microsoft.com/mssql/server:2017-latest

sudo docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=<YourStrong!Passw0rd>' \
   -e "MSSQL_PID=developer"
   -p 1433:1433 --name sql1 \
   -d microsoft/mssql-server-linux:latest
#   -d mcr.microsoft.com/mssql/server:2017-latest

docker exec -it sql1 "bash"

/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourStrong!Passw0rd>'

docker pull microsoft/mssql-tools:latest

exit 0
