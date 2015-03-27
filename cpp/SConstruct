#################
# Scons build script
######################

import os
import re
#import platform

from config import ProjectMacro

EnsureSConsVersion(2, 1)
#EnsurePythonVersion(2, 7)

# To be retrieved automatically
Arch = ProjectMacro.getArch()
print "Arch :", Arch

# Command line variables definition
vars = Variables('variables.py') # you can store your defaults in this file
vars.AddVariables(
    EnumVariable('opt', 'Set to True to build with opt flags', 'False', ['True', 'False']),
    ('gcc_version', 'Set gcc version to use', '4.1.2'),
    ('install_path', 'Set install path', 'install'),
    EnumVariable('target', 'Target platform', 'local', ['default', 'local'])
)
env = DefaultEnvironment(tools = ['gcc', 'gnulink'], CC = '/usr/local/bin/gcc')

#print "Platform :", platform.platform()
#print "machine : ", platform.machine()  
    
if Arch in ['x86sol','sun4sol']:
    env = Environment(tools=['suncc', 'sunc++', 'sunlink'])
#print "ENV PATH :", env['ENV']['PATH']
env = Environment(variables = vars, tools = ['default', 'packaging', 'Project'], toolpath = ['config'])
print "ENV TOOLS :", env['TOOLS']
#print "dump whole env :", env.Dump()
print "ENV ENV :", env['ENV']
vars.Update(env)
Help(vars.GenerateHelpText(env))
unknown = vars.UnknownVariables()
if unknown:
    print "Unknown variables :", unknown.keys()
    Exit(1)

print "vars :", vars.GenerateHelpText(env)
# Save variables
vars.Save('variables.py', env)

# SCons configuration
SetOption('max_drift', '1') # We are using a local disk
Decider('MD5-timestamp')

# Paths deduced from sandbox location
env['sandbox'] = Dir("#").srcnode().abspath

print "sandbox :", env['sandbox']

#
# Environment extraction
#########################
# Default values setted when no environment defined (like jenkins)
if env['target'] == 'local':
  DEV_SOURCE_DIR = env['sandbox']
  DEV_BINARY_DIR = env['sandbox'] + '/target'
else:
  DEV_SOURCE_DIR = ProjectMacro.getEnvVariable('PROJECT_SRC',os.path.dirname(env['sandbox']))
  DEV_BINARY_DIR = ProjectMacro.getEnvVariable('PROJECT_TARGET_PATH',os.path.dirname(env['sandbox'])) + '/sample'

#if re.search('dev\/', DEV_BINARY_DIR):
#  DEV_BINARY_DIR = re.sub(r'dev\/', 'dev_target/', DEV_BINARY_DIR)

print "DEV_BINARY_DIR :", DEV_BINARY_DIR

if env['target'] == 'local':
	PROJECT_THIRDPARTY_PATH = env['sandbox'] + '/thirdparty'
else:
	PROJECT_THIRDPARTY_PATH = ProjectMacro.getEnvVariable('PROJECT_THIRDPARTY_PATH','/thirdparty')

print "PROJECT_THIRDPARTY_PATH :", PROJECT_THIRDPARTY_PATH

# might not WORK in eclipse (hard code it)
PROJECT_JAVA_PATH = ProjectMacro.getEnvVariable('JAVA_HOME', PROJECT_THIRDPARTY_PATH + 'java' + Arch)
print "PROJECT_JAVA_PATH :", PROJECT_JAVA_PATH

env['cache_path'] = DEV_BINARY_DIR + '/buildcache-' + Arch
print "env['cache_path'] :", env['cache_path']
CacheDir(env['cache_path'])
SConsignFile(DEV_BINARY_DIR + '/scons-signatures-' + Arch)

#registering function to handle builderrors correctly
ProjectMacro.registerBuildFailuresAtExit()

if env['opt'] == 'True':
	print "opt mode activated"
	theOptDbgFolder = 'opt'+env['Suffix64']
	env.Prepend(CCFLAGS = env['opt_flags'])
	env.Prepend(CCFLAGS = '-DNDEBUG')
	if Arch in ['sun4sol','x86sol']:
		env.Prepend(CCFLAGS = '-xlibmil')
		env.Prepend(CCFLAGS = '-xlibmopt')
