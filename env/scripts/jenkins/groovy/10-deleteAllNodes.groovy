for (slave in hudson.model.Hudson.instance.slaves) {
    slave.getComputer().setTemporarilyOffline(true,null)
    slave.getComputer().doDoDelete()
}
