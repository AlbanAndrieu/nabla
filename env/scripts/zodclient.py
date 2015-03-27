#!/usr/bin/env python2.7

# DIFFS with perl version, rev 316:
#  - option MUST be given with --option, instead of -option
#  - no more use of external banner executable
#  - search --parseable will also display the Disk data at the end of each line
#  - ask for login/passwd after other checks are done, to avoid typing them if other issues will prevent executing the command
#  - new --format formatting option

import sys

if sys.hexversion < 0x02070000:
    error("Python 2.7 or newer is required to run this program.")

import os
import argparse
import re
import getpass
import json
import httplib
import urlparse
import time
import types
import exceptions

VERSION = '2015.02.16'   # ZoD-client version
DATE = 'Mon, 16 Feb 2015 10:31:13 +0100' # Release date
http_timeout = 600 # Seconds

DEFAULT_DATE_FORMAT = '%a %b %d %H:%M %Y'

args = None

###############################################################################
#                           Z O D      R E Q U E S T S                        #
###############################################################################

############################# search

def build_search_req(request):
    request['action'] = 'search_kzones'
    request['params'] = {'name': args.zonename, 'owner': args.owner, 'usage': args.desc}

def read_search_resp(resp_data):
    zones = sorted(resp_data, key=lambda zone:time.strptime(zone['creat'], DEFAULT_DATE_FORMAT))
    if args.full or args.parseable:
        for zone in zones:
            if not args.parseable:
                banner(zone['name'])
            table = Table()
            table.setVerticalMode()
            table.add('Name',  zone['name'])
            table.add('Owner', zone['owner'])
            table.add('Usage', zone['usage'])
            table.separator()
            if 'owned' in zone: # those are only defined for search response, not for create resposne.
                table.add('Owned',      'yes' if zone['owned']        else 'no')
            table.add('Creation',    zone['creat'] if args.date_format is None else time.strftime(args.date_format, time.strptime(zone['creat'], DEFAULT_DATE_FORMAT)))
            table.add('IP',          zone['ip'])
            table.add('Booted',      'yes' if zone['booted']      else 'no')
            table.add('Validity',    zone['lifetime'])
            table.add('KHost',       zone['khost'])
            table.add('FQDN',        zone['fqdn'])
            table.separator()
            table.add('KGR',         'yes' if zone['kgr']         else 'no')
            table.add('K+',          'yes' if zone['kplus']       else 'no')
            table.add('K+TP',        'yes' if zone['kplustp']     else 'no')
            table.add('WA',          'yes' if zone['webaccess']   else 'no')
            table.add('DASEL',       'yes' if zone['dasel']       else 'no')
            table.add('GENESIS',     'yes' if zone['genesis']     else 'no')
            table.add('WORKFLOW',    'yes' if zone['workflow']    else 'no')
            table.add('SUMMIT',      'yes' if zone['summit']      else 'no')
            table.add('SOPHIS',      'yes' if zone['sophis']      else 'no')
            table.add('TO',          'yes' if zone['topoffice']   else 'no')
            table.add('ORCHESTRATE', 'yes' if zone['orchestrate'] else 'no')
            table.add('BANKFUSION',  'yes' if zone['bankfusion']  else 'no')
            table.add('GLOBALPOS',   'yes' if zone['globalpos']   else 'no')
            table.add('ETRADING',    'yes' if zone['etrading']    else 'no')
            table.add('GLOBALCOL',   'yes' if zone['globalcol']   else 'no')
            table.add('GLOBALPS',    'yes' if zone['globalps']    else 'no')
            table.add('GLOBALCS',    'yes' if zone['globalcs']    else 'no')
            if not args.parseable:
                table.add('CMF',          'yes' if zone['cmf']           else 'no')
                table.add('GENERICLIMITS','yes' if zone['genericlimits'] else 'no')
                table.add('OPICS',        'yes' if zone['opics']         else 'no')

            if 'owned' in zone: # those are only defined for search response, not for create resposne.
                table.separator()
                table.add('can_halt',    'yes' if zone['can_halt']    else 'no')
                table.add('can_boot',    'yes' if zone['can_boot']    else 'no')
                table.add('can_del',     'yes' if zone['can_del']     else 'no')
                table.add('can_snap',    'yes' if zone['can_snap']    else 'no')
                table.add('can_roll',    'yes' if zone['can_roll']    else 'no')
                table.add('can_export',  'yes' if zone['can_export']  else 'no')
            if args.parseable:
                # join disks and snapshot field with ','
                if len( zone['disks'])>0:
                    table.add('Disk', ','.join(zone['disks']))
                else:
                    table.add('Disk', '')
                if len( zone['snapshots'])>0:
                    table.add('Snapshot', ';;;'.join(zone['snapshots']))
                else:
                    table.add('Snapshot', '')
            else:
                if isinstance( zone['disks'], types.ListType):
                    table.separator()
                    if len( zone['disks'])>0:
                        for disk in zone['disks']:
                            table.add('Disk', disk)
                    else:
                        table.add('Disk', '')
                if isinstance( zone['snapshots'], types.ListType):
                    table.separator()
                    if len( zone['snapshots'])>0:
                        for snapshot in zone['snapshots']:
                            if snapshot.find('|||') > 0:
                                descritption = snapshot.split('|||')[1]
                                if descritption == "-":
                                    descritption = ""
                                else:
                                    descritption = " (" + descritption + ")"
                                snapshot = snapshot.split('|||')[0]+descritption
                            table.add('Snapshot', snapshot)
                    else:
                        table.add('Snapshot', '')
            table.separator()
            table.add('Creator',  zone['creator'])
            if args.parseable:
                if len( zone['origins'])>0:
                    origins=list()
                    for disk in zone['origins'].keys():
                        origins.append(disk + "|||" + zone['origins'][disk])
                    table.add('Origin', ';;;'.join(origins))
                else:
                    table.add('Origin', '')
            else:
                if isinstance( zone['origins'], types.DictionaryType):
                    table.separator()
                    if len( zone['origins'])>0:
                        for disk in zone['origins'].keys():
                            table.add('Origin', disk + " ( from " + zone['origins'][disk] + ")")
                    else:
                        table.add('Snapshot', '')
            if args.parseable:
                table.add('CMF',          'yes' if zone['cmf']           else 'no')
                table.add('GENERICLIMITS','yes' if zone['genericlimits'] else 'no')
                table.add('OPICS',        'yes' if zone['opics']         else 'no')

            printTable(table, format=args.format)
    else:
        table = Table('Name', 'Creator' ,'Owner', 'Usage', 'Creation Date')
        for zone in zones:
            table.add(zone['name'], zone['creator'], zone['owner'], zone['usage'], zone['creat'])
        printTable(table, format=args.format, maxLengths=[None, None, None, 50, None])
    if not args.parseable:
        print "Found %d zones in domain" % len(zones)


