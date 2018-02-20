#!/bin/bash
#set -xv

source ./step-0-color.sh

# shellcheck disable=SC2154
echo -e "${yellow} ${bold} WELCOME ${nabla_logo} ${NC}"

# shellcheck disable=SC2154
echo -e "${ltgray} HOSTNAME : ${HOSTNAME} ${NC}"
# shellcheck disable=SC2154
echo -e "${cyan} SHELL : ${SHELL} ${NC}"
echo -e "${cyan} TERM : ${TERM} ${NC}"
echo -e "${cyan} HOME : ${HOME} ${NC}"
echo -e "${cyan} USER : ${USER} ${NC}"
# shellcheck disable=SC2154
echo -e "${blue} PATH : ${PATH} ${NC}"

# shellcheck disable=SC2154
echo -e "${green} ARCH : ${ARCH} ${NC}"
echo -e "${green} WORKSPACE_SUFFIX : ${WORKSPACE_SUFFIX} ${NC}"
echo -e "${green} GIT_BRANCH_NAME : ${GIT_BRANCH_NAME} ${NC}"
echo -e "${green} GIT_BRANCH : ${GIT_BRANCH} ${NC}"
echo -e "${green} GIT_COMMIT : ${GIT_COMMIT} ${NC}"

# shellcheck disable=SC2154
echo -e "${magenta} ${underline}PARAMETERS ${NC}"

case "$OSTYPE" in
  linux*)   SYSTEM=LINUX;;
  darwin*)  SYSTEM=OSX;;
  win*)     SYSTEM=Windows;;
  cygwin*)  SYSTEM=Cygwin;;
  msys*)    SYSTEM=MSYS;;
  bsd*)     SYSTEM=BSD;;
  solaris*) SYSTEM=SOLARIS;;
  *)        SYSTEM=UNKNOWN;;
esac
echo "SYSTEM : ${SYSTEM}"

if [ -f /etc/os-release ]; then
    # freedesktop.org and systemd
    . /etc/os-release
    OS=$NAME
    VER=$VERSION_ID
elif type lsb_release >/dev/null 2>&1; then
    # linuxbase.org
    OS=$(lsb_release -si)
    VER=$(lsb_release -sr)
elif [ -f /etc/lsb-release ]; then
    # For some versions of Debian/Ubuntu without lsb_release command
    . /etc/lsb-release
    OS=$DISTRIB_ID
    VER=$DISTRIB_RELEASE
elif [ -f /etc/debian_version ]; then
    # Older Debian/Ubuntu/etc.
    OS=Debian
    VER=$(cat /etc/debian_version)
elif [ -f /etc/SuSe-release ]; then
    # Older SuSE/etc.
    ...
elif [ -f /etc/redhat-release ]; then
    # Older Red Hat, CentOS, etc.
    ...
else
    # Fall back to uname, e.g. "Linux <version>", also works for BSD, etc.
    OS=$(uname -s)
    VER=$(uname -r)
fi
echo "OS : ${OS}"
echo "VER : ${VER}"

#DRY_RUN is used on UAT in order to avoid TAGING or DEPLOYING to production
if [ -n "${DRY_RUN}" ]; then
  # shellcheck disable=SC2154
  echo -e "${green} DRY_RUN is defined ${happy_smiley} : ${DRY_RUN} ${NC}"
else
  # shellcheck disable=SC2154
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : DRY_RUN, please override ${NC}"
fi

if [ -z "$PATH" ]; then
  if [ "$(uname -s)" == "SunOS" ]; then
    echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : PATH, use default one ${NC}"
    #Please do not enable NFS share on build server.
    #In case of NFS share issue we will not be able to perform an HF
    #/opt/SUNWspro/bin
    #mount
    #PATH=/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/ccs/bin:${SUNSTUDIO_HOME}/bin:/usr/sfw/bin:/opt/csw/bin; export PATH
    exit 1
  fi
fi

if [ -z "$TMPDIR" ]; then
    TMPDIR="/var/tmp/"
    export TMPDIR
fi

if [ -z "$SUNSTUDIO_HOME" ]; then
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SUNSTUDIO_HOME, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    #SUNSTUDIO_HOME="/opt/solarisstudio12.3"
    #SUNSTUDIO_HOME="/rms/sunpro/sun-studio-12/SUNWspro"
    SUNSTUDIO_HOME="/opt/SUNWspro"
    export SUNSTUDIO_HOME
  fi
fi

if [ "$(uname -s)" == "SunOS" ]; then
  PATH=/opt/csw/bin:/usr/local/bin:/usr/sbin:/usr/bin:/bin:/usr/ccs/bin:/usr/sfw/bin
  if [[ -d ${SUNSTUDIO_HOME} ]]; then
    PATH=${SUNSTUDIO_HOME}/bin:${PATH}
  fi
  export PATH
elif [ "$(uname -s)" == "Linux" ]; then
  #For RedHat add /usr/sbin
  PATH=${PATH}:/usr/sbin;
  export PATH
fi

if [ -z "$WORKSPACE" ]; then
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : WORKSPACE ${NC}"
  exit 1
fi

