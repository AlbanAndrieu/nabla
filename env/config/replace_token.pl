#!/bin/perl

#use strict;
use warnings;

use Getopt::Std;
use File::Copy;

my $RECURSIVE_LIMIT=5;

#LOG LEVELS
my $LL_ERROR = 1;
my $LL_WARNING = 2;
my $LL_INFO = 3;
my $LL_DEBUG = 4;
my $LOG_LEVEL = $LL_WARNING;
my %LOG_LEVELS = ( $LL_ERROR ,   "ERROR",
                   $LL_WARNING,  "WARN",
                   $LL_INFO,     "INFO",
                  $LL_DEBUG,    "DEBUG");

getopts('f:p:r:a:vdo',\%options);

my $REMOVED_EXTENSION = $options{r}?$options{r}:"";
my $ADDED_EXTENSION = $options{a}?$options{a}:"";
my $PROP_FILES = $options{p}?$options{p}:"";
my $OVERWRITE = $options{o}?1:0;
my $FILE_LIST = $options{f}?$options{f}:"";

if($options{v}) {
  $LOG_LEVEL = $LL_INFO;
}
if($options{d}) {
  $LOG_LEVEL = $LL_DEBUG;
}

sub logger {
  my $level = $_[0];
  my $message = $_[1];
  if($level <= $LOG_LEVEL) {
    print "$LOG_LEVELS{$level}: $message\n";
  }
}

sub loadTokens() {

  $tokenfile = $_[0];
  logger($LL_DEBUG, "Working one file: $tokenfile");
  open(TOKEN_FILE, $tokenfile);
  
  while(<TOKEN_FILE>) {
    $_ =~ s/\n$//;
    if($_ =~ /^#/ || $_ =~ /^\s*$/ || $_ =~ /^---/) {
      next;
    }
    if($_=~/.+:/) {
      $key = $_;
      $key =~ s/:.*//;
      $value = $_;
      $value =~ s/[^:]+://;
      if($tokens{$key}) {
        logger($LL_DEBUG, "Updated: set \"$key\" as $value");
      }
      else {
        logger($LL_DEBUG, "New token: set \"$key\" as $value");
      }
      $tokens{$key} = $value;
      next;
    }
    logger($LL_WARNING, "LoadTokens from $tokenfile: Canot parse $_");
  }
  
  close(TOKEN_FILE);
}


sub resolveTokens() {
  @tokens_list = keys(%tokens);
  for($i=0, $useful_loop = 1; $i<$RECURSIVE_LIMIT && $useful_loop == 1; $i++) {
    $useful_loop = 0;
    foreach $token_replacement (@tokens_list) {
      foreach $token_replaced (@tokens_list) {
        if(index($tokens{$token_replaced}, $token_replacement) >= 0) {
          $tokens{$token_replaced} = str_replace($token_replacement, $tokens{$token_replacement}, $tokens{$token_replaced});
          logger($LL_DEBUG, "Updated: set \"$token_replaced\" as \"$tokens{$token_replaced}\"");
          $useful_loop = 1;
        }
      }
    }
  }

  if($i == $RECURSIVE_LIMIT) {
    logger($LL_ERROR, "RECURSIVE_LIMIT has been reached");
  }
}

sub printTokens() {
  logger($LL_DEBUG, "======================================================");
  while (($token,$value) = each(%tokens)) {
    $to_log = sprintf "%-20s || %-60s", $token, $value;
    logger($LL_DEBUG, $to_log);
  }
  logger($LL_DEBUG, "======================================================");
}

sub str_replace {
	my $search = shift;
	my $replace = shift;
	my $subject = shift;
	if (! defined $subject) { return -1; }
	my $count = shift;
	if (! defined $count) { $count = -1; }
	
	my ($i,$pos) = (0,0);
	while ( (my $idx = index( $subject, $search, $pos )) != -1 )
	{
		substr( $subject, $idx, length($search) ) = $replace;
		$pos=$idx+length($replace);
		if ($count>0 && ++$i>=$count) { last; }
	}
	
	return $subject;
}

sub replaceTokens() {
  if ( "$FILE_LIST" ne "" ) {
    open(FILE_HANDLER, "<".$FILE_LIST) || die "Unable to open '".$FILE_LIST."'";
    while(<FILE_HANDLER>) {
      chomp;
      replaceTokensInFile($_);
    }
    close(FILE_HANDLER);
  }
  foreach $argnum (0 .. $#ARGV) {
    replaceTokensInFile ($ARGV[$argnum]);
  }
 }

sub replaceTokensInFile() {
  my $file_in = shift;
  
    if( ! -r $file_in) {
      logger($LL_WARNING, "File $file_in can't be read");
      next;
    }
      $file_out = $file_in;
      $file_out =~ s/$REMOVED_EXTENSION$/$ADDED_EXTENSION/;
      $file_res = $file_out;
      
      if(-e $file_out) {
        $overwrite_done=1;
        $file_out = "$file_out.replace";
        if ($OVERWRITE == 1 ) {
            logger($LL_INFO, "\"$file_res\" is being overwritten");
        }
        else {
            $file_res = $file_out;
        }
      }
      
      if ($file_in ne $file_res) {
        $tolog = sprintf("Input file:     %-30s\n      Tokenfree file: %-30s", $file_in, $file_res);
        logger($LL_INFO, $tolog);
      }

      open (IN, "$file_in");
      $mode = (stat($file_in))[2];
      open(OUT, "> $file_out") || die "couldn't open $file_out\n";
      while (<IN>){
        $line = $_;
        while (($token,$value) = each(%tokens)) {
          #$line =~ s/'$token'/'$value'/g;
          $line = str_replace($token, $value, $line);
        }
        print OUT $line;
      }
      close IN;
      close OUT;
      chmod $mode, $file_out ;
      
      if ($OVERWRITE == 1 && $overwrite_done == 1 ) {
        move($file_out,$file_res);
      }
}

%tokens = ();

@prop_files = split(/,/, $PROP_FILES);
foreach $prop_f (@prop_files) {
  if( ! -r $prop_f) {
    logger($LL_WARNING, "Token file \"$prop_f\" can't be read");
  }
  else {
    &loadTokens($prop_f);
  }
}

&resolveTokens();

&printTokens();

&replaceTokens();
