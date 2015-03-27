#!/usr/bin/env python2.7

""" This is the new server-connector. It enables binaries launched outside
of NABLA_ENV to be ran against a zone, enabling transparent use of configuration and
connection to thirdparties needed by the binary. Not like the previous implementation,
it now use standard built-in feature of unix systems such as chroot.
"""

#/usr/local/server-connector

from __future__ import print_function
import os
import sys
import subprocess
import platform
import argparse
import getpass
import logging
import re
import socket
import shutil
import stat
import json
import httplib
import urlparse

if sys.hexversion < 0x02070000:
    error("Python 2.7 or newer is required to run this program.")

__version__ = '2015.02.16'
__author__  = 'nabla team'
__date__    = 'Mon, 16 Feb 2015 10:11:56 +0100'
__contact__ = 'alban.andrieu@free.fr'

NABLA_ENV_DIR = '.nabla'
NABLA_ENV_IP_FILENAME = 'ip.nabla'
NABLA_ENV_BIND_DIRS_FILENAME = 'bind_dirs.nabla'
NABLA_ENV_PASSWD_FILE = 'passwd.nabla'
NABLA_ENV_XAUTH_FILE = '.Xauthority'
NABLA_ENV_BASHRC_FILE = '.bashrc'

KEY_UID = 'uid'
KEY_GID = 'gid'
KEY_HOME = 'home'

KEY_ZONE = 'zone'
KEY_USER = 'user'

KEY_USER_DIR_USER = 4
KEY_USER_DIR_ZONE = 5
KEY_USER_DIR_SHARE = 6

KEY_GLOBAL_ZONE = 0
KEY_GLOBAL_USER = 'globally'
KEY_GLOBAL_SHARE = 1

KEY_MOUNT_POINT = 'mountpoint'
KEY_SHARE = 'share'
KEY_MOUNT_TYPE = 'type'

NETWORK_SHARE_TYPE = 'nfs'

ZONE_USERS = {
    'kgr':         { KEY_UID: 100 },
    'kplus':       { KEY_UID: 101 },
    'vbox':        { KEY_UID: 107,  KEY_HOME: '/home/vbox' },
}

bashAddition = '[ -r /.nabla/%s ] && . /.nabla/%s' % (NABLA_ENV_BASHRC_FILE, NABLA_ENV_BASHRC_FILE)

ssh_cmd_string = 'ssh -o IdentityFile=~/.ssh/nabla.rsa -o StrictHostKeyChecking=no -o CheckHostIP=no -o UserKnownHostsFile=/dev/null -o LogLevel=quiet -o BatchMode=yes'

nabla_local_dirs = ['nabla', 'thomsonreuters']
nabla_zone_dir = 'nabla'

#------------------------------------------------------------------------------
def mount_cmd():
    ptf = platform.system()
    if ptf == "SunOS":
        return '/usr/sbin/mount'
    elif ptf == "Linux":
        return '/bin/mount'
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

#------------------------------------------------------------------------------
def umount_cmd():
    ptf = platform.system()
    if ptf == "SunOS":
        return '/usr/sbin/umount'
    elif ptf == "Linux":
        return '/bin/umount'
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

#------------------------------------------------------------------------------
def env_cmd():
    ptf = platform.system()
    if ptf == "SunOS":
        return '/bin/env'
    elif ptf == "Linux":
        return '/usr/bin/env'
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

#------------------------------------------------------------------------------
def su_cmd():
    ptf = platform.system()
    if ptf == "SunOS":
        return '/bin/su'
    elif ptf == "Linux":
        return '/bin/su'
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

#------------------------------------------------------------------------------
def chroot_cmd():
    ptf = platform.system()
    if ptf == "SunOS":
        return '/usr/sbin/chroot'
    elif ptf == "Linux":
        return '/usr/sbin/chroot'
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

#------------------------------------------------------------------------------
def remove_file(filename, errormsg=None):
    if os.path.isfile(filename):
        logging.debug("Removing %s" % (filename))
        os.unlink(filename)
    elif errormsg:
        logging.debug(errormsg)

#------------------------------------------------------------------------------
def mount_bind(src, dst, rbind):
    logging.debug("Mounting " + src + " on " + dst)
    if platform.system() == "SunOS":
        cmd = [mount_cmd(), "-F", "lofs", src, dst]
    elif platform.system() == "Linux":
        if rbind and isRHEL():
            options = "--rbind"
        else:
            options = "--bind"
        cmd = [mount_cmd(), options, src, dst]
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")
    logging.debug('Executing ' + ' '.join(cmd))
    subprocess.call(cmd)

#------------------------------------------------------------------------------
def mount(srcDir, srcServer, dst, options):
    if resource_mounted(dst):
        logging.debug("%s already mounted." % (dst))
        return
    if not os.path.isdir(dst):
        os.mkdir(dst)
    if platform.system() == "SunOS":
        cmd = [mount_cmd()] + options + [srcServer + ':' + srcDir, dst]
    elif platform.system() == "Linux":
        cmd = [mount_cmd(), srcServer + ':' + srcDir, dst] + options
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")
    logging.debug('Executing ' + ' '.join(cmd))
    subprocess.call(cmd)

def mount_pattern(share):
    pattern = ""
    if platform.system() == "Linux":
         pattern = "\s%s"
    elif platform.system() == "SunOS":
         pattern = "^%s"
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

    return pattern % (share)

#------------------------------------------------------------------------------
def mount_fields():
    fields = {KEY_MOUNT_POINT: 2, KEY_SHARE: 0}
    if platform.system() == "Linux":
         fields[KEY_MOUNT_TYPE] = 4
    elif platform.system() == "SunOS":
         fields[KEY_MOUNT_TYPE] = 3
    else:
        raise SystemExit("Platform " + platform.system() + " is not supported")

    return fields