#if [ -n "${GIT_BRANCH_NAME}" ]; then
#  echo -e "${green} GIT_BRANCH_NAME is defined ${happy_smiley} ${NC}"
#else
#  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : GIT_BRANCH_NAME, use the default one ${NC}"
#  export GIT_BRANCH_NAME="develop"
#fi

if [ -n "${WORKSPACE_SUFFIX}" ]; then
  echo -e "${green} WORKSPACE_SUFFIX is defined ${happy_smiley} : ${WORKSPACE_SUFFIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : WORKSPACE_SUFFIX, use default one ${NC}"
  export WORKSPACE_SUFFIX="CMR"
fi

if [ -n "${ARCH}" ]; then
  echo -e "${green} ARCH is defined ${happy_smiley} : ${ARCH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ARCH, use default one ${NC}"

  if [ "$(uname -s)" == "SunOS" ]; then
    case $(uname -m) in
    sun4v)
        ARCH=sun4sol
        ;;
    i*86*)
        ARCH=x86sol
        ;;
    *)
        # leave ARCH as-is
        ;;
    esac
  elif [ "$(uname -s)" == "Linux" ]; then
    case $(uname -m) in
    x86_64)
        ARCH=linux  # or AMD64 or Intel64 or whatever
        ;;
    i*86)
        ARCH=x86Linux  # or IA32 or Intel32 or whatever
        ;;
    *)
        # leave ARCH as-is
        ;;
    esac
  elif [ "$(uname -s)" == "FreeBSD" ]; then
    case $(uname -m) in
    amd64)
        ARCH=freebsd  # or AMD64 or Intel64 or whatever
        ;;
    *)
        # leave ARCH as-is
        ;;
    esac
  else
    ARCH="$(uname -m)"
  fi
  export ARCH
fi

if [ -n "${CC}" ]; then
  echo -e "${green} CC is defined ${happy_smiley} : ${CC} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CC, use default one ${NC}"
  if [ -n "${ENABLE_CLANG}" ]; then
    echo -e "${green} ENABLE_CLANG is defined ${happy_smiley} ${NC}"
    export CC="/usr/bin/clang"
  else
    echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ENABLE_CLANG, use default one ${NC}"
    if [ "$(uname -s)" == "SunOS" ]; then
      export CC="cc"
    elif [ "$(uname -s)" == "Linux" ]; then
      export CC="/usr/bin/gcc-6"
    else
      export CC="/usr/bin/gcc"
    fi
  fi
fi

if [ -n "${CXX}" ]; then
  echo -e "${green} COMPILER is defined ${happy_smiley} : ${CXX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CXX, use default one ${NC}"
  if [ -n "${ENABLE_CLANG}" ]; then
    echo -e "${green} ENABLE_CLANG is defined ${happy_smiley} ${NC}"
    export CXX="/usr/bin/clang++"
    export COMPILER=${CXX}
  else
    echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ENABLE_CLANG, use default one ${NC}"
    if [ "$(uname -s)" == "SunOS" ]; then
      export CXX="CC"
    elif [ "$(uname -s)" == "Linux" ]; then
      export CXX="/usr/bin/g++-6"
    else
      export CXX="/usr/bin/g++"
    fi
    export COMPILER=${CXX}
  fi
fi

if [ -n "${BITS}" ]; then
  echo -e "${green} BITS is defined ${happy_smiley} : ${BITS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : BITS, use default one ${NC}"
  case $(uname -m) in
  x86_64)
      BITS=64
      ;;
  i*86)
      BITS=32
      ;;
  *)
      BITS="?"
      ;;
  esac
  export BITS
  #echo -e "${yellow} Override BITS ${BITS} upon you choice ${NC}"
fi

if [ -n "${COMPILER}" ]; then
  echo -e "${green} COMPILER is defined ${happy_smiley} : ${COMPILER} ${CC} ${CXX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : COMPILER, use default one ${NC}"
fi

if [ -n "${ANSIBLE_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMD is defined ${happy_smiley} : ${ANSIBLE_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ANSIBLE_CMD, use the default one ${NC}"
  export ANSIBLE_CMD="/usr/local/bin/ansible"
fi

if [ -n "${ANSIBLE_CMBD_CMD}" ]; then
  echo -e "${green} ANSIBLE_CMBD_CMD is defined ${happy_smiley} : ${ANSIBLE_CMBD_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ANSIBLE_CMBD_CMD, use the default one ${NC}"
  export ANSIBLE_CMBD_CMD="/usr/local/bin/ansible-cmdb"
fi

if [ -n "${ANSIBLE_GALAXY_CMD}" ]; then
  echo -e "${green} ANSIBLE_GALAXY_CMD is defined ${happy_smiley} : ${ANSIBLE_GALAXY_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ANSIBLE_GALAXY_CMD, use the default one ${NC}"
  export ANSIBLE_GALAXY_CMD="/usr/local/bin/ansible-galaxy"
fi

if [ -n "${ANSIBLE_PLAYBOOK_CMD}" ]; then
  echo -e "${green} ANSIBLE_PLAYBOOK_CMD is defined ${happy_smiley} : ${ANSIBLE_PLAYBOOK_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ANSIBLE_PLAYBOOK_CMD, use the default one ${NC}"
  export ANSIBLE_PLAYBOOK_CMD="/usr/local/bin/ansible-playbook"
fi

if [ -n "${SONAR_PROCESSOR}" ]; then
  echo -e "${green} SONAR_PROCESSOR is defined ${happy_smiley} : ${SONAR_PROCESSOR} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SONAR_PROCESSOR, use default one ${NC}"
  SONAR_PROCESSOR=$(uname -m | sed -r 's/_+/-/g')
  if [ "$(uname -s)" == "Linux" ]; then
    case $(uname -m) in
    x86_64)
        SONAR_PROCESSOR=x86-64  # or AMD64 or Intel64 or whatever
        ;;
    i*86)
        SONAR_PROCESSOR=x86-32  # or IA32 or Intel32 or whatever
        ;;
    *)
        # leave ARCH as-is
        ;;
    esac
  fi
  export SONAR_PROCESSOR
