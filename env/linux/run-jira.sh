#https://pypi.python.org/pypi/jira/
sudo pip install jira

#https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project
sudo sh -c 'echo "deb https://sdkrepo.atlassian.com/debian/ stable contrib" >>/etc/apt/sources.list'
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys B07804338C015B73
sudo apt-get install apt-transport-https
sudo apt-get update
sudo apt-get install atlassian-plugin-sdk

atlas-version

curl -k -u USERNAME -H "Content-type: application/json" -H "Accept: application/json" -X GET https://jira.nabla.mobi/jira/rest/api/2/serverInfo
