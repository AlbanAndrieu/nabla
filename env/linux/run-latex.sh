#!/bin/bash
#set -xv

sudo apt-get install texlive-full

sudo apt-get install texlive texlive-latex-extra texlive-lang-french

sudo apt-get install texmaker

texmaker cv-aandrieu-02-07-2020.tex

pdflatex -synctex=1 -interaction=nonstopmode %.tex
#pdflatex cv-aandrieu-02-07-2020.tex

# See https://doc.ubuntu-fr.org/texstudio
sudo apt-get install texstudio
#sudo apt-get install latexila

exit 0