fi

if [ -n "${SONAR_CMD}" ]; then
  echo -e "${green} SONAR_CMD is defined ${happy_smiley} : ${SONAR_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SONAR_CMD, use default one ${NC}"
  echo -e "${magenta} ${double_arrow} ${HOME}/build-wrapper-linux-x86/build-wrapper-linux-${SONAR_PROCESSOR} ? ${NC}"
  if [ -f "${HOME}/build-wrapper-linux-x86/build-wrapper-linux-${SONAR_PROCESSOR}" ]; then
    SONAR_CMD="${HOME}/build-wrapper-linux-x86/build-wrapper-linux-${SONAR_PROCESSOR} --out-dir ${WORKSPACE}/bw-outputs/"
  fi
  export SONAR_CMD
  echo -e "${cyan} ${double_arrow} ${SONAR_CMD} ${NC}"
fi

if [ -n "${MAKE}" ]; then
  echo -e "${green} MAKE is defined ${happy_smiley} : ${MAKE} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : MAKE, use default one ${NC}"
  if [ "$(uname -s)" == "Linux" ]; then
    MAKE="colormake"
  else
    MAKE="make"
  fi
  export MAKE
fi

if [ -n "${SCONS}" ]; then
  echo -e "${green} SCONS is defined ${happy_smiley} : ${SCONS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SCONS, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    SCONS="/usr/local/bin/scons"
  elif [ "$(uname -s)" == "Darwin" ]; then
    SCONS="/usr/local/bin/scons"
  else
    SCONS="/usr/bin/python2.7 /usr/bin/scons"
  fi
  export SCONS
fi

if [ -n "${SCONS_OPTS}" ]; then
  echo -e "${green} SCONS_OPTS is defined ${happy_smiley} : ${SCONS_OPTS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SCONS_OPTS, use default one ${NC}"

  if [ "$(uname -s)" == "SunOS" ]; then
    SCONS_OPTS="-j8 opt=True"
  elif [ "$(uname -s)" == "Linux" ]; then
    SCONS_OPTS="-j32 opt=True"
  else
    SCONS_OPTS="-j8 --cache-disable gcc_version=4.1.2 opt=True"
  fi
  #-j32 --cache-disable gcc_version=4.8.5 opt=True
  #--debug=time,explain
  #count, duplicate, explain, findlibs, includes, memoizer, memory, objects, pdb, prepare, presub, stacktrace, time
  export SCONS_OPTS
fi

if [ -n "${GIT_CMD}" ]; then
  echo -e "${green} GIT_CMD is defined ${happy_smiley} : ${GIT_CMD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : GIT_CMD, use the default one ${NC}"
  GIT_CMD="/usr/bin/git"
  if [ "$(uname -s)" == "SunOS" ]; then
    GIT_CMD="/usr/local/bin/git"
  fi
  export GIT_CMD
fi

if [ -n "${GIT_AUTHOR_EMAIL}" -o "${GIT_AUTHOR_EMAIL}" != "null" ]; then
  echo -e "${green} GIT_AUTHOR_EMAIL is defined ${happy_smiley} : ${GIT_AUTHOR_EMAIL} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : GIT_AUTHOR_EMAIL, use the default one ${NC}"
  GIT_AUTHOR_EMAIL="alban.andrieu@free.fr"
  export GIT_AUTHOR_EMAIL
fi

if [ -n "${SONAR_BRANCH}" -o "${SONAR_BRANCH}" == "null" ]; then
  echo -e "${green} SONAR_BRANCH is defined ${happy_smiley} : ${SONAR_BRANCH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SONAR_BRANCH, use the default one ${NC}"
  SONAR_BRANCH="master"
  export SONAR_BRANCH
fi

if [ -n "${TAR}" ]; then
  echo -e "${green} TAR is defined ${happy_smiley} : ${TAR} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TAR, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    TAR="/usr/sfw/bin/gtar"
  elif [ "$(uname -s)" == "Darwin" ]; then
    TAR="/opt/local/bin/gnutar"
  elif [ "$(uname -s)" == "FreeBSD" ]; then
    TAR="/usr/bin/tar"
  elif [ "$(uname -s)" == "Linux" ]; then
    TAR="tar"
  elif [ "$(uname -s | cut -c 1-7)" == "MSYS_NT" ]; then
    TAR="zip"
  else
    TAR="7z"
  fi
  export TAR
