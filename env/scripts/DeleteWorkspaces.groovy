//delete workspaces on selected machines

def hi = hudson.model.Hudson.instance;
for(Node in hudson.model.Hudson.instance.slaves) {
  if(Node.getDisplayName().contains(<slave name>)) {
        Node.computer.setTemporarilyOffline(true);
    try {
        hi.getItems(hudson.model.Job).each {
            job ->
            def work = Node.getWorkspaceFor(job);
            if (work.exists() && !job.isBuilding()) {
                println("---------");
                println(job.displayName);
                println(Node.getDisplayName());
                println(work);
                def subdirs = work.list();
                      if (subdirs.size() > 0 ) {
                        for(d in subdirs) {
                          if (".git".equals(d.getName()) || ".gitignore".equals(d.getName())) {
                            continue;
                          }
                          if ("appnet".equals(d.getName())) {
                            for(e in d.list()) {
                                if(!"log".equals(e.getName())) {
                                  e.deleteRecursive();
                                }
                            }
                            continue;
                        }
                        d.deleteRecursive();                   
                        }
                      }
            }       
        }
    } catch (Exception e) {
        println(e.getMessage());
    } finally {
        Node.computer.setTemporarilyOffline(false);
    }
  }
}