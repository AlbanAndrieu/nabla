#!/usr/bin/env python
# svn merge-tool python wrapper for meld
import os, sys
import subprocess
import shutil

try:
   # path to meld
   meld = "/usr/bin/meld"

   # file paths
   base   = sys.argv[-4]
   theirs = sys.argv[-3]
   mine   = sys.argv[-2]
   merged = sys.argv[-1]

   # Replace 'merged' file with a copy of 'mine'
   # (because we can't open 4 files)
   shutil.copy(mine, merged)

   # the call to meld
   # work right-to-left (result is far left file)
   cmd = [meld, merged, theirs, base]

   # Call meld, making sure it exits correctly
   subprocess.check_call(cmd)
except:
   print "Oh noes, an error!"
   sys.exit(-1)
