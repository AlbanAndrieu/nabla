def nonExcl = [];
for(Node in hudson.model.Hudson.instance.slaves) {
    if(!Node.getMode().equals(Node.Mode.EXCLUSIVE)) {
      nonExcl.add(Node.getDisplayName());
    }
  }
 
for(item in Hudson.instance.items) {
  Label lbl = item.assignedLabel;
  println ("Job: ${item.getDisplayName()} (${lbl}) can run on following slaves: " );
 
  if(lbl != null) {
    for(Node in lbl.getNodes()) {
      println Node.getDisplayName();
    }
  } else {
    if (nonExcl.size() > 0 ) {
      println nonExcl;
    } else {
      println ('<none>');
    }
  }
 
}