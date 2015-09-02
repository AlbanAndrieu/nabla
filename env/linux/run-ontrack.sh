#https://github.com/nemerosa/ontrack
wget https://github.com/nemerosa/ontrack/releases/download/2.13.13/ontrack.jar

java -version

export JAVA_HOME=/usr/lib/jvm/jdk1.8.0/
/usr/lib/jvm/jdk1.8.0/bin/java -jar /devel/albandri/home/ontrack.jar --spring.profiles.active=prod --spring.datasource.url=jdbc:h2:./database/data