fi

if [ -n "${WGET}" ]; then
  echo -e "${green} WGET is defined ${happy_smiley} : ${WGET} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : WGET, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    WGET="/opt/csw/bin/wget"
    #/usr/sfw/bin/wget
  elif [ "$(uname -s)" == "Darwin" ]; then
    WGET="/opt/local/bin/wget"
  elif [ "$(uname -s)" == "Linux" ]; then
    WGET="wget"
  elif [ "$(uname -s | cut -c 1-7)" == "MSYS_NT" ]; then
    WGET="wget"
  else
    WGET="wget"
  fi
  export WGET
fi

if [ -n "${WGET_OPTIONS}" ]; then
  echo -e "${green} WGET_OPTIONS is defined ${happy_smiley} : ${WGET_OPTIONS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : WGET_OPTIONS, use default one ${NC}"
  WGET_OPTIONS="--no-check-certificate"
  export WGET_OPTIONS
fi

if [ -n "${CURL}" ]; then
  echo -e "${green} CURL is defined ${happy_smiley} : ${CURL} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CURL, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    WGET="/usr/local/bin/curl"
  elif [ "$(uname -s)" == "Darwin" ]; then
    WGET="/opt/local/bin/curl"
  elif [ "$(uname -s)" == "Linux" ]; then
    WGET="/usr/bin/curl"
  elif [ "$(uname -s | cut -c 1-7)" == "MSYS_NT" ]; then
    WGET="curl"
  else
    WGET="curl"
  fi
  export CURL
fi

if [ -n "${CURL_OPTIONS}" ]; then
  echo -e "${green} CURL_OPTIONS is defined ${happy_smiley} : ${CURL_OPTIONS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CURL_OPTIONS, use default one ${NC}"
  CURL_OPTIONS="-k"
  export CURL_OPTIONS
fi

if [ -n "${MD5SUM}" ]; then
  echo -e "${green} MD5SUM is defined ${happy_smiley} : ${MD5SUM} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : MD5SUM, use default one ${NC}"
  if [ "$(uname -s)" == "SunOS" ]; then
    MD5SUM="/usr/bin/digest -a md5"
  elif [ "$(uname -s)" == "Darwin" ]; then
    MD5SUM="/usr/local/bin/md5sum"
  elif [ "$(uname -s)" == "Linux" ]; then
    MD5SUM="md5sum"
  elif [ "$(uname -s | cut -c 1-7)" == "MSYS_NT" ]; then
    MD5SUM="md5sum"
  else
    MD5SUM="md5sum"
  fi
  export MD5SUM
fi

if [ -n "${TIBCO_HOME}" ]; then
  echo -e "${green} TIBCO_HOME is defined ${happy_smiley} : ${TIBCO_HOME} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TIBCO_HOME, use default one ${NC}"
  if [ "$(uname -s)" == "Linux" ]; then
    TIBCO_HOME="/opt/tibco"
  else
    TIBCO_HOME=""
  fi
  export TIBCO_HOME
fi

if [ -n "${TIBRV_VERSION}" ]; then
  echo -e "${green} TIBRV_VERSION is defined ${happy_smiley} : ${TIBRV_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TIBRV_VERSION, use default one ${NC}"
  TIBRV_VERSION="8.4"
  export TIBRV_VERSION
fi

if [ -n "${TIBRV_HOME}" ]; then
  echo -e "${green} TIBRV_HOME is defined ${happy_smiley} : ${TIBRV_HOME} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TIBRV_HOME, use default one ${NC}"
  if [ "$(uname -s)" == "Linux" ]; then
    TIBRV_HOME="${TIBCO_HOME}/tibrv/${TIBRV_VERSION}"
  else
    TIBRV_HOME=""
  fi
  export TIBRV_HOME
fi

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$TIBRV_HOME/lib

#========================================= JAVA

if [ -n "${JAVA_SSL_OPTS}" ]; then
  echo -e "${green} JAVA_SSL_OPTS is defined ${happy_smiley} : ${JAVA_SSL_OPTS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : JAVA_SSL_OPTS, please override ${NC}"
  #JAVA_SSL_OPTS="-Djavax.net.ssl.trustStore=/usr/local/share/ca-certificates/ca.crt"
  #export JAVA_SSL_OPTS
fi

if [ -n "${JAVA_TOOL_OPTIONS}" ]; then
  echo -e "${green} JAVA_TOOL_OPTIONS is defined ${happy_smiley} : ${JAVA_TOOL_OPTIONS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : JAVA_TOOL_OPTIONS, please override ${NC}"
  #JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"
  #export JAVA_TOOL_OPTIONS
fi

if [ -n "${JAVA_HOME}" ]; then
  echo -e "${green} JAVA_HOME is defined ${happy_smiley} : ${JAVA_HOME} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : JAVA_HOME, use the default one ${NC}"
  JAVA_HOME="/usr"
  if [ "$(uname -s)" == "SunOS" ]; then
    JAVA_HOME="/usr/jdk/instances/jdk1.8.0_131"
  elif [ "$(uname -s)" == "Darwin" ]; then
    JAVA_HOME=""
  fi
  if [[ -d /dpool/jdk ]]; then
    JAVA_HOME="/dpool/jdk"
  fi
  if [[ -d /usr/lib/jvm/java-8-oracle ]]; then
    JAVA_HOME="/usr/lib/jvm/java-8-oracle"
  fi
  export JAVA_HOME
