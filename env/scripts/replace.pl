#!/bin/perl

use Getopt::Std;
use File::Copy;

#LOG LEVELS
$LL_ERROR = 1;
$LL_WARNING = 2;
$LL_INFO = 3;
$LL_DEBUG = 4;
$LOG_LEVEL = $LL_WARNING;
%LOG_LEVELS = ( $LL_ERROR ,   "ERROR",
                $LL_WARNING,  "WARN",
                $LL_INFO,     "INFO",
                $LL_DEBUG,    "DEBUG");
                
getopts('e:hvd',\%options);

if($options{h} || !$options{e}) {
  print "\n";
  print "Usage: replace.pl -e <replace_pattern> -hvd <src_file>\n";
  print "\t\t -h : print this help\n";
  print "\t\t -v : verbose mode\n";
  print "\t\t -d : debug mode\n";
  print "\t\t -s : regular expression for the replace pattern,\n";
  print "\t\t      like 's/toto/titi/g' to replace all 'toto' strings by 'titi' string\n";
  print "\n";
  exit(1);
}

$FILE_NAME=$ARGV[0];

if($options{v}) {
  $LOG_LEVEL = $LL_INFO;
}
if($options{d}) {
  $LOG_LEVEL = $LL_DEBUG;
}


$USE_STDIN=0;

if (!$FILE_NAME) {
  $FILE_NAME="-";
  $FILE_NAME_TMP=">-";
  $USE_STDIN=1;
  print "Read for standard input.\n" if ($LOG_LEVEL >= $LL_DEBUG);
}
else {
  $FILE_NAME_TMP=$FILE_NAME.tmp;
  print "Read from file '", $FILE_NAME, "'.\n" if ($LOG_LEVEL >= $LL_DEBUG);
}

$REPLACE_PATTERN=$options{e};
print "Replace pattern = '", $REPLACE_PATTERN, "'\n" if ($LOG_LEVEL >= $LL_DEBUG);

open FILE, "<$FILE_NAME" or die "[ERROR] Open file '",$FILE_NAME,"' failed : ",$!;
open FILE_TMP, ">$FILE_NAME_TMP" or die "[ERROR] Open file '",$FILE_NAME,"' failed : ",$!;

while(<FILE>) {
  eval $REPLACE_PATTERN;
  print FILE_TMP $_;
}

close(FILE);
close(FILE_TMP);

if (!$USE_STDIN) {
  move($FILE_NAME_TMP, $FILE_NAME);
}