############################# getdoms

def build_getdoms_req(request):
    request['action'] = 'get_domains'

def read_getdoms_resp(resp_data):
    table = Table('Domain', 'Description')
    for dom, info in sorted(resp_data.iteritems()):
        table.add(dom, info['description'])
    printTable(table, format=args.format, maxLengths=[None, 80])

############################# cat

def build_cat_req(request):
    request['action'] = 'get_catalog'

def read_cat_resp(resp_data):
    # List of snapshots in domains with some metadata
    # 
    # The actual response for catalog listing is a list of lists, each list corresponding
    # to one khost. As we now do want to manage different content on KHosts within a given
    # domain, we have to consider all khost lists.
    allSnaps = {}
    for khost,khostSnaps in sorted(resp_data.iteritems()):
        for snap in khostSnaps:
                if not snap['name'] in allSnaps:
         	    # jezeli istnieje wpis allSnaps[snap['name'] to wyciagam kolumne khosts , dodaje aktualnego khosta do tej listy
		    # jezeli nie istnieje to tworze nowy wpis
                    allSnaps[snap['name']] = {'desc': snap['desc'], 'date': snap['date'], 'khosts': khost.split('.')[0]}
                else:
                    allSnaps[snap['name']]['khosts'] = allSnaps[snap['name']]['khosts'] + ', ' + khost.split('.')[0]
    table = Table('Name', 'Comment', 'Date', 'Khosts')
    for name, attr in sorted(allSnaps.iteritems()):
        table.add(name, attr['desc'], attr['date'], attr['khosts'])
    printTable(table, format=args.format, maxLengths=[70, 40, None, 70], doSep = True)
    if not args.parseable:
        print "Found %d items in catalog" % len(allSnaps)
    

############################# tmpl

def build_tmpl_req(request):
    request['action'] = 'get_templates'

def read_tmpl_resp(resp_data):
    table = Table('Template', 'Contact', 'Name', 'Description', 'Params')
    for key,tmpl in resp_data.iteritems():
        table.add(tmpl['template'], tmpl['contact'], tmpl['name'], tmpl['description'], json.dumps(tmpl['params']))

    if args.parseable:
        printTable(table, format=args.format)
    else:
        printTable(table, format=args.format, maxLengths=[None,None, None, 50, 50], doSep=True)

############################# get_user_priv

def build_get_user_priv_req(request):
    request['action'] = 'get_user_priv'

def read_get_user_priv_resp(resp_data):
    table = Table('Permission', 'Status')
    for param, value in resp_data[0].iteritems():
        table.add(param, str(value))
    printTable(table, format=args.format)

############################# zls

def build_zls_req(request):
    request['action'] = 'get_zoneslist'

def read_zls_resp(resp_data):
    table = Table('Name', 'Ip')
    for zone, data in sorted(resp_data.iteritems()):
        table.add(zone, data['ip'])
    printTable(table, format=args.format)

############################# test_template ( No read as it allways will be error)

def build_test_template_req(request):
    request['action'] = 'test_template'
    p = request['params'] = {}
    if not args.template:
        error("missing template parameter")

    p['template']=args.template

def read_test_template_resp(resp_data):
    display_ok()

############################# create (No read as the response comes from a search request)

def build_create_req(request):
    request['action'] = 'create_kzone'
    p = request['params'] = {}
    if args.zonename:
        if not re.match(r'^kzone\d\d\d$', args.zonename):
            error("Zone name is not valid")
        p['zonename'] = args.zonename
    #--- Apps
    if args.template:
        p['template']=args.template
    if args.kgr_syb and args.kgr_home:
        p['kgr_syb'] = args.kgr_syb
        p['kgr_home'] = args.kgr_home
    if args.kplus_syb and args.kplus_home:
        p['kplus_syb'] = args.kplus_syb
        p['kplus_home'] = args.kplus_home
    if args.summit_data and args.summit_home:
        p['summit_data'] = args.summit_data
        p['summit_home'] = args.summit_home
    if args.opics_data and args.opics_home:
        p['opics_data'] = args.opics_data
        p['opics_home'] = args.opics_home
    if args.sophis_data and args.sophis_home:
        p['sophis_data'] = args.sophis_data
        p['sophis_home'] = args.sophis_home
    if args.topoffice_data and args.topoffice_home:
        p['topoffice_data'] = args.topoffice_data
        p['topoffice_home'] = args.topoffice_home
    if args.orchestrate_data and args.orchestrate_home:
        p['orchestrate_data'] = args.orchestrate_data
        p['orchestrate_home'] = args.orchestrate_home
    if args.bankfusion_data and args.bankfusion_home:
        p['bankfusion_data'] = args.bankfusion_data
        p['bankfusion_home'] = args.bankfusion_home
    if args.globalcol_data and args.globalcol_home:
        p['globalcol_data'] = args.globalcol_data
        p['globalcol_home'] = args.globalcol_home
    if args.globalpos_data and args.globalpos_home:
        p['globalpos_data'] = args.globalpos_data
        p['globalpos_home'] = args.globalpos_home
    if args.globalps_data and args.globalps_home:
        p['globalps_data'] = args.globalps_data
        p['globalps_home'] = args.globalps_home
    if args.globalcs_data and args.globalcs_home:
        p['globalcs_data'] = args.globalcs_data
        p['globalcs_home'] = args.globalcs_home
    if args.etrading_data and args.etrading_home:
        p['etrading_data'] = args.etrading_data
        p['etrading_home'] = args.etrading_home
    if args.kplustp_home:
        p['kplustp_home'] = args.kplustp_home
    if args.dasel_home:
        p['dasel_home'] = args.dasel_home
    if args.genesis_home:
        p['genesis_home'] = args.genesis_home
    if args.cmf_home:
        p['cmf_home'] = args.cmf_home
    if args.genericlimits_home:
        p['genericlimits_home'] = args.genericlimits_home
    if args.workflow_home:
        p['workflow_home'] = args.workflow_home
    #--- 3rd parties
    if args.els:
        p['els'] = args.els
    if args.rvd:
        p['rvd'] = args.rvd
    if args.webaccess:
        p['webaccess'] = args.webaccess
    if args.tomcat:
        p['tomcat'] = args.tomcat
    if args.ems:
        p['ems'] = args.ems
    if args.java:
        p['java'] = args.java
    if args.nodejs:
        p['nodejs']=args.nodejs
    if args.rmds:
        p['rmds'] = args.rmds
    if args.weblo:
        p['weblo'] = args.weblo
    if args.python:
        p['python'] = args.python
    if args.qatools:
        p['qatools'] = args.qatools
    #--- Options
    if args.direct:
        p['direct'] = 1
    if args.implicit:
        p['implicit'] = 1
    if args.nostart:
        p['nostart'] = 1
    if args.noboot:
        p['noboot'] = 1
    if args.zrc:
        p['zrc'] = args.zrc
    #--- Meta
    p['usage'] = mandatoryArg('desc', notEmpty=True)
    p['lifetime'] = mandatoryArg('lifetime')
    if args.owner:
        p['owner'] = args.owner

