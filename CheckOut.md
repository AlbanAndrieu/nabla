# Introduction #

Tips in order not to checkout the whole project.

# SVN #

See
[Source](http://code.google.com/p/alban/source/checkout)

Check out the whole trunk unless you want only some features.

Check out the following for the SHELL (bash/tcsh features) :

```
svn co https://alban.googlecode.com/svn/trunk/ . --depth empty
svn up env
svn up .vnc
svn up .bashrc
svn up .cshrc
svn up .subversion
```