#------------------------------------------------------------------------------
# get list of mounted server shares (mounted and locally bind)
def get_mounts():
    mount_pattern_str = ""
    for local_dir in nabla_local_dirs + ['server-connector']:
        if len(mount_pattern_str) > 0:
            mount_pattern_str += "|%s" % (local_dir)
        else:
            mount_pattern_str = local_dir

    mounts_output = subprocess.check_output([mount_cmd()] + (['-p'] if platform.system() == 'SunOS' else []))
    mount_pattern = re.compile(mount_pattern_str)

    mounts = []
    for mount in mounts_output.split("\n"):
        if mount_pattern.search(mount):
            mounts.append(mount)

    logging.debug(mounts)

    return mounts

def extract_connected_zone(mount_point, share):
    pattern = re.compile('server-connector')
    if (pattern.search(mount_point)):
        dirs = mount_point.split("/")

        share = dirs[KEY_USER_DIR_SHARE] if len(dirs)>KEY_USER_DIR_SHARE else "."

        return {KEY_ZONE: dirs[KEY_USER_DIR_ZONE],
                KEY_USER: dirs[KEY_USER_DIR_USER],
                KEY_MOUNT_POINT: mount_point,
                KEY_SHARE: "/".join(share)}
    else:
        dirs = share.split(":")
        return {KEY_ZONE: dirs[KEY_GLOBAL_ZONE],
                KEY_USER: KEY_GLOBAL_USER,
                KEY_MOUNT_POINT: mount_point,
                KEY_SHARE: dirs[KEY_GLOBAL_SHARE]}

linuxPattern = re.compile("Linux")
rhelPattern = re.compile("Red Hat Enterprise Linux")
ubuntuPattern = re.compile("Ubuntu")

def isLinux():
    return linuxPattern.search(platform.system())
def isUbuntu():
    return isLinux() and ubuntuPattern.search(platform.linux_distribution()[0])
def isRHEL():
    return isLinux() and rhelPattern.search(platform.linux_distribution()[0])

#------------------------------------------------------------------------------
# Show user list of zones connected to machine
def show_all_connected():
    logging.debug('Check all present mount-points on : %s.' % (socket.gethostname()))
    print ("Detecting existing connections. Please wait ...")
    fields = mount_fields()

    servers = {}
    local_bindings = {}
    for mount in get_mounts():
        mounts = mount.split(" ")
        mount_point = mounts[fields[KEY_MOUNT_POINT]]
        share = mounts[fields[KEY_SHARE]]
        type = mounts[fields[KEY_MOUNT_TYPE]]
        zone = extract_connected_zone(mount_point, share)
        zonename = zone[KEY_ZONE]


        if type == NETWORK_SHARE_TYPE:
            if zonename not in servers:
                servers[zonename] = { KEY_ZONE: zonename, KEY_USER: [zone[KEY_USER]] }
            else:
                if zone[KEY_USER] not in servers[zonename][KEY_USER]:
                    servers[zonename][KEY_USER].append(zone[KEY_USER])
        else:
            if zonename not in local_bindings:
                local_bindings[zonename] = { KEY_ZONE: zonename, KEY_SHARE: [{ KEY_SHARE: share, KEY_MOUNT_POINT: mount_point} ]}
            else:
                local_bindings[zonename][KEY_SHARE].append({ KEY_SHARE: share, KEY_MOUNT_POINT: mount_point})

    if len(servers) > 0:
        print ("Connected zones:")
        for zonename in servers:
            zone = servers[zonename]
            print ("Zone: %s connected (%s)" % (zone[KEY_ZONE], ",".join(zone[KEY_USER])))
    if len(local_bindings) > 0 and 0:
        print ("Locally bind:")
        for zonename in local_bindings:
            zone = local_bindings[zonename]
            logging.debug(zone[KEY_SHARE])
            for share in zone[KEY_SHARE]:
                #share = zone[sharename]
                print ("'%s' locally bind for zone: %s on (%s)" % (share[KEY_SHARE], zonename, share[KEY_MOUNT_POINT]))

    return

    mount_output = ""
    servers = []
    local_binds = []

    server_pattern_str = ""
    for local_dir in nabla_local_dirs:
        if len(server_pattern_str) > 0:
            server_pattern_str += "|"
        server_pattern_str += mount_pattern("/%s" % (local_dir))

    server_pattern = re.compile(server_pattern_str)

    local_bind_str = mount_pattern('/usr/local/server-connector/')
    local_bind_pattern = re.compile(local_bind_str)
    logging.debug("Server search for: '%s'" %  (server_pattern_str))
    logging.debug("Local search for: '%s'" % (local_bind_str))

    if 0:
        if server_pattern.search(mountpoint):
            servers.append({'zone:'})
        elif local_bind_pattern.search(mountpoint):
            logging.debug("Is local binding.")
        else:
            logging.debug("Skipping...")



#------------------------------------------------------------------------------
def resource_mounted(share):
    logging.debug("Check if: '%s' is mounted." % share)
    mount_output = subprocess.check_output([mount_cmd()])
    pattern = re.compile(mount_pattern(share))
    for mount in mount_output.split("\n"):
        if pattern.search(mount):
            return 1

#------------------------------------------------------------------------------
def umount(mounted_dir, force=False):
    if force:
        logging.debug("Force umounting: %s" % (mounted_dir))
    else:
         logging.debug("Check if is dir: %s" % (mounted_dir))
    try:
        if resource_mounted(mounted_dir):
            cmd = [umount_cmd()]
            if force:
                cmd += ['-f']
            # do 'lazy' umount on RHEL, cause of '--rbind'
            if isRHEL():
                cmd += ['-l']
            cmd += [mounted_dir]
            logging.debug('Executing ' + ' '.join(cmd))
            subprocess.call(cmd)
        try:
            os.rmdir(mounted_dir)
        except:
            pass
    except KeyboardInterrupt:
        print ("") #to go to next line after user's break
        sys.exit(0) #user break

