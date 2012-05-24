# ~/.bashrc: executed by bash(1) for non-login shells.
# see /usr/share/doc/bash/examples/startup-files (in the package bash-doc)
# for examples

# If not running interactively, don't do anything
[ -z "$PS1" ] && return

# don't put duplicate lines in the history. See bash(1) for more options
export HISTCONTROL=ignoredups
# ... and ignore same sucessive entries.
export HISTCONTROL=ignoreboth

# check the window size after each command and, if necessary,
# update the values of LINES and COLUMNS.
shopt -s checkwinsize

# make less more friendly for non-text input files, see lesspipe(1)
[ -x /usr/bin/lesspipe ] && eval "$(lesspipe)"

# set variable identifying the chroot you work in (used in the prompt below)
if [ -z "$debian_chroot" ] && [ -r /etc/debian_chroot ]; then
    debian_chroot=$(cat /etc/debian_chroot)
fi

# set a fancy prompt (non-color, unless we know we "want" color)
case "$TERM" in
xterm-color)
    PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
    ;;
*)
    PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
    ;;
esac

# Comment in the above and uncomment this below for a color prompt
#PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '

# If this is an xterm set the title to user@host:dir
case "$TERM" in
xterm*|rxvt*)
    PROMPT_COMMAND='echo -ne "\033]0;${USER}@${HOSTNAME}: ${PWD/$HOME/~}\007"'
    ;;
*)
    ;;
esac

# Alias definitions.
# You may want to put all your additions into a separate file like
# ~/.bash_aliases, instead of adding them here directly.
# See /usr/share/doc/bash-doc/examples in the bash-doc package.

#if [ -f ~/.bash_aliases ]; then
#    . ~/.bash_aliases
#fi

# enable color support of ls and also add handy aliases
if [ "$TERM" != "dumb" ]; then
    eval "`dircolors -b`"
    alias ls='ls --color=auto'
    #alias dir='ls --color=auto --format=vertical'
    #alias vdir='ls --color=auto --format=long'
fi

# some more ls aliases
alias ll='ls -lrta'
#alias la='ls -A'
#alias l='ls -CF'

# enable programmable completion features (you don't need to enable
# this, if it's already enabled in /etc/bash.bashrc and /etc/profile
# sources /etc/bash.bashrc).
if [ -f /etc/bash_completion ]; then
    . /etc/bash_completion
fi

##
# BACKEND
##

export MACHINE=x86Linux
export ARCH=cygwin

echo ${ARCH} ${MACHINE}

export PROJECT_USER=albandri
export PROJECT_VERSION=10
export DRIVE_PATH=${DRIVE_PATH}
export DEV_HOME=${DRIVE_PATH}/workspace/users
# Do not use hudson workspace
#export WORKSPACE=${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}
export WORKSPACE_ENV=${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env/${ARCH}

export PROJECT_THIRDPARTY_PATH=${DRIVE_PATH}/thirdparty
echo PROJECT_THIRDPARTY_PATH ${PROJECT_THIRDPARTY_PATH}
export CORBA_ROOT=${PROJECT_THIRDPARTY_PATH}/tao
export ACE_ROOT=${CORBA_ROOT}/ACE_wrappers
#export ACE_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers

echo ${ACE_ROOT}

TAO_ROOT=${ACE_ROOT}/TAO
export TAO_ROOT

echo ${TAO_ROOT}

MPC_ROOT=${ACE_ROOT}/MPC
export MPC_ROOT

echo ${MPC_ROOT}

CIAO_ROOT=${TAO_ROOT}/CIAO
export CIAO_ROOT
DANCE_ROOT=${CIAO_ROOT}/DANCE
export DANCE_ROOT

DDS_ROOT=${CIO_ROOT}/connectors/dds4ccm
export DDS_ROOT

#export PATH=${DRIVE_PATH}/cygwin/bin:${DRIVE_PATH}/cygwin/usr/include:${DRIVE_PATH}/cygwin/usr/lib:${DRIVE_PATH}/cygwin/lib
#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin:
export PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/games:${DRIVE_PATH}/cygwin/bin
#export ACE_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers
export LD_LIBRARY_PATH=$ACE_ROOT/lib:$LD_LIBRARY_PATH
#export ARCH=

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
