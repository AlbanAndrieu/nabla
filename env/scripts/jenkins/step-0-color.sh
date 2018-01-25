#!/bin/bash
#set -xv

#OK Darwin Linux

export bold="\033[01m"
export underline="\033[04m"
export blink="\033[05m"

export black="\033[30m"
export red="\033[31m"
export green="\033[32m"
export yellow="\033[33m"
export blue="\033[34m"
export magenta="\033[35m"
export cyan="\033[36m"
export ltgray="\033[37m"

export NC="\033[0m"

if [ "$(uname -s)" == "Linux" ]; then
	#double_arrow='\u00BB'
	export double_arrow='\xC2\xBB'
	#head_skull='\u2620'
	export head_skull='\xE2\x98\xA0'
	#happy_smiley='\u263A'
	export happy_smiley='\xE2\x98\xBA'
	export nabla_logo='\xE2\x88\x87'
fi

#exit 0