#------------------------------------------------------------------------------
def get_userConf(user):
    if user not in ZONE_USERS:
        raise SystemExit("Unexpected user: "+user)
    conf = ZONE_USERS[user]
    if KEY_HOME not in conf:
        conf[KEY_HOME] = "/nabla/home/%s" % user
    if KEY_GID not in conf:
        conf[KEY_GID] = 1
    return conf

#------------------------------------------------------------------------------
def get_user_home(user):
    if user in ZONE_USERS:
        return get_userConf(user)[KEY_HOME]
    else:
        return subprocess.check_output(['/usr/bin/getent', 'passwd', user]).split(':')[5]

#------------------------------------------------------------------------------
def get_user():
    try:
        return os.environ['SUDO_USER']
    except:
        return getpass.getuser()

#------------------------------------------------------------------------------
def create_nabla_ssh_key_if_needed():
    sshdir = '%s/.ssh' % get_user_home(get_user())

    if not os.path.exists(sshdir):
        os.mkdir(sshdir,0700)

    key = sshdir+'/nabla.rsa'

    if not os.path.isfile(key):
        with open(key, 'w') as f:
            print ('''
-----BEGIN RSA PRIVATE KEY-----
MIICXAIBAAKBgQC/y3/RxP31+jolt6FAeTMigwEZIeiZb4wF0pRzN7rMBnHQvyp4
UMBuEbv62JEgRkmoqbVbQU05K2r4Pih2XCQU5ga+NOkHN7CjdGmqNAL2dGXPOgv1
4+e6orOOO3k4WOuthpskl6OUEJ8TnJ6jwXlY0Ttlz2ThkBz8SSLWj1L5qQIDAQAB
AoGAElTpCqvBellIZYJ/ryHmeU38NOLA0KmQwJ24Aqs493dGOaWL8aQGQH8BcKBy
fps5Px25b9d2AhjcSI3oYCe+avZ92WpjKtkVbR8p7qIlGru6lveofG/ndiGJ+N97
2XZ1eccbziktwPgdZ9QX8kAyag6UaZCVTzaUw7eniquLTYECQQDsyKrOEHjaUxMT
khP+qUuy3hB1Wo3xVSugufUlywtBf74qcoX5Ix8GedlS0iGoJuyNib63JsoUzIM5
F2b5KT91AkEAz1wopMdXQ4aBemH5wsQNdcmtrNkgVH9ZWPBYSiA9/5kLSkZ7wk5Y
rqqf6GCu4ofzQNBhQC0ZSM1F4NS9mdee5QJAGR/pz9e7mx75hTgY2wrHt4EMqgcj
zJnG+VUCCDKVTSvq18IzKQ5q+lrvjnQxkhAfRZ16GSEKjE5vFh2/lWylCQJAFO4R
cChqx3cRJKA1DJKrZSM5M4Qq/jxocVC5KKo+d8kj2Zhpr4Am9WJlh5gSruzYAcfG
uSqULcQCdKIkjR21fQJBAOD3Weg2fQk/eQb4PuZIT07EUTnRkLUKvtAyaDjLKVOx
HaDuhzTx4r5t9fwmtCwfwMhriFYDmDBMArzb39WBVHM=
-----END RSA PRIVATE KEY-----
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQC/y3/RxP31+jolt6FAeTMigwEZIeiZb4wF0pRzN7rMBnHQvyp4UMBuEbv62JEgRkmoqbVbQU05K2r4Pih2XCQU5ga+NOkHN7CjdGmqNAL2dGXPOgv14+e6orOOO3k4WOuthpskl6OUEJ8TnJ6jwXlY0Ttlz2ThkBz8SSLWj1L5qQ== everybody@nabla.nabla.mobi
'''.strip(), file=f)

    if stat.S_IMODE(os.stat(key).st_mode) != 0400:
        os.chmod(key, 0400)

#------------------------------------------------------------------------------
def ping(server_name_or_ip):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(5.0)
        s.connect((server_name_or_ip, 22))
        s.close()
    except socket.timeout:
        raise SystemExit('The server ' + server_name_or_ip + ' seems not to be up and running')
    except socket.gaierror:
        raise SystemExit('The server ' + server_name_or_ip + ' does not exist')

#------------------------------------------------------------------------------
def is_zone_up_and_running(server_name_or_ip):
    try:
        ping(server_name_or_ip)
    except:
        return 0
    return 1