else:
	theOptDbgFolder = 'debug'+env['Suffix64']
	env.Prepend(CCFLAGS = env['debug_flags'])
	env.Prepend(CCFLAGS = '-DDEBUG')

#binaries directory
thePath=os.path.join(DEV_BINARY_DIR,'bin',Arch)
ProjectMacro.mkdir(thePath)
PROJECT_BINARY_DIR = os.path.abspath(thePath)
#target directories
thePath=os.path.join(DEV_BINARY_DIR,'target',Arch)
ProjectMacro.mkdir(os.path.join(thePath,theOptDbgFolder))
thePath=os.path.join(DEV_BINARY_DIR,'include',Arch)
ProjectMacro.mkdir(thePath)
PROJECT_INCLUDE_DIR = os.path.abspath(thePath)
#lib directories
thePath=os.path.join(DEV_BINARY_DIR,'lib',Arch,theOptDbgFolder)
ProjectMacro.mkdir(thePath)
LIBRARY_STATIC_OUTPUT_PATH = Dir(thePath).srcnode().abspath
thePath=os.path.join(LIBRARY_STATIC_OUTPUT_PATH,'shared')
ProjectMacro.mkdir(thePath)
LIBRARY_OUTPUT_PATH = Dir(thePath).srcnode().abspath

if env['target'] == 'local':
  PROJECT_BINARY_DIR = '.'
else:
  PROJECT_BINARY_DIR = os.path.abspath(os.path.join(thePath,theOptDbgFolder))
  VariantDir(os.path.join(PROJECT_BINARY_DIR,'sample'), 'sample', duplicate=0)

env['LIBRARY_STATIC_OUTPUT_PATH'] = LIBRARY_STATIC_OUTPUT_PATH
env['LIBRARY_OUTPUT_PATH'] = LIBRARY_OUTPUT_PATH
env['PROJECT_BINARY_DIR'] = PROJECT_BINARY_DIR
env['PROJECT_INCLUDE_DIR'] = PROJECT_INCLUDE_DIR

print "static lib dir :", LIBRARY_STATIC_OUTPUT_PATH
print "shared lib dir :", LIBRARY_OUTPUT_PATH
print "bin dir :", PROJECT_BINARY_DIR
print "include dir :", PROJECT_INCLUDE_DIR

env['CPPPATH'] = [
    '.',
# published headers
	PROJECT_INCLUDE_DIR,
# 3rd parties
#	os.path.join(PROJECT_THIRDPARTY_PATH,'cppunit',Arch,'include'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'boost',Arch,'include'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'zlib',Arch,'include'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'xerces',Arch,'include'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'log4cxx',Arch,'include'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'tao',Arch,'ACE_wrappers'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'tao',Arch,'ACE_wrappers','TAO'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'tao',Arch,'ACE_wrappers','TAO','orbsvcs'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'openssl',Arch,'include'),
	os.path.join(PROJECT_JAVA_PATH,'include'),
	os.path.join(PROJECT_JAVA_PATH,'include',['linux','solaris'][Arch!='x86Linux']),
]

# -L parameter
##############
env["LIBPATH"]     = [
	LIBRARY_STATIC_OUTPUT_PATH,
	LIBRARY_OUTPUT_PATH,
#	os.path.join(PROJECT_THIRDPARTY_PATH,'boost', Arch, 'lib',['','opt/shared'][Arch!='x86Linux']),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'xerces', Arch, 'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'libxml2', Arch, 'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'tao', Arch, 'ACE_wrappers','lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'openssl',Arch,'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'rv', Arch, 'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'apr',Arch,'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'apr-util',Arch,'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'log4cxx', Arch, 'lib'),
#	os.path.join(PROJECT_THIRDPARTY_PATH,'cppunit',Arch,'lib'),
	os.path.join(PROJECT_JAVA_PATH, 'jre','lib',env['java_arch'],'server'),

# 3rd parties
]

