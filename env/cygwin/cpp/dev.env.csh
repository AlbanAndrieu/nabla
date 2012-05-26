#!/bin/csh -f

#*
#*
#*    Central tools definition file.
#*
#*---------------------------------------------------------------------*/
#*    Initial path variables                                           */
#*---------------------------------------------------------------------*/
set lpath = (${path})

#*---------------------------------------------------------------------*/
#*    Record current tcsh settings if needed                           */
#*---------------------------------------------------------------------*/

# compiler selection
switch ( ${MACHINE} )
  case x86sol:
    set lpath=(/rms/sunpro/sun-studio-12.x86sol_2/SUNWspro/bin/ ${lpath})
  breaksw
  case sun4sol:
    set lpath=(/rms/sunpro/sun-studio-12/SUNWspro/bin ${lpath})
    alias nedit /rms/sunpro/sun-one-studio-8/C++patch04/SUNWspro/bin/nedit
    alias workshop /rms/sunpro/sun-studio-12/SUNWspro/prod/bin/sunstudio
  breaksw
  
  case x86Linux:
  breaksw
  
  case rs6000:
    setenv CORE_NAMING  true
    set lpath=(/opt/cpp-v10-xlccpp/2009-08.ptf/usr/vacpp/bin ${lpath})
  breaksw
endsw

set path = ( ${lpath}  )
unset lpath 

alias gm 'gmake -f Makefile.${ARCH}.opt'
alias gmw 'gm where'
alias run '`gmw`'
alias gmm 'perlgen -O && gm Makefiles'
alias gmin 'gm includes'
alias gmi 'gm install'
alias gmil 'gm install_libs'
alias gmc 'gm clean && gm remove_install'

alias gmd 'gmake -f Makefile.${ARCH}.debug'
alias gmdw 'gmd where'
alias rund '`gmdw`'
alias gmdm 'perlgen ${PERLGEN_OPTION} && gmd Makefiles'
alias gmdin 'gmd includes'
alias gmdi 'gmd install'
alias gmdil 'gmd install_libs'
alias gmdc 'gmd clean && gmd remove_install'

alias buildd '( ( gmdin \!* && gmdil \!* && gmdi \!* ) || echoFailed )'
alias rebuildd '( ( ( test ! -f "Makefile.${ARCH}.debug" || gmdc \!* ) && gmdm \!* && buildd \!* ) || echoFailed )'

alias build '( ( gmin \!* && gmil \!* && gmi \!* ) || echoFailed )'
alias rebuild '( ( ( test ! -f "Makefile.${ARCH}.opt" || gmc \!* ) && gmm \!* && build \!* ) || echoFailed )'