############################# destroy

def build_destroy_req(request):
    request['action'] = 'destroy_kzone'
    p = request['params'] = {'zonename' :  mandatoryArg('zonename')}
    # owner not used ! the current login is used
    if args.owner:
        p['owner'] = args.owner
    confirm('Do you want to destroy %s?'%args.zonename, 'yes i do')

def read_destroy_resp(resp_data):
    display_ok()

############################# boot

def build_boot_req(request):
    request['action'] = 'boot_kzone'
    request['params'] = {'zonename' : mandatoryArg('zonename')}

def read_boot_resp(resp_data):
    display_ok()

############################# halt

def build_halt_req(request):
    request['action'] = 'halt_kzone'
    request['params'] = {'zonename' : mandatoryArg('zonename'), 'force': args.force}

def read_halt_resp(resp_data):
    display_ok()

############################# snapshot

def build_snapshot_req(request):
    request['action'] = 'snapshot_kzone'
    p = request['params'] = {'zonename' : mandatoryArg('zonename'), 'zfslist' : mandatoryArg('zfs')}
    if args.suffix:
        p['zfs_suffix'] = args.suffix
    if args.comment:
        p['comment'] = args.comment

def read_snapshot_resp(resp_data):
    table = Table('Snapshots')
    for snap in sorted(resp_data):
        table.add(snap)
    printTable(table, format=args.format)

############################# rollback

def build_rollback_req(request):
    request['action'] = 'rollback_kzone'
    request['params'] = {'zonename' : mandatoryArg('zonename'), 'zfslist' : mandatoryArg('zfs')}

def read_rollback_resp(resp_data):
    # do not change default ok message, but when --format is specified, print list of rollbacks
    userFormat = args.format if args.format is not None else ['Status']
    
    table = Table('Status','Snapshots')
     
    #for snapshot in sorted(resp_data):
    table.add('Done', ",".join(sorted(resp_data)))

    printTable(table, format=userFormat, parseable=(True if args.format is None else args.parseable))

############################# replicate_kzone

def build_replicate_kzone_req(request):
    request['action'] = 'replicate_kzone'
    p = request['params'] = {'zonename' : mandatoryArg('zonename'), 'zfslist' : mandatoryArg('zfs'), 'dst_dom': mandatoryArg('dstdom')}
    if args.dsthost:
        p['dst_khost'] = args.dsthost

def read_replicate_kzone_resp(resp_data):
    display_ok()

############################# replicate

def build_replicate_dataset_req(request):
    request['action'] = 'replicate_dataset'
    p = request ['params'] = { 'src_khost': mandatoryArg('srchost'), 'dst_domain': mandatoryArg('dstdom'), 'dst_khost': mandatoryArg('dsthost') , 'src_zfs': mandatoryArg('srczfs') }
    if args.dstzfs:
        p['dst_zfs'] = args.dstzfs;
    else:
        p['dst_zfs'] = args.srczfs;

    if args.no_dataset_sync_check:
        p['no_check_sync']=1;

def read_replicate_dataset_resp(request):
    display_ok()

############################# export

def build_export_req(request):
    request['action'] = 'export_kzone'
    request['params'] = {'zonename' : mandatoryArg('zonename')}

def read_export_resp(resp_data):
    display_ok()
    
#############################
############################# Request definitions
#############################

############################# 
def build_update_kzone_dataset_req(request):
    request['action']     = 'update_kzone_dataset'
    request['params']     = {'zonename'   : mandatoryArg('zonename')}
    p = request['params'] = {'zonename' : mandatoryArg('zonename'), 'zfs_add' : mandatoryArg('zfs_add'), 'zfs_del': mandatoryArg('zfs_del')}
    if args.direct:
        p['zfs_direct'] = 1

def read_update_kzone_dataset_resp(resp_data):
    display_ok()

############################# update_kzone_property

def build_update_kzone_property_owner_req(request):
    request['action'] = 'update_kzone_property'
    p = request['params'] = {'zonename': mandatoryArg('zonename'), 'property': 'owner', 'value': mandatoryArg('owner') }


def build_update_kzone_property_desc_req(request):
    request['action'] = 'update_kzone_property'
    p = request['params'] = {'zonename': mandatoryArg('zonename'), 'property': 'usage', 'value': mandatoryArg('desc') }

def read_update_kzone_property_resp(resp_data):
    display_ok()

############################# check if update is needed /cgi-bin/version.cgi

def build_check_update_req(request):
    p = request['params'] = { }

def read_check_update_resp(resp_data):
    if resp_data['zodclient_py'] != VERSION:
        print >> sys.stderr, "WARNING: zodclient('"+VERSION+"') needs to be updated to '" + resp_data['zodclient_py'] +"'"

