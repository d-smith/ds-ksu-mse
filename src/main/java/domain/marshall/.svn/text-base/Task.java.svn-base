package domain.marshall;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import domain.ActivityInstance;
import domain.ActivityState;
import domain.PropertyValue;

/**
 * Value object class for marshalling data associated with tasks.
 */
public final class Task implements Serializable {

	private static final long serialVersionUID = -3702947182789087474L;
	private String state;
	private long processId;
	private long activityId;
	private long swimlaneId;
	private List<Property> properties;
	
	public Task() {
		
	}
	
	/**
	 * Construct an instance from an activity instance.
	 * @param ai ActivityInstance to pull data from to use in
	 * populating the object.
	 */
	public Task(ActivityInstance ai) {
		int activityState = (int) ai.getState();
		if(activityState == ActivityState.ACTIVE.getCode()) { 
			this.setState("Active");
		} else if(activityState == ActivityState.PENDING.getCode()) {
			this.setState("Pending");
		} else if(activityState == ActivityState.COMPLETE.getCode()) {
			this.setState("Complete");
		} else {
			this.setState("Unknown");
		}
		
		this.setActivityId(ai.getActivityinstanceid());
		this.setProcessId(ai.getProcessInstance().getProcessinstanceid());
		this.setSwimlaneId(ai.getSwimlane().getSwimlaneid());
		
		Set<PropertyValue> props = ai.getPropertyValues();
		List<Property> proplist= new ArrayList<Property>();
		this.setProperties(proplist);
		
		Iterator<PropertyValue> itor = props.iterator();
		while(itor.hasNext()) {
			PropertyValue pval = itor.next();
			
			Property p = new Property();
			p.setName(pval.getName());
			p.setValue(pval.getValue());
			
			proplist.add(p);
		}
	
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public long getSwimlaneId() {
		return swimlaneId;
	}
	public void setSwimlaneId(long swimlaneId) {
		this.swimlaneId = swimlaneId;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	
}
