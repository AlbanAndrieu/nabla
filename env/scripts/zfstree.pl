#!/usr/bin/perl -w

use strict;
use diagnostics;

use Tree::Simple;
use Tree::Simple::View::ASCII;
use Term::ANSIColor qw(:constants);
use Getopt::Long;

my $VERSION = '2.1';

# pool to use
my $pool = 'dpool';
my $dataset;
my $version;
my $h;

#perldoc -u zfstree.pl
=head1
Show zfs datasets as a tree
=cut

GetOptions (
    "pool:s"    => \$pool,
    "dataset:s" => \$dataset,
    "version"   => \$version,
    "help"      => \$h,
) or usage();

usage() if $h;

# Display version
if( $version ){
    print "NABLA Suite\nVersion: $VERSION\n\n";
    exit 0;
}

sub usage {
    print <<EOT;
Usage:
    showtree [options]

Options:
    --help              brief help message
    --pool [pool]       pool name to displays the zfs tree (dpool is used by default)
    --dataset [dataset] specify the dataset root of the tree (dpool is used by default)
 
EOT
    exit 0;
}
# Actual Relationship got from zfs command
my $cmd = "zfs list -H -o name,origin -r $pool";

my @zfs_list = `$cmd`;

# tree node for each fs are stored in a hashmap
my %node_for;

# ascii tree
my ($tree_view, @report_lines);

# Registering relationship
sub build_tree {
    my @zfs_list = @_;
    ZFS_LIST:
    for my $item (@zfs_list){
        
        chomp $item;
        my ($name, $origin) = $item =~ /^(.+)\t(.+)$/;

        # It this is a snapshot, we consider the volume as the origin 
        my ($volume) = $name =~ /^([^\@]+)\@.+/;
        $origin = $volume if defined $volume;
        
        # if no reported origin, the origin is the pool
        $origin = $pool if $origin eq '-';

        s/^\Q$pool\E\/(.+)/$1/ for ($name, $origin);
        
        # We create the Tree::Simple nodes and store them in a hashmap in
        # order to avoid parsing the tree to know if a node already exists 
        for my $node_name ( $origin, $name ){
            $node_for{$node_name} = Tree::Simple->new($node_name)
                if !defined $node_for{$node_name};
        }
        
        # Finally, we register the relationship 
        $node_for{$origin}->addChild($node_for{$name})  
            if $origin ne $name;
    }
}

# We post process the ascii tree
sub print_report {
    my @lines = @_;
    
    ASCII_REPORT:
    for my $i (0..$#lines){
        # We split the the "graphic" part and the fs name
        my($treelines, $dashes, $fs) = $lines[$i] =~ /^(.+)(---)(.+)$/;
        my $properties_cmd;
        
        if(!defined $fs){
            $fs = $lines[$i];
            $treelines = $dashes = '';
        }
        
        $properties_cmd = "zfs get -H -o property,value all $pool/$fs";

        # We colorize nodes according to their type
        # Green : trasheable
        # Red  : official, persistent
        # Blue : snapshots
        print $treelines, $dashes, $lines[$i]=~/kzone/? GREEN :
              $lines[$i]=~/\@/           ?         BLUE   : RED,   
              $fs, RESET, "\n";
              
        # datasets are annotated using zfs user properties
        # We retrieve them in order to annotate tree
        # properties have the prefix 'nabla:'
        # Available: changelog, usage, owner
        # usage and owner are useful for zones description
        my @properties = reverse sort grep /nabla:/, `$properties_cmd`;
        
        ## Here we do not want the tree lines to be continued for
        ## comments if the node has no remaining sibling
        # Then, we read the n+1 line of ascii tree view output
        my $next_treelines;
        if( defined $lines[$i+1] ){
            ($next_treelines) = $lines[$i+1] =~ /^(.+)---.+$/;
            $next_treelines = '' unless defined $next_treelines;
            # If the next tree line size is less than the present one, we
            # adjust the indentation by adding spaces
            my $diff = length($treelines) - length($next_treelines);
            if( $diff >  0 ) { $next_treelines .= ' ' x ($diff+8); } # Have sibling
            if( $diff == 0 ) { $next_treelines .= ' ' x 8; }# No child
        }
        else{
            # If no remaining siblings, we don't print the tree lines anymore
            $next_treelines = $treelines;
            $next_treelines =~ s/./ /g; # Replacing all characters with spaces
            $next_treelines .= ' ' x 8;
        }
         
        for my $property (@properties){
            chomp $property;
            my( $name, $value) = split "\t", $property;
            if( $value ne '-' ){
                # '***' means \n in zfs properties
                my @values = split '\*\*\*', $value;
                for my $v ( @values ){
                    print $next_treelines;
                    print "\t\\$name:", BOLD, "$v", RESET, "\n";
                }
            }
        }
        
        # height line = 2 
        print defined $next_treelines?"$next_treelines\n":"\n\n\n";
    }
}


# -- MAIN --

# Building the tree according to zfs list command
build_tree( @zfs_list );

# We now generate the ascci tree
my $root;
if ($dataset) {
    if (!$node_for{$dataset}) {
        print "Dataset $dataset not found!\n";
        exit 1;
    }
    $root=Tree::Simple->new("root")->addChild($node_for{$dataset});
} else {
    $root=$node_for{$pool};
}
$tree_view = Tree::Simple::View::ASCII->new($root);
@report_lines = split "\n", $tree_view->expandAll();
print_report( @report_lines );
