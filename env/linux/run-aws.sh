#https://help.ubuntu.com/community/EC2StartersGuide
sudo apt-get install ec2-api-tools
#copy key pair and ceritificat to
scp * albandri@albandri:.ec2
cd .ec2
chmod go-rwx ~/.ec2/*.pem 

gedit .bashrc
#add
export EC2_KEYPAIR=albandri # name only, not the file name
export EC2_URL=https://ec2.us-west-2a.amazonaws.com
export EC2_PRIVATE_KEY=$HOME/.ec2/pk-FMQ27HNLF2PVMPVL7MPWHEY5GWDKDOT2.pem
export EC2_CERT=$HOME/.ec2/cert-FMQ27HNLF2PVMPVL7MPWHEY5GWDKDOT2.pem

source .bashrc
#test
ec2-describe-images -o self -o amazon

#NOK ssh Public DNS: ec2-54-213-181-235.us-west-2.compute.amazonaws.com
Public DNS: ec2-54-213-168-125.us-west-2.compute.amazonaws.com

54.213.168.125

cd ~/.ec2
chmod 600 albandri.pem
ssh -i /workspace/users/albandri10/.ec2/albandri.pem ubuntu@ec2-54-200-87-169.us-west-2.compute.amazonaws.com

ec2-describe-images -o self -o amazon
ec2-describe-instances
ec2-run-instances ami-xxxxx -k ${EC2_KEYPAIR} -t <instance type>

Webmin install complete. You can now login to https://ip-172-31-29-239:10000/
sudo apt-get install ntp autofs perl libnet-ssleay-perl openssl libauthen-pam-perl libpam-runtime libio-pty-perl apt-show-versions python subversion cvs tomcat7 git maven wget curl smartmontools mon cmake scons maven ssmtp mailutils

wget http://home.nabla.mobi:8080/jnlpJars/jenkins-cli.jar
java -jar jenkins-cli.jar -s http://home.nabla.mobi:8080/ help