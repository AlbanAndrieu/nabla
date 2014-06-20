
cd /workspace
sudo mkdir fitnesse
cd fitnesse/
sudo wget https://cleancoder.ci.cloudbees.com/job/fitnesse/lastStableBuild/artifact/dist/fitnesse-standalone.jar


#java -Xmx100M -jar fitnesse-standalone.jar -p 8085
#echo "http://localhost:8085"

#http://xebia.github.io/Xebium/#installation
cd /workspace
sudo git clone git://github.com/xebia/Xebium
cd /workspace/Xebium
mvn -Pfitnesse test

#http://home.nabla.mobi:8085/FitNesse
