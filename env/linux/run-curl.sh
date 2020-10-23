#!/bin/bash
set -xv

# See https://support.sonatype.com/hc/en-us/articles/115006744008-How-can-I-programmatically-upload-files-into-Nexus-3-

wget http://fr1cslfrbm0059.misys.global.ad/download/scons/scons-2.4.1.zip
curl -v -u user:token --upload-file scons-2.4.1.zip https://albandrieu.com/nexus/content/repositories/nabla/download/scons/scons-2.4.1.zip

Example if it was whole directory:
find download/elk/ -type f -exec curl -u user:token -v --ftp-create-dirs  -T {} https://albandrieu.com/nexus/content/repositories/nabla/{} \;

exit 0
