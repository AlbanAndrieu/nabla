for (slave in jenkins.model.Jenkins.instance.slaves) {
  out.print("Slave  $slave.nodeName : Labels: $slave.labelString\n")
}