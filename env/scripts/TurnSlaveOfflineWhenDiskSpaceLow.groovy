import hudson.model.*;
import hudson.node_monitors.DiskSpaceMonitor;
import java.math.BigDecimal;
  
def thr = Thread.currentThread()
def computer = thr?.executable.getBuiltOn().toComputer()
def space = DiskSpaceMonitor.DESCRIPTOR.get(computer);
BigDecimal bd = new BigDecimal(space.getGbLeft());
long value = bd.setScale( 0, BigDecimal.ROUND_HALF_UP ).longValue();
if(value < X) {
  computer.setTemporarilyOffline(true);
}