request_fcts = {
    # get infos
    'cat'           : (build_cat_req,           read_cat_resp, None),
    'getdoms'       : (build_getdoms_req,       read_getdoms_resp, None),
    'get_user_priv' : (build_get_user_priv_req, read_get_user_priv_resp, None),
    'search'        : (build_search_req,        read_search_resp, None),
    'tmpl'          : (build_tmpl_req,          read_tmpl_resp, None),
    'zls'           : (build_zls_req,           read_zls_resp, None),
    # execute tasks
    'test_template' : (build_test_template_req, read_test_template_resp, None),
    'create'        : (build_create_req,        read_search_resp, None),
    'destroy'       : (build_destroy_req,       read_destroy_resp, None),
    'boot'          : (build_boot_req,          read_boot_resp, None),
    'halt'          : (build_halt_req,          read_halt_resp, None),
    'snapshot'      : (build_snapshot_req,      read_snapshot_resp, None),
    'rollback'      : (build_rollback_req,      read_rollback_resp, None),
    'replicate'     : (build_replicate_kzone_req,     read_replicate_kzone_resp, None),
    'replicate_dataset': (build_replicate_dataset_req, read_replicate_dataset_resp, None),
    'export'        : (build_export_req,        read_export_resp, None),
    'update_dataset': (build_update_kzone_dataset_req,        read_update_kzone_dataset_resp, None),
    'update_owner'  : (build_update_kzone_property_owner_req, read_update_kzone_property_resp, None),
    'update_desc'   : (build_update_kzone_property_desc_req, read_update_kzone_property_resp, None),
}

check_update = (build_check_update_req, read_check_update_resp, '../cgi-bin/version.cgi')

###############################################################################
#                              F U N C T I O N S                              #
###############################################################################

#------------------------------------------------------------------------------
def error(msg):
    if __name__ == "__main__":
        sys.exit(msg)
    else:
        raise Exception(msg)

