#http://www.haka-security.org/hakabana.html

sudo dpkg -i elasticsearch-5.1.1.deb
sudo service elasticsearch start

sudo dpkg -i haka_0.3.0_amd64.deb
sudo dpkg -i hakabana_0.2.1_all.deb
sudo dpkg -i haka-geoip_0.3.0_amd64.deb
sudo apt-get install libnetfilter-queue1
sudo dpkg -i haka-nfqueue_0.3.0_amd64.deb
sudo apt-get install libjansson4
sudo dpkg -i haka-elasticsearch_0.3.0_amd64.deb

#start
sudo haka -c /usr/share/haka/hakabana/haka.conf

#wget https://raw.githubusercontent.com/haka-security/hakabana/develop/dashboard/Hakabana.json
ll /usr/share/haka/hakabana/dashboard/Hakabana.json
curl -X PUT http://localhost:9200/kibana-int/dashboard/hakabana -d @Hakabana.json
curl -X PUT http://localhost:9200/.kibana/dashboard/hakabana -T /usr/share/haka/hakabana/dashboard/Hakabana.json
ll http://localhost:9200/kibana-int/dashboard/hakabana
#curl -s -X GET http://localhost:9200/kibana-int/dashboard/mydashboard/_source > mydashboard.json
curl -X PUT http://localhost:9200/kibana-int/dashboard/mydashboard -d @mydashboard.json
curl -X PUT http://localhost:9200/kibana-int/dashboard/mydashboard -T mydashboard.json
ll http://localhost:9200/kibana-int/dashboard/mydashboard

http://localhost:5601/app/kibana

#http://air.ghost.io/kibana-4-export-and-import-visualizations-and-dashboards/
#sudo npm install elasticdump -g
#elasticdump \
#--input=/usr/share/haka/hakabana/dashboard/Hakabana.json \
#--output=http://localhost:9200/.kibana \
#--type=data