fi

if [ "$(uname -s)" == "SunOS" ]; then
  PATH=$JAVA_HOME/bin:$PATH;
  export PATH
fi

if [ -n "${MAVEN_PATH}" ]; then
  echo -e "${green} MAVEN_PATH is defined ${happy_smiley} : ${MAVEN_PATH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : MAVEN_PATH, use the default one ${NC}"
  MAVEN_PATH="/usr/local/apache-maven-3.2.1"
  export MAVEN_PATH
fi

if [ -n "${MAVEN_OPTS}" ]; then
  echo -e "${green} MAVEN_OPTS is defined ${happy_smiley} : ${MAVEN_OPTS} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : MAVEN_OPTS, use the default one ${NC}"
  #MAVEN_OPTS="-XX:MaxPermSize=512m"
  MAVEN_OPTS="-d64 -Xmx3072m -Djava.awt.headless=true -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -Dsun.zip.disableMemoryMapping=true -Djava.io.tmpdir=${WORKSPACE}/target/tmp"
  export MAVEN_OPTS
fi

#export PATH="${JAVA_HOME}/bin:/usr/kerberos/bin:/usr/local/bin:/bin:/usr/bin:/usr/X11R6/bin:/kgr/dev/kgr_maven/nexus/bin/jsw/linux-x86-64:/kgr-mvn/hudson/etc/init.d:/home/kgr_mvn/bin"
export M2_HOME=""

if [ -n "${RELEASE_VERSION}" ]; then
  echo -e "${green} RELEASE_VERSION is defined ${happy_smiley} : ${RELEASE_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : RELEASE_VERSION, use the default one ${NC}"
  RELEASE_VERSION="1.0.0"
  export RELEASE_VERSION
fi

if [ -n "${MVN_RELEASE_VERSION}" ]; then
  echo -e "${green} MVN_RELEASE_VERSION is defined ${happy_smiley} : ${MVN_RELEASE_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : MVN_RELEASE_VERSION, use the default one ${NC}"
  MVN_RELEASE_VERSION=${RELEASE_VERSION}
  export MVN_RELEASE_VERSION
fi

if [ -n "${HTTP_PROTOCOL}" ]; then
  echo -e "${green} HTTP_PROTOCOL is defined ${happy_smiley} : ${HTTP_PROTOCOL} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : HTTP_PROTOCOL, use the default one ${NC}"
  export HTTP_PROTOCOL="https://"
fi

if [ -n "${TARGET_PROJECT}" ]; then
  echo -e "${green} TARGET_PROJECT is defined ${happy_smiley} : ${TARGET_PROJECT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_PROJECT, use the default one ${NC}"
  TARGET_PROJECT="${JOB_NAME}"
  export TARGET_PROJECT
fi

if [ -n "${TARGET_TAG}" ]; then
  echo -e "${green} TARGET_TAG is defined ${happy_smiley} ; ${TARGET_TAG} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_TAG, use the default one ${NC}"
  export TARGET_TAG="LATEST_SUCCESSFULL"
  #export TARGET_TAG="1.7.0.0_1"
fi

if [ -n "${TARGET_USER}" ]; then
  echo -e "${green} TARGET_USER is defined ${happy_smiley} : ${TARGET_USER} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_USER, use the default one ${NC}"
  export TARGET_USER="jenkins"
fi

if [ -n "${TARGET_SERVER}" ]; then
  echo -e "${green} TARGET_SERVER is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_SERVER, use the default one ${NC}"
  export TARGET_SERVER=nabla.freeboxos.fr
fi

if [ -n "${TARGET_PORT}" ]; then
  echo -e "${green} TARGET_PORT is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_PORT, use the default one ${NC}"
  export TARGET_PORT=8280
fi

if [ -n "${TARGET_URL}" ]; then
  echo -e "${green} TARGET_URL is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TARGET_URL, use the default one ${NC}"
  export TARGET_URL="visma/"
fi

if [ -n "${SERVER_HOST}" ]; then
  echo -e "${green} SERVER_HOST is defined ${happy_smiley} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SERVER_HOST, use the default one ${NC}"
  SERVER_HOST="albandri"
  export SERVER_HOST
fi

if [ -n "${SERVER_CONTEXT}" ]; then
  echo -e "${green} SERVER_URL is defined ${happy_smiley} : ${SERVER_CONTEXT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SERVER_CONTEXT, use the default one ${NC}"
  SERVER_CONTEXT="/test"
  export SERVER_CONTEXT
fi

if [ -n "${SERVER_URL}" ]; then
  echo -e "${green} SERVER_URL is defined ${happy_smiley} : ${SERVER_URL} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : SERVER_URL, use the default one ${NC}"
  SERVER_URL=${HTTP_PROTOCOL}${SERVER_HOST}${SERVER_CONTEXT}
  export SERVER_URL
fi

if [ -n "${ZAP_PORT}" ]; then
  echo -e "${green} ZAP_PORT is defined ${happy_smiley} : ${ZAP_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ZAP_PORT, use the default one ${NC}"
  ZAP_PORT=8090
  export ZAP_PORT
