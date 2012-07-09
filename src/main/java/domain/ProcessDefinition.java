package domain;



import java.util.HashSet;
import java.util.Set;

/**
 * Representation of a process definition.
 *
 */
public final class ProcessDefinition implements java.io.Serializable {


	private static final long serialVersionUID = 317248088714169949L;
	private long processdefinitionid;
	private String name;
	private String description;

	private Set<ActivityDefinition> activityDefinitions = new HashSet<ActivityDefinition>(
			0);



	public ProcessDefinition() {
	}



	public long getProcessdefinitionid() {
		return this.processdefinitionid;
	}

	public void setProcessdefinitionid(long processdefinitionid) {
		this.processdefinitionid = processdefinitionid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ActivityDefinition> getActivityDefinitions() {
		return this.activityDefinitions;
	}

	public void setActivityDefinitions(
			Set<ActivityDefinition> activityDefinitions) {
		this.activityDefinitions = activityDefinitions;
	}


}
