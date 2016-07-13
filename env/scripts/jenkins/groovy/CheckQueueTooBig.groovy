import hudson.model.*
def q = jenkins.model.Jenkins.getInstance().getQueue()
def items = q.getItems()
def includeItemsList = [ "nabla-projects-interview-visma-nightly", "nabla-servers-bower-sample-nightly"]

for (Item in includeItemsList)
{
	def counter=0
	for (i=0;i<items.length;i++)
	{
		if (Item.contains(items[i].task.getName()))
		{
			counter=counter+1
		}
	}
    println ("Job: "+Item+" got "+counter+" tasks in queue\n")
	if (counter>3)
	{
 		build.getExecutor().interrupt(Result.FAILURE)
	}
}