#==============================================================================
class KZoneConnector(object):

    #--------------------------------------------------------------------------
    def __init__(self):
        self.supported_platforms = ["SunOS", "Linux"]
        if platform.system() not in self.supported_platforms:
            raise SystemExit("Platform " + platform.system() + " is not supported")
        self.root_dir = None # To be set by children classes
        self.server_name = None # To be set by init_zone_name(). Don't use it. use self.get_zone_name()
        self.server_ip = None # To be set by init_zone_name()

    #--------------------------------------------------------------------------
    def mount_server(self):
        logging.debug("Mounting zone network filesystem")

        specific_options = ['soft']

        #if not isRHEL():
        #    specific_options += ['noquota']

        options = ['-o', ','.join(specific_options)]

        for directory in nabla_local_dirs:
            mount(nabla_zone_dir, self.get_zone_name(), self.chroot_filename(directory), options)

    def nabla_rootdir(self):
        return '' if self.root_dir == '/' else self.root_dir
    #--------------------------------------------------------------------------
    def nabla_filename(self, filename):
        return "%s/%s/%s" % (self.nabla_rootdir(), NABLA_ENV_DIR, filename)

    #--------------------------------------------------------------------------
    def chroot_filename(self, filename):
        return '%s/%s' % (self.nabla_rootdir(), filename)

    #--------------------------------------------------------------------------
    def connected(self, bind_dirs = []):
        for local_dir in nabla_local_dirs + bind_dirs:
            abs_path = self.chroot_filename(local_dir)
            if resource_mounted(abs_path):
                return 1

        return 0

    #--------------------------------------------------------------------------
    def init_zone_name(self, server_name_or_ip):
        try:
            self.server_ip = socket.gethostbyname(server_name_or_ip)
        except:
            raise SystemExit("Cannot resolve " + server_name_or_ip)
        self.server_name = server_name_or_ip
        if self.server_ip == server_name_or_ip:
            try:
                # Try to get the real name
                self.server_name = subprocess.check_output(['/usr/bin/getent', 'hosts', server_name_or_ip]).strip().split()[1]
            except:
                pass

    #--------------------------------------------------------------------------
    # The global connector may need to know the zone name even when it is not provided by cmd line option
    #--------------------------------------------------------------------------
    def get_zone_name(self, short=False):
        raise NotImplementedError("This is a virtual class")

    #--------------------------------------------------------------------------
    def set_nfs_anon_mapping(self, user):
        if user:
            userConf = get_userConf(user)
            nfs_uid = userConf[KEY_UID]
            nfs_gid = userConf[KEY_GID]
            # su - get_user(): we expect the calling user to be able to ssh to a zone without password. Root probably can't.
            cmd = "su - %s -c \"echo '/nabla (rw,all_squash,insecure,anonuid=%s,anongid=%s)' | %s root@%s 'cat>/etc/exports; pkill -HUP unfsd'\" > /dev/null" % (get_user(), nfs_uid, nfs_gid, ssh_cmd_string, self.get_zone_name())
            logging.debug('Executing ' + cmd)
            if subprocess.call(cmd, shell=True):
                raise SystemExit('ERROR: cannot modify the export file on the zone')

    #--------------------------------------------------------------------------
    def clear_nfs_anon_mapping(self):
        server_name = self.get_zone_name()
        if server_name and is_zone_up_and_running(server_name):
            cmd = "su - %s -c \"echo '/nabla (rw,root_squash,insecure)' | %s root@%s 'cat>/etc/exports; pkill -HUP unfsd'\" > /dev/null" % (get_user(), ssh_cmd_string, server_name)
            logging.debug('Executing ' + cmd)
            if subprocess.call(cmd, shell=True):
                raise SystemExit('ERROR: cannot revert the export file on the zone')

    #--------------------------------------------------------------------------
    def init_nss(self):
        # Check /etc/nsswitch.conf has nabla on required maps
        requiredMaps = ['hosts', 'passwd', 'services']
        ko = []
        with open('/etc/nsswitch.conf') as f:
            for line in f:
                match = re.match(r'^(\w+)\s*:([^#]+)', line)
                if match and match.group(1) in requiredMaps:
                    if not 'kenvng' in match.group(2):
                        ko.append(match.group(1))
        if ko:
            raise SystemExit("NSS nabla won't work. Please modify /etc/nsswitch.conf to use the nabla plugin for the following maps: "+", ".join(ko))

        if not os.path.isdir("%s/%s" % (self.root_dir,  NABLA_ENV_DIR)):
            logging.debug("Make `" + NABLA_ENV_DIR + "` directory")
            os.mkdir("%s/%s" % (self.root_dir, NABLA_ENV_DIR))

        ip_filename = self.nabla_filename(NABLA_ENV_IP_FILENAME)
        with open(ip_filename, 'w') as f:
            print(self.server_ip, file=f)

        passwd_filename = self.nabla_filename(NABLA_ENV_PASSWD_FILE)
        with open(passwd_filename, 'w') as f:
            for user in ZONE_USERS:
                # write proper passwdline to file
                userConf = get_userConf(user)
                print("%s::%d:%d::%s:/bin/bash"%(user, userConf[KEY_UID], userConf[KEY_GID], userConf[KEY_HOME]), file=f)


