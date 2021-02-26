#!/bin/bash
set -xv

#See https://doc.ubuntu-fr.org/vim

#add vim features
cd ~
git clone https://github.com/klen/.vim.git ~/.vim
cd ~/.vim && git submodule init && git submodule update

exit 0