#------------------------------------------------------------------------------
def parseArgs(arguments=None):
    parser = argparse.ArgumentParser(
        description='ZoD Command line client. Full documentation available at http://almtools/confluence/display/BM/ZoD+command+line+client',
        formatter_class = argparse.RawTextHelpFormatter,
        prog='zodclient', # specified so that it still displays the right name when launched as a module
    )

    parser.add_argument('--url',      default='https://zod/zod', help='')
    parser.add_argument('--domain',                         help='ZoD domain name (ie. kplustp, kgr, kplus kenvng)')
    parser.add_argument('--guest',    action='store_true',  help='Anonymous login')
    parser.add_argument('--action',   choices=request_fcts.keys(), help='Mandatory. Action to be performed')
    parser.add_argument('--force',    action='store_true',  help='')
    parser.add_argument('--owner',                          help='By default, login name. Can be a regexp if search. (create, search)')
    parser.add_argument('--desc',                           help='Zone description. Can be a regexp if is search. (create, search)')
    parser.add_argument('--lifetime', type=int,             help='Zone lifetime in seconds. (create)')
    parser.add_argument('--zonename',                       help='Specify an explicit zone name. Can be a regexp if is search. (create, search, export)')
    parser.add_argument('--direct',   action='store_true',  help='Enable the zfs direct mode (create)')
    parser.add_argument('--implicit', action='store_true',  help='Snapshot on the fly the given dataset (create)')
    parser.add_argument('--nostart',  action='store_true',  help='Ask to not start any process (create)')
    parser.add_argument('--noboot',  action='store_true',   help='Do not boot zone after creation (create)')

    parser.add_argument('--zrc',      metavar='D',          help='Specify a custom kzone rc dataset/snapshot (create)')
    parser.add_argument('--identity',                       help='Path to the identity file (single line with the format: user<=>password)')
    # Apps
    parser.add_argument('--template',    metavar='D',  help='template file obtained firstly from template list in particular domain(create)')
    parser.add_argument('--kgr_home',           metavar='D',  help='dataset/snapshot to be used for KGR binaries (create)')
    parser.add_argument('--kgr_syb',            metavar='D',  help='dataset/snapshot to be used for KGR database (create)')
    parser.add_argument('--kplus_home',         metavar='D',  help='dataset/snapshot to be used for K+ binaries (create)')
    parser.add_argument('--kplus_syb',          metavar='D',  help='dataset/snapshot to be used for K+ database (create)')
    parser.add_argument('--summit_home',        metavar='D',  help='dataset/snapshot to be used for SUMMIT binaries (create)')
    parser.add_argument('--summit_data',        metavar='D',  help='dataset/snapshot to be used for SUMMIT database (create)')
    parser.add_argument('--sophis_home',        metavar='D',  help='dataset/snapshot to be used for SOPHIS binaries (create)')
    parser.add_argument('--sophis_data',        metavar='D',  help='dataset/snapshot to be used for SOPHIS database (create)')
    parser.add_argument('--topoffice_home',     metavar='D',  help='dataset/snapshot to be used for Top Office binaries (create)')
    parser.add_argument('--topoffice_data',     metavar='D',  help='dataset/snapshot to be used for Top Office database (create)')

    parser.add_argument('--opics_home',         metavar='D',  help='dataset/snapshot to be used for Opics binaries (create)')
    parser.add_argument('--opics_data',         metavar='D',  help='dataset/snapshot to be used for Opics database (create)')
 
    parser.add_argument('--orchestrate_home',   metavar='D',  help='dataset/snapshot to be used for Orchestrate binaries (create)')
    parser.add_argument('--orchestrate_data',   metavar='D',  help='dataset/snapshot to be used for Orchestrate configuration (create)')
    parser.add_argument('--bankfusion_home',    metavar='D',  help='dataset/snapshot to be used for Bankfusion binaries (create)')
    parser.add_argument('--bankfusion_data',    metavar='D',  help='dataset/snapshot to be used for Bankfusion database (create)')
    parser.add_argument('--kplustp_home',       metavar='D',  help='dataset/snapshot to be used for K+TP binaries (create)')
    parser.add_argument('--dasel_home',         metavar='D',  help='dataset/snapshot to be used for K+TP database (create)')
    parser.add_argument('--genesis_home',       metavar='D',  help='dataset/snapshot to be used for Genesis binaries (create)')
    parser.add_argument('--cmf_home',           metavar='D',  help='dataset/snapshot to be used for CMF (create)')
    parser.add_argument('--genericlimits_home', metavar='D',  help='dataset/snapshot to be used for GENERICLIMITS (create)')
    parser.add_argument('--globalcol_home',     metavar='D',  help='dataset/snapshot to be used for Global Collateral binaries (create)')
    parser.add_argument('--globalcol_data',     metavar='D',  help='dataset/snapshot to be used for Global Collateral database (create)')
    parser.add_argument('--globalcs_home',      metavar='D',  help='dataset/snapshot to be used for Global Curves binaries (create)')
    parser.add_argument('--globalcs_data',      metavar='D',  help='dataset/snapshot to be used for Global Curves data (create)')
    parser.add_argument('--globalpos_home',     metavar='D',  help='dataset/snapshot to be used for Global Position binaries (create)')
    parser.add_argument('--globalpos_data',     metavar='D',  help='dataset/snapshot to be used for Global Position database (create)')
    parser.add_argument('--globalps_home',      metavar='D',  help='dataset/snapshot to be used for Global Pricing binaries (create)')
    parser.add_argument('--globalps_data',      metavar='D',  help='dataset/snapshot to be used for Global Pricing data (create)')
    parser.add_argument('--etrading_home',      metavar='D',  help='dataset/snapshot to be used for ETrading binaries (create)')
    parser.add_argument('--etrading_data',      metavar='D',  help='dataset/snapshot to be used for ETrading database (create)')
    parser.add_argument('--workflow_home',      metavar='D',  help='dataset/snapshot to be used for Workflow binaries (create)')
    parser.add_argument('--zfs_add',            metavar='D',  help='dataset to be destroyed (update_dataset)')
    parser.add_argument('--zfs_del',            metavar='D',  help='dataset/snapshot to add (update_dataset)')
    # Thirdparties
    parser.add_argument('--els',                metavar='D',  help='dataset/snapshot to be used for ELS (create)')
    parser.add_argument('--rvd',                metavar='D',  help='dataset/snapshot to be used for Rendezvous (create)')
    parser.add_argument('--webaccess',          metavar='D',  help='dataset/snapshot to be used for WebAccess binaries (create)')
    parser.add_argument('--tomcat',             metavar='D',  help='dataset/snapshot to be used for Tomcat (create)')
    parser.add_argument('--ems',                metavar='D',  help='dataset/snapshot to be used for EMS (create)')
    parser.add_argument('--java',               metavar='D',  help='dataset/snapshot to be used for Java (create)')
    parser.add_argument('--nodejs',             metavar='D',  help='dataset/snapshot to be used for NodeJS (create)')
    parser.add_argument('--rmds',               metavar='D',  help='dataset/snapshot to be used for RMDS (create)')
    parser.add_argument('--weblo',              metavar='D',  help='dataset/snapshot to be used for WebLogic (create)')
    parser.add_argument('--qatools',            metavar='D',  help='dataset/snapshot to be used for QA (create)')
    parser.add_argument('--python',             metavar='D',  help='dataset/snapshot to be used for Python (create)')
    # Other options
    parser.add_argument('--zfs',       action='append',     help='List of ZFS datasets to use (replicate, rollback, snapshot)')
    parser.add_argument('--suffix',                         help='Zfs snapshot name (snapshot)')
    parser.add_argument('--comment',                        help='Zfs snapshot comment (snapshot)')
    parser.add_argument('--dstdom',                         help='Destination domain replicate/replicate_dataset (mandatory/mandatory)')
    parser.add_argument('--srchost',                        help='Source host for replicate_dataset (mandatory)')
    parser.add_argument('--dsthost',                        help='Destination host replicate/replicate_dataset (optional/mandatory)')
    parser.add_argument('--srczfs',                         help='Source dataset for replicate_dataset (mandatory)')
    parser.add_argument('--dstzfs',                         help='Destination dataset for replicate_dataset (optional)')
    parser.add_argument('--no_dataset_sync_check', action='store_true', help='Do not care if last src snapshot exists on dst dataset (optional)')
    parser.add_argument('--parseable', action='store_true', help='Remove pretty print display output from ZoD-client to be able to parse ZoD-client output')
    parser.add_argument('--debug',     action='store_true', help='Display raw json request and response')
    parser.add_argument('--yes',       action='store_true', help='Answer yes to all interactive prompts')
    parser.add_argument('--ls',        action='store_true', help='Equivalent to --action search')
    parser.add_argument('--full',      action='store_true', help='Print zones search with complete informations (search)')
    parser.add_argument('--format',    action='append',     help='Custom list of columns to display. Use headers name or column indexes. An empty element will add a separator in vertical tables such as zone description in --full mode')
    parser.add_argument('--date-format', action='store',    help='Custom format of date fields (use C formating string)')
    parser.add_argument('--version',   action='store_true', help='Print ZoD-client version number and exit')

    global args 
    args = parser.parse_args(arguments)

    guest=None
    if args.guest:
        guest=args.guest;

    args.guest=True

    if not args.domain:
        args.domain=''


    try:
        executeRequest(*check_update)
    except:
        pass

    args.guest=guest
    if args.domain=='':
        args.domain=None

    if args.version:
        print "ZoD-client Version " + VERSION
        error(0)

    if args.ls:
        args.action = 'search'

    if not re.match(r'^https?://.+', args.url):
        error("Please specify a valid URL (--url http://...)")

    if not args.domain and args.action != 'getdoms':
        error("Please specify a domain name (--domain)")

    if args.zfs:
        args.zfs = [item for sublist in [e.split(",") for e in args.zfs] for item in sublist] # ['a', 'b,c'] -> ['a', 'b', 'c']

    if args.format:
        args.format = [(item if item else None) for sublist in [e.split(",") for e in args.format] for item in sublist] # ['a', 'b,,c'] -> ['a', None, 'b', None, 'c']

    if __name__ != "__main__":
        args.yes = True

#------------------------------------------------------------------------------
def display_ok():
    print "Done"

