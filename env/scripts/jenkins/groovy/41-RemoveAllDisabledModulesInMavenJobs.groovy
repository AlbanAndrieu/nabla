import hudson.model.*
import hudson.maven.*

hudson.model.Hudson.instance.items.findAll{job -> job.isBuildable() && job instanceof MavenModuleSet}.each{
job ->
  job.getDisabledModules(true).each{module -> module.delete()}
  println(job.name+" cleaned")
}
