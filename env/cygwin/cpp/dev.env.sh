#!/bin/sh -f

#*
#*
#*    rtpplus central tools definition file.
#*
#*---------------------------------------------------------------------*/
#*    Initial path variables                                           */
#*---------------------------------------------------------------------*/

# compiler selection
case ${MACHINE} in
  sun4sol)
    export PATH=${PATH}:/rms/sunpro/sun-one-studio-8/C++patch04/SUNWspro/bin
  ;;
  
  x86Linux)
  ;;
  
  rs6000)
    export CORE_NAMING=true
      if [ ${HOSTNAME} = "ptxskplus19" ] 
      then
       export PATH=${PATH}:/opt/cpp-v6-vacpp/6.0.0.14/usr/vac/bin:/opt/cpp-v6-vacpp/6.0.0.14/usr/vacpp/bin
      fi
  ;;

  *)
  ;;

esac

# CMAKE_ROOT
#export CMAKE_ROOT=/cygdrive/c/users/cmake/cmake-2.6.3-Linux-i386/bin
#export CMAKE_HOME=/cygdrive/c/CMake-[[CMAKE_MAJOR_VERSION]]
export CMAKE_HOME=/cygdrive/c/cygwin/usr/share/cmake-2.6.4
export CMAKE_ROOT=${CMAKE_HOME}

# GMAKE
#export GMAKE_HOME="${TMPLDIR}/tools/${ARCH}"
#export PATH=$PATH:$GMAKE_HOME

#export IMAKEINCLUDE="-I${TMPLDIR}/tools/perl/${ARCH}.pl"
export IMAKEINCLUDE="-I${TMPLDIR}"
echo " TMPL is : ${IMAKEINCLUDE}/tools/perl/${ARCH}.pl"

alias gencmake="${KPLUSTP_DEV}/${KPLUSTP_EXTRACTION}/cmake/gencmake"
alias gm='gmake -f Makefile.${ARCH}.opt'
alias gmw='gm where'
alias run='`gmw`'
alias gmm='gm Makefiles'
alias gmin='gm includes'
alias gmi='gm install'
alias gmil='gm install_libs'
alias gmc="gm clean && gm remove_install"

alias gmd='gmake -f Makefile.${ARCH}.debug'
alias gmdw='gmd where'
alias rund='`gmdw`'
alias gmdm='gmd Makefiles'
alias gmdin='gmd includes'
alias gmdi='gmd install'
alias gmdil='gmd install_libs'
alias gmdc="gmd clean && gmd remove_install"

alias buildd='gmdin && gmdil && gmdi'
alias rebuildd='( test ! -f "Makefile.${ARCH}.debug" || gmdc ) && perlgen ${PERLGEN_OPTION} && gmdm && buildd'

alias build='gmin && gmil && gmi'
alias rebuild='( test ! -f "Makefile.${ARCH}.opt" || gmc ) && perlgen -O && gmm && build'

