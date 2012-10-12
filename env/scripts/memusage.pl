#!/usr/bin/perl -w

use strict;
use Getopt::Std;

use Data::Dumper;

my %_OPTS;

#----------------------------------------------------------------------------------------------
#  manageCommandLineOptions
#----------------------------------------------------------------------------------------------
sub manageCommandLineOptions()
{
	getopts('l:', \%_OPTS);

	$_OPTS{l} = 6 if(!defined($_OPTS{l}) || $_OPTS{l} < 6 ); 
	$_OPTS{l} +=1;
}

#----------------------------------------------------------------------------------------------
#  getProcessUsage
#----------------------------------------------------------------------------------------------
sub getProcessUsage()
{
	my $process;

	open(CMD, "ps -A --sort -rss -o pid,user,comm,pmem,size,rss | head -$_OPTS{l} |") or die "Cannot excute ps command";
	while(<CMD>)
	{
		next if ($. == 1);
		chomp;
		s/^\s*//;
		my @l = split('\s+', $_ );
		
		push (@{$process->{procs}}, { pid=> $l[0], user=>$l[1], command=>$l[2], mem=>$l[3], size=>$l[4], rss=>$l[5] });

		if( defined( $process->{sum} ) )
		{
			$process->{sum}->{cnt}  += 1; 
			$process->{sum}->{mem}  += $l[3];
			$process->{sum}->{size} += $l[4];
			$process->{sum}->{rss}  += $l[5];
		}
		else
		{
			$process->{sum}->{cnt}  = 1; 
			$process->{sum}->{mem}  = $l[3];
			$process->{sum}->{size} = $l[4];
			$process->{sum}->{rss}  = $l[5];
		}
	}	
	close(CMD);

	return $process
}

#----------------------------------------------------------------------------------------------
# getFreeMem
#----------------------------------------------------------------------------------------------
sub getFreeMem()
{
	my $mem;
	open(MEM, "free -m|") or die "cannot execute free command";
	while(<MEM>)
	{
		if(m/^Mem:/ ) 
		{
			chomp;
			my @l = split('\s+', $_);
			$mem = { total=>$l[1], used=>$l[2], free=>$l[3] };
			last;
		}
	}
	close(MEM);

	return $mem;
}

#=============================================================================================
#  M A I N
#=============================================================================================
manageCommandLineOptions();
my $procs = getProcessUsage();

my $mem = getFreeMem();


print "Memory in MB:\n";
print "=============\n";
my $pct_used = ($mem->{used}*100.0)/$mem->{total};
printf("%-10s %-10s %-10s %-10s\n", "Total", "Used", "Free", '%Used' );
printf("%-10s %-10s %-10s %-5.2f\n", $mem->{total}, $mem->{used}, $mem->{free} , $pct_used);
printf"\n";
printf"Processes:\n";
printf("==========\n");
printf("%-6s %-15s %-5s %-10s %-10s %-20s\n", "Pid", "User", "%Mem", "Sise", "Rss", "Command" );
foreach ( @{$procs->{procs}} )
{
	printf("%-6s %-15s %-5s %-10s %-10s %-20s\n", $_->{pid}, $_->{user}, $_->{mem}, $_->{size}, $_->{rss}, $_->{command} );
}
printf("%-6s %-15s %-5s %-10s %-10s %-20s\n", "", "", '-'x5, '-'x10, '-'x10, "" );
printf("%-6s %-15s %-5s %-10s %-10s %-20s\n", "", "", $procs->{sum}->{mem}, $procs->{sum}->{size}, $procs->{sum}->{rss}, "" );




