Note: using Easy-RSA configuration from: ./vars

init-pki complete; you may now create a CA or requests.

Your newly created PKI dir is: /usr/local/etc/openvpn/easy-rsa/pki

Password1

Password1

OpenVPN FreeNAS CA

^D

Note: using Easy-RSA configuration from: ./vars

Using SSL: openssl OpenSSL 1.0.2s-freebsd 28 May 2019

Enter New CA Key Passphrase:

Re-Enter New CA Key Passphrase:

Generating RSA private key, 2048 bit long modulus

.........................+++++

...............................................................+++++

e is 65537 (0x10001)

You are about to be asked to enter information that will be incorporated

into your certificate request.

What you are about to enter is what is called a Distinguished Name or a DN.

There are quite a few fields but you can leave some blank

For some fields there will be a default value,

If you enter '.', the field will be left blank.

-----

Common Name (eg: your user, host, or server name) [Easy-RSA CA]:

CA creation complete and you may now import and sign cert requests.

Your new CA certificate file for publishing is at:

/usr/local/etc/openvpn/easy-rsa/pki/ca.crt

Password1

^D

Note: using Easy-RSA configuration from: ./vars

Using SSL: openssl OpenSSL 1.0.2s-freebsd 28 May 2019

Generating a RSA private key

................+++++

....+++++

writing new private key to '/usr/local/etc/openvpn/easy-rsa/pki/private/openvpn-server.key.bydgb6NKYJ'

-----

Using configuration from /usr/local/etc/openvpn/easy-rsa/pki/safessl-easyrsa.cnf

Enter pass phrase for /usr/local/etc/openvpn/easy-rsa/pki/private/ca.key:

Check that the request matches the signature

Signature ok

The Subject's Distinguished Name is as follows

commonName :ASN.1 12:'openvpn-server'

Certificate is to be certified until Feb 11 20:32:32 2030 GMT (3650 days)

Write out database with 1 new entries

Data Base Updated

Note: using Easy-RSA configuration from: ./vars

Using SSL: openssl OpenSSL 1.0.2s-freebsd 28 May 2019

Generating DH parameters, 2048 bit long safe prime, generator 2

This is going to take a long time

Using SSL: openssl OpenSSL 1.0.2s-freebsd 28 May 2019

............................................................................................................................................................................................................................................+........................................................................................................+............................................................................................................................................................................+..........................................................................................................................................................................+..........+................................................................................................................................................................................................................+............................+..........................................+........................+.....................+..............................................................................................................................................................................................................+..................................+.......+......................+.......................................................................+.....................................................................................................................................+............................................+..........................................................................................................................................................................................................................................................................................+................................................+................................................................................+............................................................+.........................+.............................................+.......................................................................................................+.......................................................+...........................................................................................................+.....................................................................+.............+.............................................................................................................+........................................................................................................................................................................................................................+...........+........................+......................................+..............+.................................+..+......................................................................................+...........................................+.....................................................................................+.......................................................................................................................+...+..............................................+.......................................................................................................................................................................................................................................................................+.....................................................................+.....................................................................................+....+............................+..........................+..........+......+.......................................................................................................................+........................................................+.........................................................................................+.......................................................................................+.............................................................................................................+.........................................+......................................................................................................+......................+.........................................................................+................+...............+..................................................+................................................................................................................+......................+........................................................................................................+....+.................................................................................................+.........................................................................................................................+........+...........................................+............................................................................................+.........................................................+...+.........................................................................................................................................+...................................+....+........................................................................................+...........................................................................+..........................................+.+..................................................................................................................................+............+............................................................................................+..........................................................................+................................+....................................+...............................................................................................+......+..........................+...................................................................................................................................................................................................................................................................................................................................................................................................................+............................................+...............................................................+..........................+.........+................+......................................................................................................+................................................................................................................................................................................................................................................+...........................+....................................................................................................................................................................................................................................................+.....................................................................................................................................................................................................+............................................................+..................................................................................................+................................................................................................+......................................................................................................................+......................................................................................................+......................................................+.......................................................................+................................................................................................................................................................................................+...................................................................+.......................................................................................................................................................................................................................+......................................+................................................................+...........................................................+.........................................................+....+..........................................+..................................................................+............................................+.................+......................................................+..............................................................................+........................................................................................................................................+.............................................................................................................................................+.........................+.......................................................+.................................+.............................+.........................................................+...........................................................................................................+............................................+......+.......+...........................................................................................................+................................................................................................................................................................................+..............................+.........................................................+..............................................................+...................................+................+....+...........................................................................................................+.......................................+............................+.........................................+...........................................................................+......................................................+...........................................................................................................................................................................................................................................................................................+.................+.................+..............................................................................................................................................................................................+.....................................................+.+....................................................................................................+........+....................................................................................++*++*++*++*

