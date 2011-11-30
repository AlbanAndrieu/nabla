 ----
 The Nabla Project
 ----
 dev@nabla.mobi

The Nabla Site
========================

Introduction
------------

 The Nabla is what you get when you visit
 http://nabla.mobi/maven (our homepage). 
 It is the envelope site for all Nabla sub projects.

 In short: This svn repository is only interesting for you if you

 a) want to re-create the Nabla site on your local computer or intranet.

 b) are an Nabla committer and want to update the site. 


Building the Site
-----------------

 Nabla uses Apache Maven 2 to build the site.

 It requires at least Maven 2.2.1 to build, Maven 3.0.2 is recommended.

 The site consists of multiple modules: The Site itself and some
 helpers that must be installed in your local Maven repository. These
 extensions are currently not present in the remote Maven
 repositories, so if you do not install them, the site build itself
 will fail.


Checking the Site module out of the Source Code Repository
===================================================================

 The site is available from
 https://code.google.com/p/alban/ (The Nabla Site repository). 
 You need a Subversion client installed to download
 the site source code onto your computer.



Create the Nabla Site Helper modules
----------------------------------------------

 To build the site, you need the helper modules installed locally. 

 The helper modules have been organized as a Maven reactor build. You
 can install them by running "mvn" from the "build-tools" sub-directory.

 You need to install these only once unless the dependencies of the
 site have changed which should only happen very rarely.


Questions and contact
---------------------

 If you have questions about the Nabla Site building
 process, please ask the developers on the Nabla
 Developers mailing list at <ddev@nabla.mobi>.

