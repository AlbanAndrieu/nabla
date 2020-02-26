#!/bin/bash
set -xv

pkg install screen
npm install private-bower

#as non jail
#start bower

echo 'bower_enable="YES"' >> /etc/rc.conf

cd /usr/local/etc/rc.d/
edit bower

###############################
#!/bin/sh

# $FreeBSD: bower
#swills $
#
# PROVIDE: bower
# REQUIRE: LOGIN
# KEYWORD: shutdown

#
# Configuration settings for bower in /etc/rc.conf:
#
# bower_enable (bool):
#   Set to "NO" by default.
#   Set it to "YES" to enable bower
#
# bower_args (str):
#   Extra arguments passed to start command
#
# bower_home (str)
#   Set to "/usr/local/bower" by default.
#   Set the BOWER_HOME variable for jenkins process
#

PATH=/sbin:/bin:/usr/sbin:/usr/bin:/usr/games:/usr/local/sbin:/usr/local/bin:/root/bin:/usr/local/fusion-io

. /etc/rc.subr

name="bower"
rcvar=bower_enable

load_rc_config "${name}"

: ${bower_enable="NO"}
: ${bower_home="/usr/local/bower"}
: ${bower_args=""}
: ${bower_user="bower"}
: ${bower_group="bower"}
: ${bower_log_file="/var/log/bower.log"}

pidfile="/var/run/bower/bower.pid"
command="/usr/sbin/daemon"
procname="${java_cmd}"
command_args="-p ${pidfile} /usr/local/bin/private-bower ${bower_args} >> ${bower_log_file} 2>&1"
required_files="${java_cmd}"

start_precmd="bower_prestart"
start_cmd="bower_start"

bower_prestart() {
        if [ ! -f "${bower_log_file}" ]; then
                touch "${bower_log_file}"
                #chown "${bower_user}:${bower_group}" "${bower_log_file}"
                chmod 640 "${bower_log_file}"
        fi
        if [ ! -d "/var/run/bower" ]; then
                install -d -o "${bower_user}" -g "${bower_group}" -m 750 "/var/run/bower"
        fi
}

bower_start()
{
        check_startmsgs && echo "Starting ${name}."
        #su -l ${bower_user} -c "exec ${command} ${command_args} ${rc_arg}"
        exec ${command} ${command_args} ${rc_arg}
}

run_rc_command "$1"
#########

chmod +x bower
#sudo update-rc.d bower defaults

cd /usr/local/lib/node_modules/private-bower/

nano bower.conf.json
#"publicAccessURL": "albandrieu.com:6789",

git clone git://albandrieu.com:6789/nabla-styles
git ls-remote --tags --heads git://albandrieu.com:6789/nabla-styles

cd /usr/local/lib/node_modules/private-bower/bin/
private-bower --config bower.conf.json

cd /usr/local/lib/node_modules/
ln -s /media/bower/ private-bower
ls -lrta /usr/local/lib/node_modules/private-bower/gitRepoCache

#cd /usr/local/lib/node_modules/private-bower/gitRepoCache
#cd jquery/
##https://github.com/jquery/jquery/tree/2.1.4
#git fetch && git fetch --tags
#git checkout tags/2.1.4
#
#cd bootstrap-sass-official/
#git fetch && git fetch --tags
#git checkout v3.3.7
#
#cd angular/
#git fetch && git fetch --tags
#git checkout tags/v1.4.8

cd /media/bower/gitRepoCache
chown -R bower:bower *

lsof -i :5678
service bower onestart

http://192.168.1.61:5678/

# TODO add proxy redirect for 6789 and 5678


exit 0
