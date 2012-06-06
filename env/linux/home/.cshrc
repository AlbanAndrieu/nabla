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
setenv ARCH x86Linux

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
setenv WORKSPACE_ENV ${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env

setenv PROJECT_THIRDPARTY_PATH ${DRIVE_PATH}/thirdparty
echo PROJECT_THIRDPARTY_PATH ${PROJECT_THIRDPARTY_PATH}

echo ${SHELL}

alias 00 'source ${DEV_HOME}/${KPLUSTP_USER}00/env/dev.env.csh \!*; test ! -f ~/.cshrc.local || source ~/.cshrc.local \!*'
alias 10 'source ${WORKSPACE_ENV}/dev.env.csh \!*; test ! -f ~/.cshrc.local || source ~/.cshrc.local \!*'

if [ -f ${WORKSPACE_ENV}/dev.env.sh ]; then
    echo ${WORKSPACE_ENV}/dev.env.sh
    . ${WORKSPACE_ENV}/dev.env.sh
fi

# Set current development branche environment
# 10
echo "Set your environment with 10 alias."