#------------------------------------------------------------------------------
def mandatoryArg(arg, notEmpty=False, notZero=False):
    val = getattr(args, arg)
    if val == None:
        error('Error: --%s is mandatory for action %s'%(arg, args.action))
    if isinstance(val, types.StringTypes) and re.match(r'^\s*$', val) and notEmpty == True:
        error('Error: --%s parameter must not be empty for action %s'%(arg, args.action))
    if isinstance(val, types.IntType) and str(val) == '0' and notZero == True:
        error('Error: --%s parameter must not be zero for action %s'%(arg, args.action))
    return val

#------------------------------------------------------------------------------
def get_creds():
    if args.identity:
        return get_creds_from_file(args.identity)
    elif sys.stdin.isatty():
        return (raw_input('Login: '), getpass.getpass())
    else:
        error('Interactive mode not available. Please give your credentials (--identity) or use --guest')

#------------------------------------------------------------------------------
def get_creds_from_file(ident_file):
    if not os.path.exists(ident_file):
        error('Can\'t read %s. File not exists.' % (ident_file))
    if not os.path.isfile(ident_file):
        error('Can\'t read %s. Is not a file.' % (ident_file))
    if not os.access(ident_file, os.R_OK):
        error('Can\'t read %s. File is not readable' % (ident_file))
    with open(ident_file) as f:
        content = f.readline()
    match = re.match(r'^(.+)<=>(.+)$', content)
    if match:
        return (match.group(1), match.group(2))
    else:
        error("Malformed identity file. Expect: login<=>passowrd")

#------------------------------------------------------------------------------
def confirm(message, confirm):
    if not args.yes:
        if sys.stdin.isatty():
            if raw_input('%s (\'%s\' to continue) > '%(message, confirm)) != confirm:
                print 'Aborted'
                sys.exit(0)
        else:
            error('Interactive mode not available. Please use option --yes')

#------------------------------------------------------------------------------
def send_request(zod_req, url):
    scheme, zodserver, urlpath, query, fragment = urlparse.urlsplit(url)
    conn = httplib.HTTPSConnection(zodserver, timeout=http_timeout)
    headers = {'Content-type': 'application/json'}
    params = json.dumps(zod_req)
    conn.request('POST', urlpath, params, headers)
    if args.debug:
        if 'pass' in zod_req:
            zod_req['pass'] = '****'
        print "Sending request", json.dumps(zod_req, indent=4)
            
    response = conn.getresponse()
    if response.status != httplib.OK:
        raise Exception("HTTP request failed with status=%d, reason: %s" % (response.status, response.reason))
    json_response_data = response.read()
    conn.close()
    if args.debug:
        print "Received response", json_response_data
    return json.loads(json_response_data)

#------------------------------------------------------------------------------
def createRequest(build_req_fct):
    
    request = {'domain': args.domain}

    build_req_fct(request)
    if not args.guest and not args.version:
        request['login'], request['pass'] = get_creds()
    return request

#------------------------------------------------------------------------------
def executeRequest(build_req_fct, read_resp_fct, url):
    request = createRequest(build_req_fct)

    rurl=args.url

    if url:
        rurl = rurl + '/' +url

    resp = send_request(request, rurl)

    if resp['err_code'] != 0:
        error('ERROR: ' + resp['err_str'])

    if __name__ == "__main__":
        read_resp_fct(resp['data'])
    else:
        return resp['data']

#------------------------------------------------------------------------------
def run(commandLineArgs=None):
    parseArgs(commandLineArgs)
    if args.action:
        if args.action not in request_fcts:
            error('This action is not supported yet by ZoD-client')
    else:
        error('Please specify an action (--action)')
    return executeRequest(*request_fcts[args.action])

#------------------------------------------------------------------------------
def printTable(table, format=None, maxLengths=None, doSep=False, parseable=None):
    if parseable is None:
        parseable=args.parseable
    if parseable:
        print table.parseable(format).encode(encoding='UTF-8')
    else:
        print table.fancy(format, maxLengths, doSep).encode(encoding='UTF-8')

