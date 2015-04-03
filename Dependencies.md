# Introduction #

Below are some projets that I have used.

# Dependencies #

  * A Mavenized Seam Project Template :

http://code.google.com/p/seam-maven-refimpl

Used for is OpenEjb integration.

  * GWT 2.x (and GWTP) & Seam 2.x Integration for JBoss AS

http://code.google.com/p/gwt-seam/

Used the equivalent to gwt-seam.jar found in the ZIP attached to this article [Article](http://virgo47.wordpress.com/2010/02/09/jboss-seam-gwt-2-support/). I extracted it to :

```
nabla/timetracker-ejb3/core
```

Because I have mavenized this project yet.

The GWT 2.x & Seam 2.x Integration seems to be based on the followinf articles :
  * [Jboss Seam](http://docs.jboss.com/seam/2.1.1.GA/reference/en-US/html/gwt.html)
  * [Seam GWT index](http://unrealities.com/seamgwt/)
  * [Seam GWT article](http://unrealities.com/seamgwt/article_0.2.html)

# Tips #

Use maven generated site to check dependency convergence.

[Dependency Convergence](http://www.maven.nabla.mobi/databases/main/servers/customs/project/dependency-convergence.html)