package domain;


import java.util.HashSet;
import java.util.Set;

/**
 * Representation of a process instance.
 *
 */
public final class ProcessInstance implements java.io.Serializable {

	
	
	private static final long serialVersionUID = -7705760575492210722L;
	private long processinstanceid;
	private ProcessDefinition processDefinition;
	private Set<ActivityInstance> activityInstances = new HashSet<ActivityInstance>(
			0);

	public ProcessInstance() {
	}



	public long getProcessinstanceid() {
		return this.processinstanceid;
	}

	public void setProcessinstanceid(long processinstanceid) {
		this.processinstanceid = processinstanceid;
	}

	public ProcessDefinition getProcessDefinition() {
		return this.processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public Set<ActivityInstance> getActivityInstances() {
		return this.activityInstances;
	}

	public void setActivityInstances(Set<ActivityInstance> activityInstances) {
		this.activityInstances = activityInstances;
	}

}