#------------------------------------------------------------------------------
# A simple banner function
#------------------------------------------------------------------------------
letterforms = '''\
       |       |       |       |       |       |       | |
  ###  |  ###  |  ###  |   #   |       |  ###  |  ###  |!|
  #  # |  #  # |  #  # |       |       |       |       |"|
  # #  |  # #  |#######|  # #  |#######|  # #  |  # #  |#|
 ##### |#  #  #|#  #   | ##### |   #  #|#  #  #| ##### |$|
###   #|# #  # |### #  |   #   |  # ###| #  # #|#   ###|%|
  ##   | #  #  |  ##   | ###   |#   # #|#    # | ###  #|&|
  ###  |  ###  |   #   |  #    |       |       |       |'|
   ##  |  #    | #     | #     | #     |  #    |   ##  |(|
  ##   |    #  |     # |     # |     # |    #  |  ##   |)|
       | #   # |  # #  |#######|  # #  | #   # |       |*|
       |   #   |   #   | ##### |   #   |   #   |       |+|
       |       |       |  ###  |  ###  |   #   |  #    |,|
       |       |       | ##### |       |       |       |-|
       |       |       |       |  ###  |  ###  |  ###  |.|
      #|     # |    #  |   #   |  #    | #     |#      |/|
  ###  | #   # |#     #|#     #|#     #| #   # |  ###  |0|
   #   |  ##   | # #   |   #   |   #   |   #   | ##### |1|
 ##### |#     #|      #| ##### |#      |#      |#######|2|
 ##### |#     #|      #| ##### |      #|#     #| ##### |3|
#      |#    # |#    # |#    # |#######|     # |     # |4|
#######|#      |#      |###### |      #|#     #| ##### |5|
 ##### |#     #|#      |###### |#     #|#     #| ##### |6|
###### |#    # |    #  |   #   |  #    |  #    |  #    |7|
 ##### |#     #|#     #| ##### |#     #|#     #| ##### |8|
 ##### |#     #|#     #| ######|      #|#     #| ##### |9|
   #   |  ###  |   #   |       |   #   |  ###  |   #   |:|
  ###  |  ###  |       |  ###  |  ###  |   #   |  #    |;|
    #  |   #   |  #    | #     |  #    |   #   |    #  |<|
       |       |#######|       |#######|       |       |=|
  #    |   #   |    #  |     # |    #  |   #   |  #    |>|
 ##### |#     #|      #|   ### |   #   |       |   #   |?|
 ##### |#     #|# ### #|# ### #|# #### |#      | ##### |@|
   #   |  # #  | #   # |#     #|#######|#     #|#     #|A|
###### |#     #|#     #|###### |#     #|#     #|###### |B|
 ##### |#     #|#      |#      |#      |#     #| ##### |C|
###### |#     #|#     #|#     #|#     #|#     #|###### |D|
#######|#      |#      |#####  |#      |#      |#######|E|
#######|#      |#      |#####  |#      |#      |#      |F|
 ##### |#     #|#      |#  ####|#     #|#     #| ##### |G|
#     #|#     #|#     #|#######|#     #|#     #|#     #|H|
  ###  |   #   |   #   |   #   |   #   |   #   |  ###  |I|
      #|      #|      #|      #|#     #|#     #| ##### |J|
#    # |#   #  |#  #   |###    |#  #   |#   #  |#    # |K|
#      |#      |#      |#      |#      |#      |#######|L|
#     #|##   ##|# # # #|#  #  #|#     #|#     #|#     #|M|
#     #|##    #|# #   #|#  #  #|#   # #|#    ##|#     #|N|
#######|#     #|#     #|#     #|#     #|#     #|#######|O|
###### |#     #|#     #|###### |#      |#      |#      |P|
 ##### |#     #|#     #|#     #|#   # #|#    # | #### #|Q|
###### |#     #|#     #|###### |#   #  |#    # |#     #|R|
 ##### |#     #|#      | ##### |      #|#     #| ##### |S|
#######|   #   |   #   |   #   |   #   |   #   |   #   |T|
#     #|#     #|#     #|#     #|#     #|#     #| ##### |U|
#     #|#     #|#     #|#     #| #   # |  # #  |   #   |V|
#     #|#  #  #|#  #  #|#  #  #|#  #  #|#  #  #| ## ## |W|
#     #| #   # |  # #  |   #   |  # #  | #   # |#     #|X|
#     #| #   # |  # #  |   #   |   #   |   #   |   #   |Y|
#######|     # |    #  |   #   |  #    | #     |#######|Z|
 ##### | #     | #     | #     | #     | #     | ##### |[|
#      | #     |  #    |   #   |    #  |     # |      #|\|
 ##### |     # |     # |     # |     # |     # | ##### |]|
   #   |  # #  | #   # |       |       |       |       |^|
       |       |       |       |       |       |#######|_|
       |  ###  |  ###  |   #   |    #  |       |       |`|
       |   ##  |  #  # | #    #| ######| #    #| #    #|a|
       | ##### | #    #| ##### | #    #| #    #| ##### |b|
       |  #### | #    #| #     | #     | #    #|  #### |c|
       | ##### | #    #| #    #| #    #| #    #| ##### |d|
       | ######| #     | ##### | #     | #     | ######|e|
       | ######| #     | ##### | #     | #     | #     |f|
       |  #### | #    #| #     | #  ###| #    #|  #### |g|
       | #    #| #    #| ######| #    #| #    #| #    #|h|
       |    #  |    #  |    #  |    #  |    #  |    #  |i|
       |      #|      #|      #|      #| #    #|  #### |j|
       | #    #| #   # | ####  | #  #  | #   # | #    #|k|
       | #     | #     | #     | #     | #     | ######|l|
       | #    #| ##  ##| # ## #| #    #| #    #| #    #|m|
       | #    #| ##   #| # #  #| #  # #| #   ##| #    #|n|
       |  #### | #    #| #    #| #    #| #    #|  #### |o|
       | ##### | #    #| #    #| ##### | #     | #     |p|
       |  #### | #    #| #    #| #  # #| #   # |  ### #|q|
       | ##### | #    #| #    #| ##### | #   # | #    #|r|
       |  #### | #     |  #### |      #| #    #|  #### |s|
       |  #####|    #  |    #  |    #  |    #  |    #  |t|
       | #    #| #    #| #    #| #    #| #    #|  #### |u|
       | #    #| #    #| #    #| #    #|  #  # |   ##  |v|
       | #    #| #    #| #    #| # ## #| ##  ##| #    #|w|
       | #    #|  #  # |   ##  |   ##  |  #  # | #    #|x|
       |  #   #|   # # |    #  |    #  |    #  |    #  |y|
       | ######|     # |    #  |   #   |  #    | ######|z|
  ###  | #     | #     |##     | #     | #     |  ###  |{|
   #   |   #   |   #   |       |   #   |   #   |   #   |||
  ###  |     # |     # |     ##|     # |     # |  ###  |}|
 ##    |#  #  #|    ## |       |       |       |       |~|
'''.splitlines()

bannerTable = {}
for form in letterforms:
    if '|' in form:
        bannerTable[form[-2]] = form[:-3].split('|')

def banner(word):
    for row in range(len(bannerTable.values()[0])):
        for c in word:
            print bannerTable[c][row],
        print
    print