#==============================================================================
class KZoneConnectorChroot(KZoneConnector):

    #--------------------------------------------------------------------------
    def __init__(self, server_name_or_ip, bind_dirs):
        super(KZoneConnectorChroot, self).__init__()
        self.init_zone_name(server_name_or_ip)
        self.root_dir = '/usr/local/server-connector/%s/%s' % (get_user(), self.get_zone_name(True))

        self.bind_dirs = [
            "bin",
            "dev",
            "devices",
            "etc",
            "lib",
            "lib32",
            "lib64",
            "proc",
            "root",
            "sbin",
            "sys",
            "tmp",
            "usr",
            "var",
            "run",
            "opt",
        ]


        self.rbind_dirs = [
            (get_user_home(get_user()).split("/"))[1],
        ]

        #taken from https://docs.oracle.com/cd/E19199-01/816-6775-10/a_chroot.html (BMT-2092)
        self.solaris_workaround_dev = [
            "dev/null",
            "dev/tcp",
            "dev/ticots",
            "dev/ticlts",
            "dev/ticotsord",
            "dev/tty",
            "dev/udp",
            "dev/zero",
            "dev/conslog"
        ]


        #this should be unmouted
        self.solaris_workaround_devices = [
            "devices/pseudo/mm@0:null",
            "devices/pseudo/tcp@0:tcp",
            "devices/pseudo/tl@0:ticots",
            "devices/pseudo/tl@0:ticlts",
            "devices/pseudo/tl@0:ticotsord",
            "devices/pseudo/sy@0:tty",
            "devices/pseudo/udp@0:udp",
            "devices/pseudo/mm@0:zero",
            "devices/pseudo/log@0:conslog"
        ]

        self.additional_rbind_dirs = [ ]

        self.add_bind_dirs(bind_dirs)


    def add_bind_dirs(self, bind_dirs):
        if bind_dirs:
            pattern = re.compile('^/.*')
            for bind_dir in set(bind_dirs.split(',')):
                if pattern.match(bind_dir):
                    raise SystemExit("'/' is forbidden in bind_dirs value (use '%s' instead of '%s'" % (bind_dir[1:], bind_dir) )
                if bind_dir not in self.bind_dirs and bind_dir not in self.rbind_dirs:
                    self.additional_rbind_dirs.append(bind_dir)

    #--------------------------------------------------------------------------
    def print_status(self):
        if self.connected(self.bind_dirs):
            print("Connected to %s (on %s)" % (self.get_zone_name(True), self.root_dir))
        else:
            print("Not connected to %s (on %s)" % (self.get_zone_name(True), self.root_dir))

    #--------------------------------------------------------------------------
    def bind(self, user):
        ping(self.get_zone_name())
        if self.connected(self.bind_dirs):
            # In case new dirs are passed
            self.init_chroot(self.additional_rbind_dirs, True, True)
            self.set_nfs_anon_mapping(user)
        else:
            if not os.path.isdir(self.root_dir):
                logging.debug("Make directory " + self.root_dir)
                os.makedirs(self.root_dir)
            self.init_nss()
            self.init_chroot(self.bind_dirs)
            self.init_chroot(self.rbind_dirs, True)
            self.init_chroot(self.additional_rbind_dirs, True)
            if platform.system() == "Linux":
                self.mount_special('devpts', 'dev/pts') # for terminal programs
                shmMountPoint = 'run/shm' if isUbuntu() else 'dev/shm'
                self.mount_special('tmpfs', shmMountPoint) # for python shared mem
            if platform.system() == "SunOS":
                for dev in self.solaris_workaround_dev:
                    mount_bind('/' + dev, self.root_dir+'/'+dev,True)

            self.set_nfs_anon_mapping(user)
            self.mount_server()
            self.init_misc()
        self.print_status()

    #--------------------------------------------------------------------------
    def get_zone_name(self, short=False):
        server_name = self.server_name
        if short and server_name != self.server_ip:
            server_name = server_name.split('.')[0]
        return server_name

    def read_bind_dirs(self,bind_dirs_filename):
       bind_dirs = []
       if os.path.isfile(bind_dirs_filename):
            with open(bind_dirs_filename) as f:
                bind_dirs += [ line.rstrip('\n') for line in f.readlines() ]

       return list(set(bind_dirs))

    #--------------------------------------------------------------------------
    def unbind(self, force=False):
        print ("Unbinding zone: '%s'. It might take a while if zone is down or was destroyed without disconnection." % self.get_zone_name(True))
        bind_dirs_filename = self.nabla_filename(NABLA_ENV_BIND_DIRS_FILENAME)

        self.rbind_dirs = self.read_bind_dirs(bind_dirs_filename)

        os.remove(bind_dirs_filename)

        dirs = self.bind_dirs + self.rbind_dirs
        if platform.system() == "Linux":
            dirs.insert(0, 'dev/pts') # before 'dev'
            shmMountPoint = 'run/shm' if isUbuntu() else 'dev/shm'
            dirs.insert(0, shmMountPoint) # before 'run' and 'dev'
        if platform.system() == "SunOS":
            for dev in self.solaris_workaround_dev + self.solaris_workaround_devices:
                umount(self.root_dir+'/'+dev)

            if os.path.isdir(self.root_dir+'/devices/pseudo'):
                for device in self.solaris_workaround_devices:
                    umount(self.root_dir+'/'+device)

        for directory in dirs:
            chrooted_dir = self.chroot_filename(directory)
            umount(chrooted_dir)
        for directory in nabla_local_dirs:
            chrooted_dir = self.chroot_filename(directory)
            umount(chrooted_dir, force)

        if self.connected():
            # something went wrong, suggest action with --force
            print ("Unbind didn't finished successfully. Consider using --force.")
            return
        else:
            self.print_status()

        self.clear_nfs_anon_mapping()

        remove_file(self.nabla_filename(NABLA_ENV_IP_FILENAME), "Previous connection not detected")
        remove_file(self.nabla_filename(NABLA_ENV_PASSWD_FILE), "Previous users mapping not detected")
        remove_file(self.nabla_filename(NABLA_ENV_BASHRC_FILE), "Previous bashrc not detected")
        remove_file(self.chroot_filename(NABLA_ENV_XAUTH_FILE))
        try:
            os.rmdir(self.nabla_filename(''))
            os.rmdir(self.root_dir)
        except:
            pass

    def rebind(self, zone, user, dirs):

        bind_dirs_filename = self.nabla_filename(NABLA_ENV_BIND_DIRS_FILENAME)

        bind_dirs=",".join(self.read_bind_dirs(bind_dirs_filename))

        if dirs:
            bind_dirs+=','+dirs

        #system server-connector.py --zone --unbind --force

        unbind_cmd = [ sys.argv[0], '--zone', zone, '--unbind', '--force' ]

        logging.debug(" ".join(unbind_cmd))

        subprocess.call(unbind_cmd)


        #system server-connector.py --zone --bind_dirs bind_dirs --bind [--user user]

        bind_cmd = [ sys.argv[0], '--zone', zone, '--bind' ]

        if bind_dirs != "":
            bind_cmd+= [ '--bind_dirs', bind_dirs ]

        if user:
            bind_cmd+= [ '--user', user ]

        logging.debug(" ".join(bind_cmd))

        subprocess.call(bind_cmd)

    #--------------------------------------------------------------------------
    def init_chroot(self, bind_dirs, rbind=False, checkRbindDblMount=False):
        if rbind and checkRbindDblMount:
            mounts = subprocess.check_output([mount_cmd()])

        for bind_dir in bind_dirs:
            target_dir = self.root_dir + "/" + bind_dir
            slash_bind_dir   = "/" + bind_dir

            if not os.path.isdir(slash_bind_dir):
                logging.debug("Will not mount non existing directory `/" + bind_dir + "`")
                continue

            if not os.path.isdir(target_dir):
                logging.debug("Make directory " + target_dir)
                os.makedirs(target_dir)

            # Prevent multiple mounts of user specified directories
            if rbind and checkRbindDblMount and target_dir+' ' in mounts: break

            mount_bind(slash_bind_dir, os.path.abspath(target_dir), rbind)
        if rbind:
            bind_dirs_filename = self.nabla_filename(NABLA_ENV_BIND_DIRS_FILENAME)
            nabla_dir = self.chroot_filename(NABLA_ENV_DIR)
            bind_dirs = set(bind_dirs)
            if os.path.exists(bind_dirs_filename):
                with open(bind_dirs_filename, 'r') as f:
                    for bind_dir in f:
                        bind_dirs.add(bind_dir.strip())
            if not os.path.exists(nabla_dir):
                logging.debug("Creating %s." % nabla_dir)
                os.makedirs(nabla_dir)

            with open(bind_dirs_filename, 'w') as f:
                for bind_dir in bind_dirs:
                    print(bind_dir, file=f)

    #--------------------------------------------------------------------------
    def init_misc(self):
        # Specific chroot .bashrc
        with open(self.nabla_filename(NABLA_ENV_BASHRC_FILE), 'w') as f:
            print('PS1="\[\e[1;32m\]\u@\[\e[1;36m\]\h->%s:\[\e[1;33m\]\w)\[\e[0m\] "' % self.get_zone_name(True), file=f)
            print('cd $KZC_CALLER_PWD # defined only if no --user param used to launch the connector', file=f)


    #--------------------------------------------------------------------------
    def mount_special(self, fstype, dst):
        dst = self.root_dir + "/" + dst
        if platform.system() == "Linux":
            cmd = [mount_cmd(), "-t", fstype, fstype, dst]
        else:
            raise SystemExit("Platform " + platform.system() + " is not supported")
        logging.debug('Executing ' + ' '.join(cmd))
        subprocess.call(cmd)

    #--------------------------------------------------------------------------
    def exec_prog(self, prog, env_path):

        # We currently see no point in executing a process other than with the calling user, as we need to keep
        # R/W access to the calling user HOME.
        user = get_user()

        if not self.connected(self.bind_dirs):
            raise SystemExit("Cannot exececute without being connected to a zone (first, use --bind)")

        home = get_user_home(user)
        if not os.path.isdir(self.root_dir+'/'+home):
            logging.debug('Seems to not be a directory: "%s"' % (self.root_dir+'/'+home))
            raise SystemExit("This zone seems not to have a HOME directory for user '%s'"%user)

        env = []

        # Readable .Xauthority in chroot context.
        # Must be done every time (because auth changes on each ssh)
        src_auth = os.path.expanduser('~/' + NABLA_ENV_XAUTH_FILE)
        if os.path.exists(src_auth):
            calling_user = get_user()
            dest_xauth = self.chroot_filename(NABLA_ENV_XAUTH_FILE)
            subprocess.call("%s %s -c '/bin/chmod o+r %s'"%(su_cmd(), calling_user, src_auth), shell=True) # required on legacy servers due to root noperm
            shutil.copyfile(src_auth, dest_xauth)
            subprocess.call("%s %s -c '/bin/chmod o-r %s'"%(su_cmd(), calling_user, src_auth), shell=True)
            os.chmod(dest_xauth, stat.S_IRUSR | stat.S_IWUSR | stat.S_IRGRP | stat.S_IWGRP | stat.S_IROTH | stat.S_IWOTH)
            env.append('XAUTHORITY=/' + NABLA_ENV_XAUTH_FILE)

        # env passing doc:
        # legacy servers use csh, new world uses bash. Let's try to unify the env using bash everywhere.
        # PATH is overwritten by bash on Ubuntu (at least), so it should be passed through BASH_ENV
        # BASH_ENV only taken into account in non-interactive bash --> bash -c <bash or prog>
        # bash -c <bash or prog> also allows to get a bash on legacy servers where csh is the default
        # XAUTHORITY is overwritten by RedHat su, so it must be passed after su (su env XAUTHORITY=... cmd)

        # Copy the env file ni the chroot context, so it can be seen in chroot context
        if env_path:
            if os.path.isfile(env_path):
                env_path = os.path.abspath(env_path)
                env.append('BASH_ENV=' + env_path)
                try:
                    shutil.copyfile(env_path, self.root_dir+env_path)
                except shutil.Error as e:
                    if 'are the same file' in e.message: # because dest = mount --bind of src
                        pass
                    else:
                        raise
            else:
                raise SystemExit(env_path + " does not exists")

        # For Solaris su which does not set it
        env.append('HOME=' + home)

        # Memorize the current pwd to restore it in the connector unless which change the user
        if user == get_user():
            env.append('KZC_CALLER_PWD=' + os.getcwd())

        user_cmd = '"%s %s /bin/bash -c \'exec %s\'"' % (env_cmd(), ' '.join(env), prog)
        # su_cmd_flag: With -c on RHEL, su traps CTRL-C instead of passing it to children
        # cf. http://sethmiller.org/it/su-forking-and-the-incorrect-trapping-of-sigint-ctrl-c/
        su_cmd_flag = '--session-command' if isRHEL() else '-c'
        subprocess_arg = [chroot_cmd(), self.root_dir, su_cmd(), user, su_cmd_flag, user_cmd]

        logging.debug('Executing ' + ' '.join(subprocess_arg))
        try:
            return subprocess.call(' '.join(subprocess_arg), shell=True)
        except KeyboardInterrupt: # user break
            return -1

    #--------------------------------------------------------------------------
    # Update the user .bahsrc so that, in connector context only,
    # a specific additional .bashrc is sourced.
    # This is needed to set a specific PS1
    # This sucks, but nobody could find a better way
    #--------------------------------------------------------------------------
    def updateUserBashrc(self):
        chroot_bashrc = get_user_home(get_user()) + '/.bashrc'
        bashrc = self.root_dir + chroot_bashrc
        if os.path.exists(bashrc):
            with open(bashrc) as f: content = f.read()
            if bashAddition in content:
                return
        # We need this server user write permission, so let's do the work in connector context
        # Ugly too, but what else...
        self.exec_prog("%s updateBashrc %s" % (os.path.realpath(__file__), chroot_bashrc), None)


