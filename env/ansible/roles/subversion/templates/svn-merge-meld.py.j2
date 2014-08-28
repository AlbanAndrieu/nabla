#!/usr/bin/env python
# svn merge-tool python wrapper for meld
import sys
import subprocess

# path to meld ($ which meld)
meld = "/usr/bin/meld"
log = False
f = open('/tmp/svn-merge-meld.log', 'a')

def main():
if log:
f.write("call: %r\n" % sys.argv)

# file paths
base   = sys.argv[1]
theirs = sys.argv[2]
mine   = sys.argv[3]
merged = sys.argv[4]
partial = sys.argv[5]

# the call to meld
cmd = [meld, mine, base, theirs, merged]

# Call meld, making sure it exits correctly
subprocess.check_call(cmd)

try:
main()
except Exception as e:
print "Oh noes, an error: %r" % e
if log:
 f.write("Error: %r\n" % e)
sys.exit(-1)
