Thread.getAllStackTraces().keySet().each(){
  item ->
    if(item.getName().contains("SCM polling") && item.getName().contains("waiting for hudson.remoting"))
        {
            println "Interrupting thread " + item.getId() ;
            item.interrupt();
        }
}