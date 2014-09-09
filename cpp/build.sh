#!/bin/sh

#scons opt=True 
scons target=local package 2>&1 > scons.log
