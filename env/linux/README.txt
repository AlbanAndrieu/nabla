
'g++-3.4' is available from "hardy-updates"
http://packages.ubuntu.com/hardy-updates/g++-3.4

sudo dpkg -i \
cpp-3.4_3.4.6-6ubuntu5_i386.deb g++-3.4_3.4.6-6ubuntu5_i386.deb \
gcc-3.4_3.4.6-6ubuntu5_i386.deb gcc-3.4-base_3.4.6-6ubuntu5_i386.deb \
libstdc++6-dev_3.4.6-6ubuntu5_i386.deb

wget http://fr.archive.ubuntu.com/ubuntu/pool/main/g/gcc-4.4/libstdc++6_4.4.1-4ubuntu8_i386.deb
sudo dpkg -i libstdc*.deb
sudo apt-get install -f

see
/etc/davfs2/davfs2.conf

sudo \
  mount -t davfs \
    https://repository-nabla.forge.cloudbees.com/snapshot/ \
    /mnt/nabla-snapshot \
    -o conf=/etc/davfs2/davfs2.conf \
    -o uid=$UID

sudo \
  mount -t davfs \
    https://repository-nabla.forge.cloudbees.com/release/ \
    /mnt/nabla-release \
    -o conf=/etc/davfs2/davfs2.conf \
    -o uid=$UID

sudo \
  mount -t davfs \
    https://repository-nabla.forge.cloudbees.com/private/ \
    /mnt/nabla-private \
    -o conf=/etc/davfs2/davfs2.conf \
    -o uid=$UID

sudo mount /mnt/nabla-snapshot
sudo mount /mnt/nabla-release
sudo mount /mnt/nabla-private

use /private/nabla/settings.xml in jenkins alternate settings
