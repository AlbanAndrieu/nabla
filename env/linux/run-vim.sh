#!/bin/bash
set -xv

#add vim features
cd ~
git clone https://github.com/klen/.vim.git ~/.vim
cd ~/.vim && git submodule init && git submodule update