###############################################################################
# A class to handle pretty printing and parseable printing of a data table
# with customizable format (wrapping, separators, printed columns)
###############################################################################
class Table:
    #------------------------------------------------------------------------------
    # Vertical mode:
    #   Special table with one value column or 2 key,value columns.
    #   The format option applies on keys, rather than on column headers, and the
    #   parseable output only prints a single value line
    #------------------------------------------------------------------------------
    def __init__(self, *header):
        self.header = header
        self.verticalMode = False
        self.data = []

    #------------------------------------------------------------------------------
    def setVerticalMode(self):
        self.verticalMode=True

    #------------------------------------------------------------------------------
    def add(self, *row):
        self.data.append(row)

    #------------------------------------------------------------------------------
    def separator(self):
        self.data.append(None)

    #------------------------------------------------------------------------------
    def checkDataConsistency(self): # Check that all rows have the same number of elements
        lengths = map(len, [x for x in self.data if x])
        if self.header:
            lengths.append(len(self.header))
        if lengths and not [lengths[0]]*len(lengths) == lengths:
            error('Cannot handle a table where all rows or header don\'t have the same size.')

    #------------------------------------------------------------------------------
    # Convert names into indexes, keep None for separator
    # Also returns a unique list of all available format items
    #------------------------------------------------------------------------------
    def normalizeFormat(self, format):
        availableFormatItems = self.header
        itemName = 'column'
        if self.verticalMode:
            itemName = 'row'
            if self.data and len(self.data[0]) == 2:
                availableFormatItems = [row[0] for row in self.data if row]
                # remove duplicate while preserving the order
                seen = set()
                availableFormatItems = [x for x in availableFormatItems if x not in seen and not seen.add(x)]
            else:
                availableFormatItems = None

        if format:
            for i, item in enumerate(format):
                try:
                    item = int(item)
                    maxlen = 0
                    if availableFormatItems:
                        maxlen = len(availableFormatItems)
                    elif not self.verticalMode:
                        maxlen = len(self.data[0])
                    else:
                        error('Custom format in verticalMode is only possible if the table has a description column')
                    if item<maxlen:
                        format[i] = item
                    else:
                        colList = ' (%s)'%", ".join(['%d: %s'%(i,n) for i,n in enumerate(availableFormatItems)]) if availableFormatItems else ''
                        error('No %s %d: There are only %d%s'%(itemName, item, maxlen, colList))
                except exceptions.ValueError:
                    if isinstance(item, types.StringTypes):
                        if not availableFormatItems:
                            error('Custom format may be specified with names only if the table has a header. Use indexes otherwise')
                        if item in availableFormatItems:
                            format[i] = availableFormatItems.index(item)
                        else:
                            error('%s is not part of known %ss (%s)'%(item, itemName, ", ".join(sorted(availableFormatItems))))
                except exceptions.TypeError:
                    if item == None: # None used for separator
                        if not self.verticalMode:
                            error('Separators in a custom format are only allowed in verticalMode')
                    else:
                        raise

        return (availableFormatItems, format)

    #------------------------------------------------------------------------------
    # The list of data columns to be actually printed
    #------------------------------------------------------------------------------
    def outputColIndexes(self, format): # Columns which must be displayed (or lines in vertical mode)
        if format and not self.verticalMode:
            cols = format
        elif self.header:
            cols = range(len(self.header))
        elif self.data:
            cols = range(len(self.data[0]))
        else:
            cols = []
        return cols
    
    #------------------------------------------------------------------------------
    # Create the table to be actually printed, based on Table mode and optional format option
    #------------------------------------------------------------------------------
    def outputData(self, format, maxLengths=None):
        availableFormatItems, format = self.normalizeFormat(format)
        cols = self.outputColIndexes(format)
        header = [self.header[i] for i in cols] if self.header else None
        maxLengths = [maxLengths[i] for i in cols] if maxLengths else None
        if self.verticalMode and format:
            data = []
            for index in format:
                if index!=None:
                    for row in self.data:
                        if row and availableFormatItems.index(row[0])==index:
                            data.append(row)
                else:
                    data.append(None)
        else:
            data = [[row[i] for i in cols] if row else None for row in self.data]
                     
        return (header, data, maxLengths)

    #------------------------------------------------------------------------------
    # Return a pretty ascii table
    #  - in normal mode, format is a list of header items, or header index
    #  - in vertical mode, data must be 2 columns (key, value) to use formatting. 
    #    the format is a list of keys. there may also be None for separators
    #  - maxLength: list of maximum length (or None) for each column to wrap
    #    in vertical mode, only 2 or 1 elements in the list
    #  - doSep: insert a separator after each row
    #------------------------------------------------------------------------------
    def fancy(self, format=None, maxLengths=None, doSep=False):
        self.checkDataConsistency()
        self.lastWasSep = False
        spacedLines = []
        header, data, maxLengths = self.outputData(format, maxLengths)
        if not header and not data: return ''

        columnLengths = [max(value) for value in zip(*[map(len, row) for row in data+[header] if row])]
        
        if maxLengths:
            columnLengths = [min(value) for value in zip(columnLengths, [m if m else 999999 for m in maxLengths])]

        #------------------------------------------------------------------------------
        def insertSeparator(linechar="-"):
            if self.lastWasSep:
                return
            spacedLine = '+'
            for i in columnLengths:
                spacedLine += linechar * (i+2) + '+'
            spacedLines.append(spacedLine)
            self.lastWasSep = True

        #------------------------------------------------------------------------------
        def insertData(row):
            mustInsertAdditionalLine = False
            if maxLengths:
                additionalLine = ['']*len(row)
            spacedLine = '|'
            for i, field in enumerate(row):
                if maxLengths:
                    if maxLengths[i] and len(field) > maxLengths[i]-3:
                        additionalLine[i] = field[maxLengths[i]-3:]
                        field = field[:maxLengths[i]-3]+'...'
                        mustInsertAdditionalLine = True
                diff = columnLengths[i] - len(field)
                spacedLine += " " + field + ' ' * diff + ' |'
            spacedLines.append(spacedLine)
            if mustInsertAdditionalLine:
                insertData(additionalLine)
            self.lastWasSep = False

        if (header):
            insertSeparator("=")
            insertData(header)
            insertSeparator("=")
        else:
            insertSeparator()
        for row in data:
            if row:
                if doSep:
                    insertSeparator()
                insertData(row)
            else:
                insertSeparator("=" if doSep else "-")
        insertSeparator()

        return '\n'.join(spacedLines)

    #------------------------------------------------------------------------------
    # Return a parseable list of data separated by tabs
    # - format: see fancy() comment
    #------------------------------------------------------------------------------
    def parseable(self, format=None):
        self.checkDataConsistency()
        if not self.data: return ''

        spacedLines = []
        header, data, maxLengths = self.outputData(format)
        if self.verticalMode:
            datacol = len(data[0])-1
            return "\t".join([row[datacol].replace("\t", "    ") for row in data if row])
        else:
            lines = []
            for row in data:
                if row:
                    lines.append("\t".join([value.replace("\t", "    ") for value in row]))
            return '\n'.join(lines)
                



###############################################################################
#                                   M A I N                                   #
###############################################################################

if __name__ == "__main__":
    if len(sys.argv) == 2 and sys.argv[1] == 'test':
        import zodclient_table_testsuite
        import zodclient_testsuite
        sys.exit(0)
    run()
    sys.exit(0)
