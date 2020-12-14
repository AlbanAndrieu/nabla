#!/bin/bash
#set -xv

sudo apt-get install latexila

sudo apt-get install texlive-full

sudo apt-get install texlive texlive-latex-extra texlive-lang-french

sudo apt-get install texmaker

texmaker cv-aandrieu-02-07-2020.tex
pdflatex cv-aandrieu-02-07-2020.tex

exit 0