fi

if [ -n "${JBOSS_PORT}" ]; then
  echo -e "${green} JBOSS_PORT is defined ${happy_smiley} : ${JBOSS_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : JBOSS_PORT, use the default one ${NC}"
  JBOSS_PORT=8180
  export TOMCAT_PORT
fi

if [ -n "${TOMCAT_PORT}" ]; then
  echo -e "${green} TOMCAT_PORT is defined ${happy_smiley} : ${TOMCAT_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TOMCAT_PORT, use the default one ${NC}"
  TOMCAT_PORT=8280
  export TOMCAT_PORT
fi

if [ -n "${JETTY_PORT}" ]; then
  echo -e "${green} JETTY_PORT is defined ${happy_smiley} : ${JETTY_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : JETTY_PORT, use the default one ${NC}"
  JETTY_PORT=9090
  export JETTY_PORT
fi

if [ -n "${CARGO_RMI_PORT}" ]; then
  echo -e "${green} CARGO_RMI_PORT is defined ${happy_smiley} : ${CARGO_RMI_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_RMI_PORT, use the default one ${NC}"
  CARGO_RMI_PORT=44447
  export CARGO_RMI_PORT
fi

if [ -n "${CARGO_RMI_REGISTRY_PORT}" ]; then
  echo -e "${green} CARGO_RMI_REGISTRY_PORT is defined ${happy_smiley} : ${CARGO_RMI_REGISTRY_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_RMI_REGISTRY_PORT, use the default one ${NC}"
  CARGO_RMI_REGISTRY_PORT=1099
  export CARGO_RMI_REGISTRY_PORT
fi

if [ -n "${CARGO_HTTP_PORT}" ]; then
  echo -e "${green} CARGO_HTTP_PORT is defined ${happy_smiley} : ${CARGO_HTTP_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_HTTP_PORT, use the default one ${NC}"
  CARGO_HTTP_PORT=8181
  export CARGO_HTTP_PORT
fi

if [ -n "${CARGO_TELNET_PORT}" ]; then
  echo -e "${green} CARGO_TELNET_PORT is defined ${happy_smiley} : ${CARGO_TELNET_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_TELNET_PORT, use the default one ${NC}"
  CARGO_TELNET_PORT=8001
  export CARGO_TELNET_PORT
fi

if [ -n "${CARGO_SSH_PORT}" ]; then
  echo -e "${green} CARGO_SSH_PORT is defined ${happy_smiley} : ${CARGO_SSH_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_SSH_PORT, use the default one ${NC}"
  CARGO_SSH_PORT=8444
  export CARGO_SSH_PORT
fi

if [ -n "${CARGO_AJP_PORT}" ]; then
  echo -e "${green} CARGO_AJP_PORT is defined ${happy_smiley} : ${CARGO_AJP_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_AJP_PORT, use the default one ${NC}"
  CARGO_AJP_PORT=9009
  export CARGO_AJP_PORT
fi

if [ -n "${ECLIPSE_DEBUG_PORT}" ]; then
  echo -e "${green} ECLIPSE_DEBUG_PORT is defined ${happy_smiley} : ${ECLIPSE_DEBUG_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ECLIPSE_DEBUG_PORT, use the default one ${NC}"
  ECLIPSE_DEBUG_PORT=2924
  export ECLIPSE_DEBUG_PORT
fi

if [ -n "${CARGO_DEBUG_PORT}" ]; then
  echo -e "${green} CARGO_DEBUG_PORT is defined ${happy_smiley} : ${CARGO_DEBUG_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : CARGO_DEBUG_PORT, use the default one ${NC}"
  CARGO_DEBUG_PORT=5005
  export CARGO_DEBUG_PORT
fi

if [ -n "${REDIS_PORT}" ]; then
  echo -e "${green} REDIS_PORT is defined ${happy_smiley} : ${REDIS_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : REDIS_PORT, use the default one ${NC}"
  REDIS_PORT=6379
  export REDIS_PORT
fi

if [ -n "${H2_PORT}" ]; then
  echo -e "${green} H2_PORT is defined ${happy_smiley} : ${H2_PORT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : H2_PORT, use the default one ${NC}"
  H2_PORT=5055
  export H2_PORT
fi

#========================================= ALM

if [ -n "${PLATFORM}" ]; then
  echo -e "${green} PLATFORM is defined ${happy_smiley} : ${PLATFORM} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : PLATFORM, use the default one ${NC}"
  PLATFORM=linux
  export PLATFORM
fi

if [ -n "${AF_ARCH}" ]; then
  echo -e "${green} AF_ARCH is defined ${happy_smiley} : ${AF_ARCH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_ARCH, use the default one ${NC}"
  AF_ARCH="x86_64"
  export AF_ARCH
fi

if [ -n "${TRIPLET}" ]; then
  echo -e "${green} TRIPLET is defined ${happy_smiley} : ${TRIPLET} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : TRIPLET, use the default one ${NC}"
  TRIPLET=${AF_ARCH}-linux-ubuntu
  export TRIPLET
fi

