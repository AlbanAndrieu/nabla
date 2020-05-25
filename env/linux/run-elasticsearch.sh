#!/bin/bash
set -xv

#test
curl -XGET 'localhost:9200/_cat/nodes?v&pretty'

#See http://172.21.0.4:9200/

http://localhost:9200/_plugin/gui/index.html

#http://localhost:5601/app/kibana#/management/elasticsearch/remote_clusters/list?_g=()
#0.0.0.0:9300

# See UI http://localhost:5001/#!/clusters/docker-cluster

exit 0
