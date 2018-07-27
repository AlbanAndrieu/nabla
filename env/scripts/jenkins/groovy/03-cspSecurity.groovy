import hudson.model.*;
import jenkins.model.*;

Thread.start {
      sleep 10000
      println "--> disable security like csp"
      System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
      System.setProperty("permissive-script-security.enabled", "true")
      println "--> disable security like csp... done"
}
