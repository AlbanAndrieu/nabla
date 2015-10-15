
#MD5 check
openssl md5 target/test-sources.jar
openssl md5 target/test-sources.jar target/test.jar > MD5SUMS_.md5
if [ -f MD5SUMS.md5 ] && [ -f MD5SUMS_.md5 ] && ! diff -q MD5SUMS.md5 MD5SUMS_.md5; then exit 1; fi
