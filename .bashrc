# base-files version 3.9-2

# To pick up the latest recommended .bashrc content,
# look in /etc/defaults/etc/skel/.bashrc

# Modifying /etc/skel/.bashrc directly will prevent
# setup from updating it.

# The copy in your home directory (~/.bashrc) is yours, please
# feel free to customise it to create a shell
# environment to your liking.  If you feel a change
# would be benificial to all, please feel free to send
# a patch to the cygwin mailing list.

# User dependent .bashrc file

# Environment Variables
# #####################

# TMP and TEMP are defined in the Windows environment.  Leaving
# them set to the default Windows temporary directory can have
# unexpected consequences.
unset TMP
unset TEMP

# Alternatively, set them to the Cygwin temporary directory
# or to any other tmp directory of your choice
# export TMP=/tmp
# export TEMP=/tmp

# Or use TMPDIR instead
# export TMPDIR=/tmp

# Shell Options
# #############

# See man bash for more options...

# Don't wait for job termination notification
# set -o notify

# Don't use ^D to exit
# set -o ignoreeof

# Use case-insensitive filename globbing
# shopt -s nocaseglob

# Make bash append rather than overwrite the history on disk
# shopt -s histappend

# When changing directory small typos can be ignored by bash
# for example, cd /vr/lgo/apaache would find /var/log/apache
# shopt -s cdspell


# Completion options
# ##################

# These completion tuning parameters change the default behavior of bash_completion:

# Define to access remotely checked-out files over passwordless ssh for CVS
# COMP_CVS_REMOTE=1

# Define to avoid stripping description in --option=description of './configure --help'
# COMP_CONFIGURE_HINTS=1

# Define to avoid flattening internal contents of tar files
# COMP_TAR_INTERNAL_PATHS=1

# If this shell is interactive, turn on programmable completion enhancements.
# Any completions you add in ~/.bash_completion are sourced last.
# case $- in
#   *i*) [[ -f /etc/bash_completion ]] && . /etc/bash_completion ;;
# esac


# History Options
# ###############

# Don't put duplicate lines in the history.
# export HISTCONTROL="ignoredups"

# Ignore some controlling instructions
# HISTIGNORE is a colon-delimited list of patterns which should be excluded.
# The '&' is a special pattern which suppresses duplicate entries.
# export HISTIGNORE="[ \t]*:&:[fb]g:exit"
# export HISTIGNORE="[ \t]*:&:[fb]g:exit:ls" # Ignore the ls command as well

# Whenever displaying the prompt, write the previous line to disk
# export PROMPT_COMMAND="history -a"


# Aliases
# #######

# Some example alias instructions
# If these are enabled they will be used instead of any instructions
# they may mask.  For example, alias rm='rm -i' will mask the rm
# application.  To override the alias instruction use a \ before, ie
# \rm will call the real rm not the alias.

# Interactive operation...
# alias rm='rm -i'
# alias cp='cp -i'
# alias mv='mv -i'

# Default to human readable figures
# alias df='df -h'
# alias du='du -h'

# Misc :)
# alias less='less -r'                          # raw control characters
# alias whence='type -a'                        # where, of a sort
# alias grep='grep --color'                     # show differences in colour

# Some shortcuts for different directory listings
# alias ls='ls -hF --color=tty'                 # classify files in colour
# alias dir='ls --color=auto --format=vertical'
# alias vdir='ls --color=auto --format=long'
# alias ll='ls -l'                              # long list
# alias la='ls -A'                              # all but . and ..
# alias l='ls -CF'                              #


# Functions
# #########

# Some example functions
# function settitle() { echo -ne "\e]2;$@\a\e]1;$@\a"; }

##
# XXXXXXXXXXXXXXXXXXXXX
##

export MACHINE=x86Linux
export ARCH=cygwin

echo ${ARCH} ${MACHINE}

export PROJECT_USER=albandri
export PROJECT_VERSION=10
export DRIVE_PATH=/cygdrive/c
export DEV_HOME=${DRIVE_PATH}/workspace/users
# Do not use hudson workspace
#export WORKSPACE=${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}
export WORKSPACE_ENV=${DEV_HOME}/${PROJECT_USER}${PROJECT_VERSION}/env

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

echo ${CIAO_ROOT}

DANCE_ROOT=${CIAO_ROOT}/DANCE
export DANCE_ROOT

echo ${DANCE_ROOT}

DDS_ROOT=${CIO_ROOT}/connectors/dds4ccm
export DDS_ROOT

echo ${DDS_ROOT}

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
export PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin

#export ACE_ROOT=${DRIVE_PATH}/thirdparty/tao/ACE_wrappers
export LD_LIBRARY_PATH=${ACE_ROOT}/lib:${LD_LIBRARY_PATH}

echo "make and make static_libs=1 in"
echo "cd ${ACE_ROOT}/ace"
echo "cd ${ACE_ROOT}/apps/gperf"
echo "cd ${TAO_ROOT}/tao"
echo "cd ${TAO_ROOT}/TAO_IDL"
echo "cd ${TAO_ROOT}/orbsvcs/orbsvcs"

echo SHELL : ${SHELL}

alias 00='source ${DEV_HOME}/${PROJECT_USER}00/env/dev.env.sh'
#alias 30='source ${DEV_HOME}/${PROJECT_USER}30/env/dev.env.sh'
alias 10='source ${WORKSPACE_ENV}/dev.env.sh'

if [ -f ${WORKSPACE_ENV}/dev.env.sh ]; then
    echo ${WORKSPACE_ENV}/dev.env.sh
    . ${WORKSPACE_ENV}/dev.env.sh
fi
