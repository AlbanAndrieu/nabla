#!/bin/bash
#set -xv

WORKING_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

# shellcheck source=./step-0-color.sh
source "${WORKING_DIR}/step-0-color.sh"

# shellcheck disable=SC2154
echo -e "${red} Find NABLATest in share to clean ${NC}"

# Trunk job, we keep only 30 days
echo -e "${green} find /nabla/release/nabla-site-test/* -maxdepth 2 -mindepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+' -mtime +30 -exec rm -rv {} \; ${NC}"
find /nabla/release/nabla-site-test/* -maxdepth 2 -mindepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+' -mtime +30 -exec rm -rv {} \;
# Test job, we keep only 3 days
echo -e "${green} find /nabla/release/nabla-site-test/*-TEST -maxdepth 2 -mindepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+' -mtime +3 -exec rm -rv {} \; ${NC}"
find /nabla/release/nabla-site-test/*-TEST -maxdepth 2 -mindepth 2 -regextype posix-egrep -type d -regex '.+/NABLATest/r.+' -mtime +3 -exec rm -rv {} \;

# We keep only 120 days

#echo -e "${green} find /nabla/release/ARC/ReleaseCandidates -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/MGR-ARC.*' -mtime +120 -exec rm -rv {} \; ${NC}"
#find /nabla/release/ARC/ReleaseCandidates -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/MGR-ARC.*' -mtime +120 -exec rm -rv {} \;

# We keep only 180 days for release

echo -e "${green} find /nabla/release/latest -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/.*standard-fr-install.*' -mtime +180 -exec rm -rv {} \; ${NC}"
find /nabla/release/latest -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/.*standard-fr-install.*' -mtime +180 -exec rm -rv {} \;

# We keep only 30 days

echo -e "${green} find /nabla/release/lastSuccessfulBuild -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/NABLA.*' -mtime +30 -exec rm -rv {} \; ${NC}"
find /nabla/release/lastSuccessfulBuild -maxdepth 2 -mindepth 2 -regextype posix-egrep -type f -regex '.+/NABLA.*' -mtime +30 -exec rm -rv {} \;

exit 0
