@echo off

C:
chdir C:\cygwin\bin

rem Clear PATH to prevent tcsh from choking on "Program Files (x86)"
set PATH=

tcsh -l %*
