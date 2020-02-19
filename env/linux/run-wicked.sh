#!/bin/bash

# See https://blog.tetsumaki.net/articles/2017/04/bloquer-hadopi-et-tmg-sous-rtorrent-et-transmission.html

wickedList=('trident+AND+mediaguard' 'hadopi' 'trident+AND+media+AND+guard')
rtorrentFile='./out-rtorrent-wickedlist.txt'
transmissionFile='./out-transmission-wickedlist.txt'
iptablesFile='./out-iptables-rules.txt'
tmpWickedFile='/tmp/tmpWickedFile.txt'
tmpWorkFile='/tmp/tmpWorkFile.txt'

rm -f "${rtorrentFile}" "${transmissionFile}" "${iptablesFile}" 2> /dev/null

for m in "${wickedList[@]}"; do
    curl -s -o "${tmpWickedFile}" "https://apps.db.ripe.net/db-web-ui/api/rest/fulltextsearch/select?facet=true&format=xml&hl=true&q=(${m})&start=0&wt=json" -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:62.0) Gecko/20100101 Firefox/62.0' --compressed
    cat "${tmpWickedFile}" | sed s/\<\\/str\>/\\n/g | grep 'str name="inetnum"' | sed 's/.*>//' >> "${tmpWorkFile}"
    cat "${tmpWickedFile}" | sed s/\<\\/str\>/\\n/g | grep 'str name="inetnum"' | sed 's/.*>//' | awk -v list="${m}" '{ print list ":" $1 "-" $3 }' | sed s/+AND+/\ /g >> "${transmissionFile}"
    rm -f "${tmpWickedFile}"
done

while read -r line; do
    ipcalc ${line} | tail -n1 >> "${rtorrentFile}"
done < "${tmpWorkFile}"

rm -f "${tmpWorkFile}"

while read -r ip; do
    echo iptables -A INPUT -s "${ip}" -j DROP >> "${iptablesFile}"
    echo iptables -A OUTPUT -d "${ip}" -j DROP >> "${iptablesFile}"
done < "${rtorrentFile}"
