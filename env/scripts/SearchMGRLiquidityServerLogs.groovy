for(item in Hudson.instance.items) {
  if(item.getDisplayName().contains/equals("<jobname>")) {
      println(item.getDisplayName());
      for(Job in item.getAllJobs()) {
            for(Run in Job.getBuilds()) {
                  File f = new File(Run.getRootDir().getAbsolutePath() + "<logs subdirectory>");
                  if(f.exists() && f.isDirectory()) {
                    for(File in f.listFiles()) {
                      for(String in File.readLines()) {                       
                      if(String.contains("<search string>")) {
                        println("Expression found in file " + File.getAbsolutePath() +" for build #"+Run.getNumber());
                        println(String);
                      }
                    }
                  }
                }
            }  
      }
  }
}