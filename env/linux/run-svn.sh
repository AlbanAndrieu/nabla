#http://ericreboisson.developpez.com/tutoriels/install-subversion/
lance  svn
#svnserve -d

#sc create svn binpath= "\"C:\Program Files (x86)\CollabNet\Subversion%20Server\svnserve.exe\" --service -r C:\svn_repository" displayname= "Subversion Server" depend= Tcpip start= auto

svnadmin create "C:\svn_repos"
svnserve --daemon --root "C:\svn_repos"
svn mkdir svn://localhost/project
svn mkdir svn://localhost/project/trunk 

svn://localhost:3690
svn://localhost/

svn co svn://localhost/project/trunk/ .

svn import C:/workspace file:///C:\svn_repository -m "Initial import"
