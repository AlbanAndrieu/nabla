cls

call mvn clean jalopy:format install deploy site site:deploy -Pmaven-2-site,sample

pause