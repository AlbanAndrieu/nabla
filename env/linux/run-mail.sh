sudo gedit /etc/ssmtp/ssmtp.conf

--------------------------

#
# Config file for sSMTP sendmail
#
# The person who gets all mail for userids < 1000
# Make this empty to disable rewriting.
#root=postmaster
root=noreply@nabla.mobi

# The place where the mail goes. The actual machine name is required no 
# MX records are consulted. Commonly mailhosts are named mail.domain.com
#mailhub=mail
mailhub=smtp.gmail.com:587

# Where will the mail seem to come from?
#rewriteDomain=

# The full hostname
#hostname=albandri
hostname=home.nabla.mobi

# Are users allowed to set their own From: address?
# YES - Allow the user to specify their own From: address
# NO - Use the system generated From: address
#FromLineOverride=YES

UseSTARTTLS=yes
UseTLS=yes
AuthUser=alban.andrieu@nabla.mobi
AuthPass=XXXXX
FromLineOverride=YES

--------------------------

cd /etc/postfix
sudo openssl genrsa -out postfixclient.key 1024
sudo openssl req -new -key postfixclient.key -out postfixclient.csr
sudo openssl ca -out ./postfixclient.pem -infiles postfixclient.csr
You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) [AU]:FR
State or Province Name (full name) [Some-State]:Paris
Locality Name (eg, city) []:Paris
Organization Name (eg, company) [Internet Widgits Pty Ltd]:Nabla
Organizational Unit Name (eg, section) []:Main
Common Name (e.g. server FQDN or YOUR name) []:nabla.mobi
Email Address []:alban.andrieu@nabla.mobi

Please enter the following 'extra' attributes
to be sent with your certificate request
A challenge password []:microsoft
An optional company name []:Nabla

sudo openssl ca -out ./postfixclient.pem -infiles postfixclient.csr

