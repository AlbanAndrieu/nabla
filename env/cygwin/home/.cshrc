# .cshrc
#
# this file gets executed with every subshell

# is this an interactive shell?
if ( $?prompt ) then

    # yes, we're in an interactive shell

    # prompt
    set prompt = "%{\033[1;36m%}peter %{\033[1;35m%}[%~] %{\033[1;36m%}%n \%%{\033[1;33m%} "

    # history
    set history         = 1000
    set savehist        = 1000
    #set EDITOR          = vim
    set EDITOR          = nedit
    set filec fignore = (.o)

    # cmd-line bindings
    bindkey -v          ; # use vi key bindings

    # display
    set DISPLAY         = localhost:0.0

    # cvs
    # set MAKEFLAGS     = "--no-print-directory"
    set CVSROOT         = :ext:mzieg@cvs-oa.orl.lmco.com:/usr/local/cvsroot
    # aliases
    alias vi            vim
    alias dir           'ls -lav --color=auto'
    alias nslookup      host

endif

bindkey >& /dev/null
if ( $status == 0 ) then
        bindkey "\e[1~" beginning-of-line
        bindkey "\e[3~" delete-char
        bindkey "\e[4~" end-of-line
        bindkey "\e[5~" history-search-backward
        bindkey "\e[6~" history-search-forward
endif

##
# XXXXXXXXXXXXXXXXXXXXX
##

setenv MACHINE x86Linux
setenv ARCH cygwin

echo ${ARCH} ${MACHINE}

# ----------
if ( "${ARCH}" == sun4sol ) then
    coreadm -p core.%f.%n.%p $$
endif

setenv PROJECT_USER albandri
setenv PROJECT_VERSION 10
setenv DRIVE_PATH ${DRIVE_PATH}
# ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}
setenv DEV_HOME ${DRIVE_PATH}/workspace/users
# Do not use hudson workspace
#setenv WORKSPACE ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}
setenv WORKSPACE_ENV ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env/${ARCH}

setenv PROJECT_THIRDPARTY_PATH ${DRIVE_PATH}/thirdparty
echo PROJECT_THIRDPARTY_PATH ${PROJECT_THIRDPARTY_PATH}
setenv CORBA_ROOT ${PROJECT_THIRDPARTY_PATH}/tao
setenv ACE_ROOT ${CORBA_ROOT}/ACE_wrappers
#setenv ACE_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers

echo ${ACE_ROOT}

TAO_ROOT ${ACE_ROOT}/TAO
setenv TAO_ROOT

echo ${TAO_ROOT}

MPC_ROOT ${ACE_ROOT}/MPC
setenv MPC_ROOT

echo ${MPC_ROOT}

CIAO_ROOT ${TAO_ROOT}/CIAO
setenv CIAO_ROOT
DANCE_ROOT ${CIAO_ROOT}/DANCE
setenv DANCE_ROOT

DDS_ROOT ${CIO_ROOT}/connectors/dds4ccm
setenv DDS_ROOT

#setenv PATH ${DRIVE_PATH}/cygwin/bin:${DRIVE_PATH}/cygwin/usr/include:${DRIVE_PATH}/cygwin/usr/lib:${DRIVE_PATH}/cygwin/lib
#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin:
setenv PATH /usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:${DRIVE_PATH}/cygwin/bin
#setenv ACE_ROOT ${DRIVE_PATH}/thirdparty/tao/ACE_wrappers
setenv LD_LIBRARY_PATH $ACE_ROOT/lib:$LD_LIBRARY_PATH

echo "make and make static_libs=1 in"
echo "cd ${ACE_ROOT}/ace"
echo "cd ${ACE_ROOT}/apps/gperf"
echo "cd ${TAO_ROOT}/tao"
echo "cd ${TAO_ROOT}/TAO_IDL"
echo "cd ${TAO_ROOT}/orbsvcs/orbsvcs"

echo ${SHELL}

if [ -f ${WORKSPACE_ENV}/dev.env.sh ]; then
    echo ${WORKSPACE_ENV}/dev.env.sh
    . ${WORKSPACE_ENV}/dev.env.sh
fi

setenv WORKSPACE_ENV ${DEV_HOME}/${KPLUSTP_USER}${KPLUSTP_VERSION}/env/${ARCH}

alias 00 'source ${DEV_HOME}/${KPLUSTP_USER}00/env/${ARCH}/dev.env.csh \!*; test ! -f ~/.cshrc.local || source ~/.cshrc.local \!*'
alias 10 'source ${WORKSPACE_ENV}/dev.env.csh \!*; test ! -f ~/.cshrc.local || source ~/.cshrc.local \!*'

# Set current development branche environment
# 10
echo "Set your environment with 10 alias."
