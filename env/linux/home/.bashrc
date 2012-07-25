# ~/.bashrc: executed by bash(1) for non-login shells.
# see /usr/share/doc/bash/examples/startup-files (in the package bash-doc)
# for examples

# If not running interactively, don't do anything
[ -z "$PS1" ] && return

# don't put duplicate lines in the history. See bash(1) for more options
# don't overwrite GNU Midnight Commander's setting of `ignorespace'.
HISTCONTROL=$HISTCONTROL${HISTCONTROL+,}ignoredups
# ... or force ignoredups and ignorespace
HISTCONTROL=ignoreboth

# append to the history file, don't overwrite it
shopt -s histappend

# for setting history length see HISTSIZE and HISTFILESIZE in bash(1)

# check the window size after each command and, if necessary,
# update the values of LINES and COLUMNS.
shopt -s checkwinsize

# make less more friendly for non-text input files, see lesspipe(1)
[ -x /usr/bin/lesspipe ] && eval "$(SHELL=/bin/sh lesspipe)"

# set variable identifying the chroot you work in (used in the prompt below)
if [ -z "$debian_chroot" ] && [ -r /etc/debian_chroot ]; then
    debian_chroot=$(cat /etc/debian_chroot)
fi

# set a fancy prompt (non-color, unless we know we "want" color)
case "$TERM" in
    xterm-color) color_prompt=yes;;
esac

# uncomment for a colored prompt, if the terminal has the capability; turned
# off by default to not distract the user: the focus in a terminal window
# should be on the output of commands, not on the prompt
#force_color_prompt=yes

if [ -n "$force_color_prompt" ]; then
    if [ -x /usr/bin/tput ] && tput setaf 1 >&/dev/null; then
	# We have color support; assume it's compliant with Ecma-48
	# (ISO/IEC-6429). (Lack of such support is extremely rare, and such
	# a case would tend to support setf rather than setaf.)
	color_prompt=yes
    else
	color_prompt=
    fi
fi

if [ "$color_prompt" = yes ]; then
    PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
else
    PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
fi
unset color_prompt force_color_prompt

# If this is an xterm set the title to user@host:dir
case "$TERM" in
xterm*|rxvt*)
    PS1="\[\e]0;${debian_chroot:+($debian_chroot)}\u@\h: \w\a\]$PS1"
    ;;
*)
    ;;
esac

# enable color support of ls and also add handy aliases
if [ -x /usr/bin/dircolors ]; then
    test -r ~/.dircolors && eval "$(dircolors -b ~/.dircolors)" || eval "$(dircolors -b)"
    alias ls='ls --color=auto'
    #alias dir='dir --color=auto'
    #alias vdir='vdir --color=auto'

    alias grep='grep --color=auto'
    alias fgrep='fgrep --color=auto'
    alias egrep='egrep --color=auto'
fi

# some more ls aliases
alias ll='ls -lrta'
#alias la='ls -A'
#alias l='ls -CF'

# Alias definitions.
# You may want to put all your additions into a separate file like
# ~/.bash_aliases, instead of adding them here directly.
# See /usr/share/doc/bash-doc/examples in the bash-doc package.

if [ -f ~/.bash_aliases ]; then
    . ~/.bash_aliases
fi

# enable programmable completion features (you don't need to enable
# this, if it's already enabled in /etc/bash.bashrc and /etc/profile
# sources /etc/bash.bashrc).
if [ -f /etc/bash_completion ] && ! shopt -oq posix; then
    . /etc/bash_completion
fi

echo "Mounting Virtual box"
echo "sudo -s"
echo "sudo mount -t vboxsf workspace /workspace"
echo "sudo mount -t vboxsf thirdparty /thirdparty"
echo "sudo mount -t vboxsf target /target"
echo "sudo mount -t vboxsf repo /repo"
echo "sudo mount -t vboxsf jboss /jboss"

##
# BACKEND
##

export MACHINE=x86Linux
export ARCH=linux

echo ${ARCH} ${MACHINE}

export DEV_USER=albandri
export DEV_VERSION=30
export DEV_EXTRACTION=ktpplus
export DRIVE_PATH=
export DEV_HOME=${DRIVE_PATH}/workspace/users
# Do not use hudson workspace
export WORKSPACE_ENV=${DEV_HOME}/${DEV_USER}${DEV_VERSION}/env/${ARCH}

export THIRDPARTY_ROOT=${DRIVE_PATH}/thirdparty
echo THIRDPARTY_ROOT ${THIRDPARTY_ROOT}

if [ "${ARCH}" = cygwin ]
then
  export CORBA_ROOT=${THIRDPARTY_ROOT}/tao
  export ACE_ROOT=${CORBA_ROOT}/ACE_wrappers

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
fi

echo "make and make static_libs=1 in"
echo "cd ${ACE_ROOT}/ace"
echo "cd ${ACE_ROOT}/apps/gperf"
echo "cd ${TAO_ROOT}/tao"
echo "cd ${TAO_ROOT}/TAO_IDL"
echo "cd ${TAO_ROOT}/orbsvcs/orbsvcs"

#If you want to use new GCC by default, make sure that your PATH contains /usr/local/bin before /bin and /usr/bin.
#:/sbin:/usr/local/sbin:
export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games
#export LD_LIBRARY_PATH=$ACE_ROOT/lib:$LD_LIBRARY_PATH

echo ${SHELL}

if [ -f ${WORKSPACE_ENV}/dev.env.sh ]; then
    echo ${WORKSPACE_ENV}/dev.env.sh
    . ${WORKSPACE_ENV}/dev.env.sh
fi