package domain;


import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Representation of an activity instance.
 *
 */
public final class ActivityInstance implements java.io.Serializable {


	private static final long serialVersionUID = 5434812074495739515L;
	private long activityinstanceid;
	private ProcessDefinition processDefinition;
	private ActivityDefinition activityDefinition;
	private Swimlane swimlane;
	private ProcessInstance processInstance;
	private long state;
	private Set<User> users = new HashSet<User>(0);
	private Set<PropertyValue> propertyValues = new HashSet<PropertyValue>(0);

	public ActivityInstance() {
	}



	public long getActivityinstanceid() {
		return this.activityinstanceid;
	}

	public void setActivityinstanceid(long activityinstanceid) {
		this.activityinstanceid = activityinstanceid;
	}

	public ProcessDefinition getProcessDefinition() {
		return this.processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public ActivityDefinition getActivityDefinition() {
		return this.activityDefinition;
	}

	public void setActivityDefinition(ActivityDefinition activityDefinition) {
		this.activityDefinition = activityDefinition;
	}

	public Swimlane getSwimlane() {
		return this.swimlane;
	}

	public void setSwimlane(Swimlane swimlane) {
		this.swimlane = swimlane;
	}

	public ProcessInstance getProcessInstance() {
		return this.processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public long getState() {
		return this.state;
	}

	public void setState(long state) {
		this.state = state;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

	public void setPropertyValues(Set<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

}
