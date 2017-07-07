import hudson.model.*
import hudson.node_monitors.*
import hudson.slaves.*
import java.util.concurrent.*

jenkins = Hudson.instance

import javax.mail.internet.*;
import javax.mail.*
import javax.activation.*

def ignoreSlavesList = [ "test-workstation", "albandri" ]

def getEnviron(computer) {
   def env
   def thread = Thread.start("Getting env from ${computer.name}", { env = computer.environment })
   thread.join(2000)
   if (thread.isAlive()) thread.interrupt()
   env
}

def slaveAccessible(computer) {
    getEnviron(computer)?.get('PATH') != null
}


def numberOfflineNodes = 0
def numberNodes = 0
def numberErrorNodes = 0

for (slave in jenkins.slaves) {
  def computer = slave.computer
  numberNodes ++

  //check if node should be ignored
  if(!ignoreSlavesList.contains(computer.name)){
    //check if slave was disconnected on purpose
    if (slave.getComputer().getOfflineCause().toString().contains("Disconnected by")) {
      numberOfflineNodes ++
    } else {
      def isOK = (!computer.offline && slaveAccessible(computer))
      if (!isOK) {
        numberOfflineNodes ++

        if (slave.getComputer().isTemporarilyOffline()) {
          computer.setTemporarilyOffline(false, slave.getComputer().getOfflineCause())

        } else {
          numberErrorNodes ++
          println "  ERROR: ${computer.name}."
          println('\tcomputer.getOfflineCause: ' + slave.getComputer().getOfflineCause());
        }
      }
    }
  }

}

println ("")
println ("Number of Nodes: " + numberNodes)
println ("Number of Offline Nodes: " + numberOfflineNodes)


if (numberErrorNodes > 0) {
  println ("Number of Nodes with Errors: " + numberErrorNodes)
}