#==============================================================================
class KZoneConnectorGlobal(KZoneConnector):

    #--------------------------------------------------------------------------
    def __init__(self):
        super(KZoneConnectorGlobal, self).__init__()
        self.root_dir = '/'
        # Simple test to prevent using this connector on legacy servers (because multiple people may want to use these servers)
        #if os.path.isdir('/rms') and os.path.isdir('/database') and os.path.isdir('/kobra'):
        #    raise SystemExit("You may not use --global on a legacy server")

    #--------------------------------------------------------------------------
    def bind(self, server_name_or_ip, user):
        self.init_zone_name(server_name_or_ip)
        ping(server_name_or_ip)
        self.init_nss()
        self.set_nfs_anon_mapping(user)
        self.mount_server()
        self.print_status()

    #--------------------------------------------------------------------------
    def get_zone_name(self, short=False):
        if not self.server_name and self.connected() and os.path.isfile(self.nabla_filename(NABLA_ENV_IP_FILENAME)):
            with open(self.nabla_filename(NABLA_ENV_IP_FILENAME)) as f:
                server_ip = f.read().strip()
            self.init_zone_name(server_ip)
        server_name = self.server_name
        if short and server_name and server_name != self.server_ip:
            server_name = server_name.split('.')[0]
        return server_name

    #--------------------------------------------------------------------------
    def unbind(self, force=False):
        print ("Unbinding zone: '%s'. It might take a while if zone is down or was destroyed without disconnection." % self.get_zone_name(True))
        for directory in nabla_local_dirs:
            umount(self.chroot_filename(directory), force)

        if self.connected():
            # something went wrong, suggest action with --force
            print ("Unbind didn't finished successfully. Consider using --force.")
            return
        else:
            self.print_status()

        self.clear_nfs_anon_mapping()
        remove_file(self.nabla_filename(NABLA_ENV_IP_FILENAME), "Previous connection not detected")
        remove_file(self.nabla_filename(NABLA_ENV_PASSWD_FILE), "Previous users mapping not detected")
        try:
            os.rmdir(self.nabla_filename(''))
        except:
            pass

    def rebind(self, zone, user):

        binded_zone = zone
        if not zone:
            if os.path.isfile(self.nabla_filename(NABLA_ENV_IP_FILENAME)):
                with open(self.nabla_filename(NABLA_ENV_IP_FILENAME)) as f:
                    binded_zone = f.read().strip()
            else:
                sys.exit("ERROR: Neither can detect zone nor --zone parameter is specified")

        #system server-connector.py --global --unbind --force

        unbind_cmd = [ sys.argv[0], '--global', '--unbind' , '--force']
        logging.debug(" ".join(unbind_cmd))

        subprocess.call(unbind_cmd)

        #system server-connector.py --global --bind --zone binded_zone [--user user]

        bind_cmd = [ sys.argv[0], '--global', '--bind', '--zone', binded_zone ]

        if user:
            bind_cmd+=[ '--user', user ]

        logging.debug(" ".join(bind_cmd))

        subprocess.call(bind_cmd)

    #--------------------------------------------------------------------------
    def print_status(self):
        if self.connected():
            print("Connected (globally) to %s" % self.get_zone_name())
        else:
            print("Not connected (globally)")

