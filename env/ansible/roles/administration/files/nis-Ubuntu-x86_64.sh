#!/bin/sh
# {{ ansible_managed }}
#
# /etc/init.d/nis   Start NIS (formerly YP) daemons.
#
### BEGIN INIT INFO
# Provides:  ypbind ypserv ypxfrd yppasswdd
# Required-Start:   $network $portmap
# Required-Stop:    $portmap
# Default-Start:    2 3 4 5
# Default-Stop:  1
# Short-Description:    Start NIS client and server daemons.
# Description:   Start NIS client and server daemons. NIS is mostly
#    used to let several machines in a network share the
#    same account information (eg the password file).
### END INIT INFO
# Customize the variables in /etc/default/nis rather than here
NISSERVER=false
NISMASTER=
YPPWDDIR=/etc
YPCHANGEOK=chsh
YPSERVARGS=""
YPBINDARGS=""
YPPASSWDDARGS=""
YPXFRDARGS=""
YPPWDDIRARGS=""
[ -f /etc/default/nis ] && . /etc/default/nis
. /lib/lsb/init-functions
NET="/usr/sbin"
test -f ${NET}/ypbind -a -f /etc/defaultdomain || exit 0
#
#   If ypbind broadcasts for the default domain, we may not be bound to
#   any server yet (note that you can set broadcast in yp.conf for the
#   default domain without ypbind being run with -broadcast)
#
bind_wait()
{
 [ "`ypwhich 2>/dev/null`" = "" ] && sleep 1
 if [ "`ypwhich 2>/dev/null`" = "" ]
 then
  bound=""
  log_action_begin_msg "binding to YP server"
  for i in 1 2 3 4 5 6 7 8 9 10
  do
   sleep 1
   log_action_cont_msg "."
   if [ "`ypwhich 2>/dev/null`" != "" ]
   then
    echo -n " done] "
    bound="yes"
    break
   fi
  done
  # This should potentially be an error
  if [ "$bound" ] ; then
   log_action_end_msg 0
  else
   log_action_end_msg 1 "backgrounded"
  fi
 fi
}
#
#   Do we want ypbind to be started? On a laptop without ethernet
#   maybe not just yet - /etc/network/if-up.d will take care of it.
#
want_ypbind()
{
 # NIS servers always get ypbind since yppush wants it.
 case "$NISSERVER" in
  master|slave|[Yy]*)
   return 0
   ;;
 esac
 # Do we want to run as a NIS client anyway?
 case "$NISCLIENT" in
  false|[nN]*)
   return 1
   ;;
 esac
 # Executable present ?
 if ! [ -x ${NET}/ypbind ]
 then
  return 1
 fi
 # Started manually?
 if [ "$manual" != "" ]
 then
  return 0
 fi
 #
 #  For now, we do not use the /etc/network/if-{up,down}.d
 #  stuff yet. Not sure if it is useful for NIS or how
 #  it should work, exactly.
 #
 return 0
 #
 #  If the network is not up yet, do not start ypbind.
 #  We assume that /etc/network/ifup.d will start ypbind.
 #  It doesn't matter if it already did.
 #
 network=`route -n | sed -ne '/^224/d' -e '/^127/d' -e '/^[0-9]/p'`
 if [ "$network" = "" ]
 then
  return 1
 fi
 return 0
}
do_start ()
{
 oname=`domainname`
 nname=`cat /etc/defaultdomain`
 if [ "$oname" != "$nname" ]; then
  log_action_msg "Setting NIS domainname to: $nname"
  domainname "$nname"
 fi
 log_daemon_msg "Starting NIS services"
 if [ "$NISSERVER" != "false" ]
 then
  log_progress_msg "ypserv"
  start-stop-daemon --start --quiet \
   --pidfile /var/run/ypserv.pid --exec ${NET}/ypserv \
   -- ${YPSERVARGS}
 fi
 if [ "$NISSERVER" = master ]
 then
  E=""
  if [ "$YPCHANGEOK" != "" ]
  then
   OIFS="$IFS"; IFS="$IFS,"
   for i in $YPCHANGEOK
   do
    case "$i" in
     chsh|chfn)
      E="$E -e $i"
      ;;
    esac
   done
   IFS="$OIFS"
  fi
  log_progress_msg "yppasswdd"
  if [ "$YPPWDDIR" != "" ]; then
   YPPWDDIRARGS="-D ${YPPWDDIR}"
  fi
  start-stop-daemon --start --quiet \
   --exec ${NET}/rpc.yppasswdd -- $YPPWDDIRARGS $E $YPPASSWDDARGS
  log_progress_msg "ypxfrd"
  start-stop-daemon --start --quiet \
   --exec ${NET}/rpc.ypxfrd -- $YPXFRDARGS
 fi
 if egrep -q '^(ypserver|domain)' /etc/yp.conf
 then
  broadcast=""
 else
  broadcast="-broadcast"
 fi
 if want_ypbind
 then
  log_progress_msg "ypbind"
  start-stop-daemon -b --start --quiet \
   --exec ${NET}/ypbind -- $broadcast ${YPBINDARGS}
  bind_wait
 fi
 if [ "$NISSERVER" = "slave" -a "$NISMASTER" != "" ]
 then
  log_progress_msg "ypinit"
  /usr/lib/yp/ypinit -s $NISMASTER
 fi
 log_end_msg 0
}
do_stop () {
 log_daemon_msg "Stopping NIS services"
 log_progress_msg "ypbind"
 start-stop-daemon --stop --quiet --oknodo \
  --pidfile /var/run/ypbind.pid
 log_progress_msg "ypserv"
 start-stop-daemon --stop --quiet --oknodo \
  --pidfile /var/run/ypserv.pid
 log_progress_msg "ypppasswdd"
 start-stop-daemon --stop --quiet --oknodo \
  --pidfile /var/run/yppasswdd.pid
 log_progress_msg "ypxfrd"
 start-stop-daemon --stop --quiet --oknodo \
  --name rpc.ypxfrd
 log_end_msg 0
}
# Set 'manual' to indicate if we were started by hand.
case "$0" in
 */S[0-9][0-9]*|*/K[0-9][0-9]*)
  manual=
  ;;
 *)
  manual=1
  ;;
esac
case "$1" in
  start)
 do_start
 ;;
  stop)
 do_stop
 ;;
  reload|force-reload)
 start-stop-daemon --stop --quiet --oknodo --signal 1 \
  --pidfile /var/run/ypserv.pid --exec ${NET}/ypserv
 ;;
  restart)
 do_stop
 sleep 2
 do_start
 ;;
  *)
 echo "Usage: /etc/init.d/nis {start|stop|reload|force-reload|restart}"
 exit 1
esac
exit 0