if [ -n "${AF_VERSION}" ]; then
  echo -e "${green} AF_VERSION is defined ${happy_smiley} : ${AF_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_VERSION, use the default one ${NC}"
  AF_VERSION=1.4.0
  export AF_VERSION
fi

if [ -n "${AF_BRANCH}" ]; then
  echo -e "${green} AF_BRANCH is defined ${happy_smiley} : ${AF_BRANCH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_BRANCH, use the default one ${NC}"
  AF_BRANCH=trunk
  #AF_BRANCH=develop
  export AF_BRANCH
fi

# --- We change the root of the AlmondeFactory to the Jenkins one.
if [ -n "${AF_LOCAL_FACTORY_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_FACTORY_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_FACTORY_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_FACTORY_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_FACTORY_DIR_UNIX=${WORKSPACE}
  export AF_LOCAL_FACTORY_DIR_UNIX
fi

if [ -n "${AF_LOCAL_ALF_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_ALF_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_ALF_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_ALF_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_ALF_DIR_UNIX=$WORKSPACE/FactoryResources
  export AF_LOCAL_ALF_DIR_UNIX
fi

if [ -n "${AF_GNUSTEP_VERSION}" ]; then
  echo -e "${green} AF_GNUSTEP_VERSION is defined ${happy_smiley} : ${AF_GNUSTEP_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_GNUSTEP_VERSION, use the default one ${NC}"
  AF_GNUSTEP_VERSION=1.24.6
  export AF_GNUSTEP_VERSION
fi

if [ -n "${AF_PYTHON_VERSION}" ]; then
  echo -e "${green} AF_PYTHON_VERSION is defined ${happy_smiley} : ${AF_PYTHON_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_PYTHON_VERSION, use the default one ${NC}"
  AF_PYTHON_VERSION=2.5.1
  export AF_PYTHON_VERSION
fi

if [ -n "${AF_RHEL_CLANG_VERSION}" ]; then
  echo -e "${green} AF_RHEL_CLANG_VERSION is defined ${happy_smiley} : ${AF_RHEL_CLANG_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_RHEL_CLANG_VERSION, use the default one ${NC}"
  AF_RHEL_CLANG_VERSION=3.4.0
  export AF_RHEL_CLANG_VERSION
fi

if [ -n "${AF_MINGW_VERSION}" ]; then
  echo -e "${green} AF_MINGW_VERSION is defined ${happy_smiley} : ${AF_MINGW_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_MINGW_VERSION, use the default one ${NC}"
  AF_MINGW_VERSION=5.1.3
  export AF_MINGW_VERSION
fi

if [ -n "${AF_SCONS_VERSION}" ]; then
  echo -e "${green} AF_SCONS_VERSION is defined ${happy_smiley} : ${AF_SCONS_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_SCONS_VERSION, use the default one ${NC}"
  AF_SCONS_VERSION=2.0.1
  export AF_SCONS_VERSION
fi

if [ -n "${AF_BISON_VERSION}" ]; then
  echo -e "${green} AF_BISON_VERSION is defined ${happy_smiley} : ${AF_BISON_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_BISON_VERSION, use the default one ${NC}"
  AF_BISON_VERSION=2.3-MSYS-1.0.11
  export AF_BISON_VERSION
fi

if [ -n "${AF_MSYS_VERSION}" ]; then
  echo -e "${green} AF_MSYS_VERSION is defined ${happy_smiley} : ${AF_MSYS_VERSION} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_MSYS_VERSION, use the default one ${NC}"
  AF_MSYS_VERSION=1.0.10
  export AF_MSYS_VERSION
fi

if [ -n "${AF_LOCAL_GNUSTEP_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_GNUSTEP_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_GNUSTEP_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_GNUSTEP_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_GNUSTEP_DIR_UNIX=$AF_LOCAL_RESOURCES_DIR_UNIX/GNUstep/GNUstep-$AF_GNUSTEP_VERSION-x86_64-linux-rhel7
  export AF_LOCAL_GNUSTEP_DIR_UNIX
fi

if [ -n "${AF_LOCAL_MINGW_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_MINGW_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_MINGW_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_MINGW_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_MINGW_DIR_UNIX=$AF_LOCAL_RESOURCES_DIR_UNIX/MinGW/mingw-5.1.3
  export AF_LOCAL_MINGW_DIR_UNIX
fi

if [ -n "${AF_LOCAL_PYTHON_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_PYTHON_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_PYTHON_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_PYTHON_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_PYTHON_DIR_UNIX=$AF_LOCAL_RESOURCES_DIR_UNIX/Python/Python-2.5.1
  export AF_LOCAL_PYTHON_DIR_UNIX
fi

if [ -n "${AF_LOCAL_MSYS_DIR_UNIX}" ]; then
  echo -e "${green} AF_LOCAL_MSYS_DIR_UNIX is defined ${happy_smiley} : ${AF_LOCAL_MSYS_DIR_UNIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_LOCAL_MSYS_DIR_UNIX, use the default one ${NC}"
  AF_LOCAL_MSYS_DIR_UNIX=$AF_LOCAL_RESOURCES_DIR_UNIX/MSYS/msys-1.0.10
  export AF_LOCAL_MSYS_DIR_UNIX
fi

if [ -n "${AF_REMOTE_SVN_PREFIX_URL}" ]; then
  echo -e "${green} AF_REMOTE_SVN_PREFIX_URL is defined ${happy_smiley} : ${AF_REMOTE_SVN_PREFIX_URL} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_REMOTE_SVN_PREFIX_URL, use the default one ${NC}"
  AF_REMOTE_SVN_PREFIX_URL=http://par-castor/svn/repos/almonde
  export AF_REMOTE_SVN_PREFIX_URL
fi

if [ -n "${AF_BUILD_DEBUG}" ]; then
  echo -e "${green} AF_BUILD_DEBUG is defined ${happy_smiley} : ${AF_BUILD_DEBUG} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_BUILD_DEBUG, use the default one ${NC}"
  #Force building debug mode
  AF_BUILD_DEBUG="skip"
  #AF_BUILD_DEBUG="windows debug"
  export AF_BUILD_DEBUG
fi

if [ -n "${AF_BUILD}" ]; then
  echo -e "${green} AF_BUILD is defined ${happy_smiley} : ${AF_BUILD} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_BUILD, use the default one ${NC}"
  #AF_BUILD="skip"
  #coverage client
  #windows release client ide
  #windows debug
  #debug
  AF_BUILD="coverage client"
  export AF_BUILD
fi

if [ -n "${AF_PACKAGE}" ]; then
  echo -e "${green} AF_PACKAGE is defined ${happy_smiley} : ${AF_PACKAGE} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_PACKAGE, use the default one ${NC}"
  #nobuildasrelease
  #nobuildasdebug
  AF_PACKAGE="noupdate nobuildasrelease removeOldBuilds"
  export AF_PACKAGE
fi

if [ -n "${AF_PACKAGE_DEBUG}" ]; then
  echo -e "${green} AF_PACKAGE_DEBUG is defined ${happy_smiley} : ${AF_PACKAGE_DEBUG} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : AF_PACKAGE_DEBUG, use the default one ${NC}"
  #nobuildasrelease
  #nobuildasdebug
  AF_PACKAGE_DEBUG="noupdate nobuildasdebug removeOldBuilds"
  export AF_PACKAGE_DEBUG
fi

if [ -n "${ALMTEST_ARCH}" ]; then
  echo -e "${green} ALMTEST_ARCH is defined ${happy_smiley} : ${ALMTEST_ARCH} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_ARCH, use the default one ${NC}"

  # _MinGW
  # _OSX
  # _RHEL
  # _RHEL7

  ALMTEST_ARCH="_MinGW"
  export ALMTEST_ARCH
fi

if [ -n "${ALMTEST_COV}" ]; then
  echo -e "${green} ALMTEST_COV is defined ${happy_smiley} : ${ALMTEST_COV} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_COV, use the default one ${NC}"
  ALMTEST_COV="skip"
  export ALMTEST_COV
fi

if [ -n "${ALMTEST_UT}" ]; then
  echo -e "${green} ALMTEST_UT is defined ${happy_smiley} : ${ALMTEST_UT} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_UT, use the default one ${NC}"
  ALMTEST_UT="skip"
  export ALMTEST_UT
fi

if [ -n "${ALMTEST_REDUCE}" ]; then
  echo -e "${green} ALMTEST_REDUCE is defined ${happy_smiley} : ${ALMTEST_REDUCE} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_REDUCE, use the default one ${NC}"
#  ALMTEST_REDUCE="_REDUCE"
  ALMTEST_REDUCE="_UT"
  export ALMTEST_REDUCE
fi

if [[ -n "${ALMTEST_DATABASE}" ]]; then
  echo -e "${green} ALMTEST_DATABASE is defined ${happy_smiley} : ${ALMTEST_DATABASE} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_DATABASE, use the default one ${NC}"

  # _Oracle
  # _SQLServer

  ALMTEST_DATABASE="_SQLServer"
  export ALMTEST_DATABASE
fi

if [ -n "${ALMTEST_SUFFIX}" ]; then
  echo -e "${green} ALMTEST_SUFFIX is defined ${happy_smiley} : ${ALMTEST_SUFFIX} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : ALMTEST_SUFFIX, use the default one ${NC}"
  ALMTEST_SUFFIX="_BM"
  export ALMTEST_SUFFIX
fi

if [ -n "${DATABASE_INSTANCE_RECREATE}" ]; then
  echo -e "${green} DATABASE_INSTANCE_RECREATE is defined ${happy_smiley} : ${DATABASE_INSTANCE_RECREATE} ${NC}"
else
  echo -e "${red} ${double_arrow} Undefined build parameter ${head_skull} : DATABASE_INSTANCE_RECREATE, use the default one ${NC}"
  #DATABASE_INSTANCE_RECREATE="--recreate-dbuser"
  DATABASE_INSTANCE_RECREATE=""
  export DATABASE_INSTANCE_RECREATE
fi

ENV_FILENAME="${WORKSPACE}/ENV_${ARCH}_VERSION.TXT"

echo -e "${NC}"

./step-2-0-1-build-env-info.sh > "${ENV_FILENAME}"

# shellcheck disable=SC2154
echo -e "${black} ${blink} DONE ${NC}"

#exit 0