DH parameters of size 2048 created at /usr/local/etc/openvpn/easy-rsa/pki/dh.pem

+*

openvpn_enable: -> YES

+*

openvpn_if: -> tun

+*

openvpn_configfile: -> /usr/local/etc/openvpn/openvpn.conf

+*

openvpn_dir: -> /usr/local/etc/openvpn/

+*

cloned_interfaces: -> tun

+*

gateway_enable: NO -> YES

+*

net.inet.ip.forwarding: 0 -> 1

+*

firewall_enable: NO -> YES

+*

firewall_script: /etc/rc.firewall -> /usr/local/etc/ipfw.rules

+*

Starting openvpn.

+*

Firewall rules loaded.

+*

+*

--------------------------

Sockstat reports OpenVPN listening on udp port 1194

--------------------------

+*

+*

Password2

Password2

Password1

^D

Note: using Easy-RSA configuration from: ./vars

+*

Using SSL: openssl OpenSSL 1.0.2s-freebsd 28 May 2019

+*

Generating a RSA private key

+*

+*

+*

+*

+*



+*

+*

+*

.+++++

+*

writing new private key to '/usr/local/etc/openvpn/easy-rsa/pki/private/a_client.key.EZifgSqeRj'

Enter PEM pass phrase:

Verifying - Enter PEM pass phrase:

+*

-----

+*

Using configuration from /usr/local/etc/openvpn/easy-rsa/pki/safessl-easyrsa.cnf

+*

+*

Enter pass phrase for /usr/local/etc/openvpn/easy-rsa/pki/private/ca.key:

Check that the request matches the signature

Signature ok

The Subject's Distinguished Name is as follows

commonName :ASN.1 12:'a_client'

Certificate is to be certified until Feb 11 20:35:03 2030 GMT (3650 days)

+*

Write out database with 1 new entries

+*

Data Base Updated

+*

A client certificate and configuration set have been created at /usr/local/etc/openvpn/clients/a_client

+*

--------------------------

Sockstat reports OpenVPN listening on udp port 1194

--------------------------

+*

The following (default) settings have been used:

server_local_port=1194

server_port_type=udp

private_network==192.168.1.0 255.255.255.0

nat_network_cidr=10.8.0.0/24

nat_network=10.8.0.0 255.255.255.0

server_fqdn=nas.mydomain.com

server_public_port=443

OpenVPN server should now be running on server_port_type udp server_local_port 1194

It will provide access for remote clients to your local network (private_network): 192.168.1.0 255.255.255.0

An intermediate network is used by the client behind a NAT translation (nat_network_cidr/nat_network): 10.8.0.0/24 / 10.8.0.0 255.255.255.0

This should NOT overlap with your private network.

Client configurations which will be created will have them connect to (server_fqdn): nas.mydomain.com

+*

Clients will connect on server_port_type udp, server_public_port: 443

You need to configure port-forwarding at the firewall in front of the OpenVPN jail to forward udp/443 to this Jail at udp/1194

Client generation/configuration can be done using iocage:

E.g. iocage set -P addclient=yourclientname,somesecurecertpassphrase

This will create a configuration folder at /usr/local/etc/openvpn/clients

By current default it will connect to server_fqdn nas.mydomain.com, server_port_type udp/server_public_port 443

To override this at generation:

E.g. iocage set -P addclient=yourclientname,somesecurecertpassphrase,your.server.fqdn.com,444

For changing and applying server attributes, use iocage as well. Please consult the README for this.

Admin Portal:

No adminportal available
