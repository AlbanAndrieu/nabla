#!/bin/bash

base=${1?1st argument is 'base' file}
theirs=${2?2nd argument is 'theirs' file}
mine=${3?3rd argument is 'mine' file}
merged=${4?4th argument is 'merged' file}
version=$(meld --version | perl -pe '($_)=/([0-9]+([.][0-9]+)+)/' )    

if [[ "$version" < 1.7 ]]
then
  #old meld version 1.6.* = three input files
  cat "$mine" > "$merged"
  meld --label="Base=${base##*/}"           "$base"   \
       --label="Mine->Merged=${merged##*/}" "$merged" \
       --label="Theirs=${theirs##*/}"       "$theirs"
else
  # recent meld versions 1.7.* and above = four input files
  meld --label="Base=${base##*/}"           "$base"   \
       --label="Mine=${mine##*/}"           "$mine"   \
       --label="Merged=${merged##*/}"       "$merged" \
       --label="Theirs=${theirs##*/}"       "$theirs"
fi