#==============================================================================
def main ():

    if len(sys.argv)>1 and sys.argv[1] == 'updateBashrc':
        with open(sys.argv[2], 'a') as f:
            print(bashAddition, file=f)
        sys.exit(0)


    # auto elevate privileges
    if os.getuid() != 0:
        create_nabla_ssh_key_if_needed() # Before privilege elevation (on legacy servers, root can't write or even check in user HOME)
        subprocess_arg = ['sudo'] + sys.argv
        try:
            sys.exit(subprocess.call(subprocess_arg))
        except KeyboardInterrupt: # user break
            sys.exit(0)


    parser = argparse.ArgumentParser(prog='server-connector.py'
                                        , description="This is the server-connector\nCheck documentation page for details: 'http://home.nabla.mobi/server-connector.py'"
                                        , formatter_class = argparse.RawTextHelpFormatter
                                    )

    # building --zone argument require condition
    # for all not global actions
    zone_required = ('--global' not in sys.argv)
    # when --status specified => not required
    zone_required = zone_required and ('--status' not in sys.argv)
    # for global unbind or status -> not needed
    zone_required = zone_required or ('--global' in sys.argv and '--detach' not in sys.argv and '--unbind' not in sys.argv and '--status' not in sys.argv and '--rebind' not in sys.argv)

    parser.add_argument('--zone', metavar='zonename_or_ip',
                                  required=zone_required,
                                  dest='zone', action='store',
                                  help='zone FQDN or IP')
    parser.add_argument('--version', action='version', version='%(prog)s ' + __version__)

    parser.add_argument('--verbose', action='store_true', dest='verbose_mode',
                                     help='verbose mode')
    parser.add_argument('--env', action='store', dest='env_file',
                                 default=None, metavar="path/to/file",
                                 help='path to env file for --exec')
    action_global = parser.add_mutually_exclusive_group(required=False)

    action_global.add_argument('--bind_dirs', dest='bind_dirs', action='store', metavar='bind_dir_1,bind_dir_2',
                                   help='Binds additional root level directories (coma separated)')
    parser.add_argument('--user',  dest='user', choices=sorted(ZONE_USERS.keys()),
                                   help='Specify the user as which NFS access will be performed on the zone (default: %(default)s)')
    parser.add_argument('--force',  dest='force_unbind', action='store_true', default=None,
                                    help='Force unbinding zone, when it is stopped or destroyed, but still connected.')
    action_global.add_argument('--global', dest='global_mode', action='store_true',
                                   help='run the connector in global mode, i.e. like the connector v1. Forbidden on legacy servers')

    # actions on connector
    action = parser.add_mutually_exclusive_group(required=False)
    action.add_argument('--bind', '--attach', dest='bind', action='store_true',
                                 help='attach to the zone (optional. --exec automatically binds)')
    action.add_argument('--unbind', '--detach', dest='unbind', action='store_true',
                                   help='detach from the zone')
    action.add_argument('--rebind', dest='rebind', action='store_true',
                                   help='rebinds the zone')
    action.add_argument('--status', dest='get_status', action='store_true',
                                   help='get the current status')
    action.add_argument('--exec', dest='exec_prog', action='store', default=None, metavar='command',
                                   help='execute and connect a program or a command (optional. By default, run a bash)')
    args = parser.parse_args()

    logging.basicConfig(
        level = logging.DEBUG if args.verbose_mode else logging.ERROR
    )

    if args.verbose_mode:
        print ('OS information:\t%s' % (platform.system()))
        if isLinux():
            distr = platform.linux_distribution()
            print('Distribution:\t%s "%s" (%s)' % (distr[0], distr[2], distr[1]))

    if args.get_status and not args.zone and not args.global_mode:
        show_all_connected()
        exit(0)

    if args.global_mode:
        conn = KZoneConnectorGlobal()
        if args.get_status:
            conn.print_status()
            exit(0)
        elif args.unbind:
            conn.unbind(args.force_unbind)
        elif args.rebind:
            conn.rebind(args.zone, args.user)
        else:
            if conn.connected():
                raise SystemExit("Connection detected. Please --unbind first")
            conn.bind(args.zone, args.user)

    else:
        conn = KZoneConnectorChroot(args.zone, args.bind_dirs)#, args.unbind)
        if args.get_status:
            conn.print_status()
            exit(0)
        elif args.bind:
            if conn.connected():
                raise SystemExit("Connection detected. Please --unbind first")
            conn.bind(args.user)
        elif args.unbind:
            conn.unbind(args.force_unbind)
        elif args.rebind:
            conn.rebind(args.zone, args.user, args.bind_dirs)
        else:
            if not args.exec_prog:
                args.exec_prog = '/bin/bash'
            conn.bind(args.user) # Auto bind
            conn.updateUserBashrc() # will use exec_prog itself
            sys.exit(conn.exec_prog(args.exec_prog, args.env_file))

