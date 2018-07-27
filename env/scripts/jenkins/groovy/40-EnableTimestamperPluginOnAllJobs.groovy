for (item in Hudson.instance.items) {
  println("\njob: $item.name")
  hasTimestamper = false;
  item.buildWrappersList.each {
    if (it instanceof hudson.plugins.timestamper.TimestamperBuildWrapper) {
      hasTimestamper = true;
    }
  }
  if (!hasTimestamper) {
    println(">>>>>>>> Adding timestamper right to $item.name")
    item.buildWrappersList.add(new hudson.plugins.timestamper.TimestamperBuildWrapper());
    item.save()
  }
}
