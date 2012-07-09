package domain;


import java.util.HashSet;
import java.util.Set;

/**
 * Representation of a Swimlane definition.
 *
 */
public final class Swimlane implements java.io.Serializable {

	
	private static final long serialVersionUID = -5129141626319140021L;
	private long swimlaneid;
	private String name;
	private Set<ActivityInstance> activityInstances = new HashSet<ActivityInstance>(
			0);
	private Set<ActivityDefinition> activityDefinitions = new HashSet<ActivityDefinition>(
			0);

	public Swimlane() {
	}



	public long getSwimlaneid() {
		return this.swimlaneid;
	}

	public void setSwimlaneid(long swimlandid) {
		this.swimlaneid = swimlandid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ActivityInstance> getActivityInstances() {
		return this.activityInstances;
	}

	public void setActivityInstances(Set<ActivityInstance> activityInstances) {
		this.activityInstances = activityInstances;
	}

	public Set<ActivityDefinition> getActivityDefinitions() {
		return this.activityDefinitions;
	}

	public void setActivityDefinitions(
			Set<ActivityDefinition> activityDefinitions) {
		this.activityDefinitions = activityDefinitions;
	}

}