#------------------------------------------------------------------------------
def send_request(zod_req, url):
    scheme, zodserver, urlpath, query, fragment = urlparse.urlsplit(url)
    conn = httplib.HTTPSConnection(zodserver, timeout=10)
    headers = {'Content-type': 'application/json'}
    params = json.dumps(zod_req)
    conn.request('POST', urlpath, params, headers)

    response = conn.getresponse()
    if response.status != httplib.OK:
        raise Exception("HTTP request failed with status=%d, reason: %s" % (response.status, response.reason))
    json_response_data = response.read()
    conn.close()
    return json.loads(json_response_data)

#------------------------------------------------------------------------------
def createRequest(build_req_fct):

    request = {'domain': ''}

    build_req_fct(request)

    return request

#------------------------------------------------------------------------------
def executeRequest(build_req_fct, read_resp_fct, url):
    request = createRequest(build_req_fct)

    rurl='https://zod/zod'

    if url:
        rurl = rurl + '/' +url

    resp = send_request(request, rurl)

    if resp['err_code'] != 0:
        error('ERROR: ' + resp['err_str'])

    if __name__ == "__main__":
        read_resp_fct(resp['data'])
    else:
        return resp['data']


############################# check if update is needed /cgi-bin/version.cgi

def build_check_update_req(request):
    p = request['params'] = { }

def read_check_update_resp(resp_data):
    if resp_data['server_connector_py'] != __version__:
        print ("WARNING: server-connector('"+__version__+"') needs to be updated to '" + resp_data['server_connector_py']+"'",file=sys.stderr)

check_update = (build_check_update_req, read_check_update_resp, '../cgi-bin/version.cgi')

#https://zod/cgi-bin/version.cgi
#{
#   "err_code" : 0,
#   "ws_version" : "1",
#   "query_id" : null,
#   "data" : {
#      "zodclient_py" : "2015.02.16",
#      "zod_www" : "2015.03.02",
#      "server_connector" : "2015.03.02",
#      "server_connector_py" : "2015.02.16"
#}

#------------------------------------------------------------------------------

if __name__ == '__main__':

    if os.getuid() == 0:
         try:
             executeRequest(*check_update)
         except:
             pass

    main()