#print "LIBPATH :", env['LIBPATH']
LD_LIBRARY_PATH=':'.join([os.path.abspath(x) for x in env['LIBPATH']])
print "LD_LIBRARY_PATH :", LD_LIBRARY_PATH
textfile = file('path.sh','w')
textfile.writelines('#!/bin/sh\n')
textfile.writelines('#Generated by scons\n')
textfile.writelines('export LIBPATH=' + LD_LIBRARY_PATH + '\n')
#textfile.writelines('echo LIBPATH : $LIBPATH \n')
#textfile.writelines('exit 0\n')
textfile.close()

env['TAO'] = [
	'ACE',
	'ACE_RMCast',
	'TAO',
	'TAO_BiDirGIOP',
	'TAO_DynamicAny',
	'TAO_DynamicInterface',
	'TAO_IDL_BE',
	'TAO_IDL_FE',
	'TAO_IFR_Client',
	'TAO_IORManip',
	'TAO_IORTable',
	'TAO_Messaging',
	'TAO_PortableServer',
	'TAO_RTCORBA',
	'TAO_RTPortableServer',
	'TAO_SmartProxies',
	'TAO_Strategies',
	'TAO_TypeCodeFactory',
	'TAO_Utils',
	'TAO_CosNaming',
	'TAO_Codeset',
]

#####################################
# 3rd parties versions suffixes
#
Versions = dict([
    ('test_1', '01'),
    ('test_2', '02'),
])
#
#####################################

#### Lists of libs for link
env['MORELibs'] = [
#	'Todo1' + Versions['test_1'],
#	'Todo2' + Versions['test_2'],
	'tibrv'+env['Suffix64'],
	'tibrvcm'+env['Suffix64'],
	'tibrvcmq'+env['Suffix64'],
	'tibrvft'+env['Suffix64'],
	'tibrvcpp'+env['Suffix64'],
	'crypto',
	'xml2',
]

# Clean
Clean('.', 'install')

if 'package' in COMMAND_LINE_TARGETS:
    print "Remove nabla-1.2.3 directory"
    env.Execute("rm -Rf nabla-1.2.3")

# nabla target
if 'nabla' in COMMAND_LINE_TARGETS:
    #env.Execute("svn status libs|perl -l -ne 'if(s,^\?\s+(.+(?:\.cpp|\.h|\.xml|timestamps|sconsign.dblite|/ddl|/business|ps-make|ps-make.*|ps-private|.*\.vcproj|.*\.bak|.*\.hierarchy|.*\.views|.*\.per|.*\.enum2|.*\.gen))$,$1,){print $_}' | xargs rm -fr")
    SetOption("clean", 1)

#additional libs for link
env['OSDependentLibs']=[]
if Arch in ['x86sol','sun4sol']:
	env['OSDependentLibs'].extend([ 'posix4','pthread','thread','socket'])

#register the idl builder
ProjectMacro.registerIDLBuilders(env,PROJECT_THIRDPARTY_PATH,Arch)

# Variables visible to SConscripts
Export('env', 'Versions')

#Sconscript calls
if not GetOption('help'):
    env.SConscript([
    		PROJECT_BINARY_DIR+'/sample/microsoft/src/main/cpp/SConscript',
		PROJECT_BINARY_DIR+'/sample/microsoft/src/main/app/SConscript',
    ])

SConscript(PROJECT_BINARY_DIR+'/sample/microsoft/src/test/cpp/SConscript')
SConscript(PROJECT_BINARY_DIR+'/sample/microsoft/src/test/app/SConscript')

if 'package' in COMMAND_LINE_TARGETS:
    env.Package( NAME           = 'nabla',
                 VERSION        = '1.2.3',
                 PACKAGEVERSION = 0,
                 PACKAGETYPE    = 'targz',
                 source=[LIBRARY_OUTPUT_PATH, PROJECT_BINARY_DIR],
                 LICENSE        = 'misys',
                 SUMMARY        = 'Nabla (Backend)',
                 DESCRIPTION    = 'Nabla (Backend)',
                 X_RPM_GROUP    = 'Application/nabla',
                 SOURCE_URL     = 'https://home.nabla.mobi/nabla-1.2.3.tar.gz'
            )

print "DEFAULT_TARGETS", map(str, DEFAULT_TARGETS)

#See http://google-styleguide.googlecode.com/
#os.system('./cpplint.sh')

#TODO : http://v8.googlecode.com/svn/trunk/SConstruct
