#http://doc.ubuntu-fr.org/postfix
sudo apt-get install postfix procmail sasl2-bin

sudo adduser postfix sasl  

subject=/C=FR/ST=FR/L=PARIS/O=NABLA/CN=NABLA.MOBI/emailAddress=alban.andrieu@nabla.mobi

#http://rtcamp.com/tutorials/linux/ubuntu-postfix-gmail-smtp/

sudo service postfix restart 
echo "Test mail from postfix" | mail -s "Test Postfix" you@example.com

#check error
/var/log/mail.err, /var/log/maillog or 

less  /var/log/mail.log

sudo netstat -pel | grep smtp
