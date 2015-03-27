for(item in Hudson.instance.items) {
  if(item.getDisplayName().contains/equals("<jobname>")) {
      println(item.getDisplayName());
      for(Job in item.getAllJobs()) {
            for(Run in Job.getBuilds()) {
                 String logFile = Util.loadFile(Run.getLogFile(), Run.getCharset());
                  if(logFile.contains("<search phrase>")) {
                    println("Search phrase found in build #" + Run.getNumber());
                }
            } 
      }
  }
}