#See https://fahdshariff.blogspot.fr/2012/08/analysing-java-core-dump.html
cat /proc/sys/kernel/core_pattern

gdb $JAVA_HOME/bin/java core.11051
jstack -J-d64 $JAVA_HOME/bin/java core.11051
jmap -J-d64 $JAVA_HOME/bin/java core.11051

#Eclipse MAT memory analyzer or use jvisualvm
