import hudson.model.*
import hudson.maven.*
import hudson.tasks.*
import org.jvnet.hudson.plugins.m2release.*

for(item in Hudson.instance.items) {
  if (item instanceof MavenModuleSet)
  {
    println("\njob $item.name ");
    rw = item.getBuildWrappers().get(M2ReleaseBuildWrapper.class);
    if (rw == null)
    {
      println("release build not configured");
    }
    else
    {
     println("append Username: "+rw.isSelectAppendHudsonUsername())
     rw.setSelectAppendHudsonUsername(true)
     item.save()
    }
  }
}
