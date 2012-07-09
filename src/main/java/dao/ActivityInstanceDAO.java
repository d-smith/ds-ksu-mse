package dao;

import java.util.List;
import java.util.Set;

import domain.ActivityInstance;
import domain.ActivityState;
import domain.PropertyValue;

/**
 * 
 * Interface defining data access for activity instances.
 *
 */
public interface ActivityInstanceDAO {
	/**
	 * Retrieve an activity instance.
	 * @param activityId Activity identifier.
	 * @return Activity instance associated with activityId if found, otherwise null.
	 */
	ActivityInstance retrieve(long activityId);
	
	/**
	 * Update an activity instance. This method updates the set of data associated with
	 * the activity instance, as well as the state of the activity.
	 * @param activityId Activity identifier.
	 * @param propertyValues Set of data to associate with the activity. Note this is checked
	 * against the activity definition: the full set of properties as specified by the activity
	 * definition must be supplied.
	 * @param newState New state to set on the activity instance.
	 */
	void update(long activityId, Set<PropertyValue> propertyValues, ActivityState newState);
	
	/**
	 * Retrieve activity instances at a specified swimlane.
	 * @param swimlaneId Identity of the swimlane to retrieve activities for.
	 * @return A list of activities at the specified swimlane.
	 */
	List<ActivityInstance> retrieveInstancesAtSwimlane(long swimlaneId);
	
	/**
	 * Retrieve activity instances associated with a specific process at a specific swimlane.
	 * @param swimlaneId Swimlane to filter the set of activity instances associated with a process.
	 * @param processId Process identifier for the process of interest.
	 * @return A list of activity instances for a specific process as the given swimlane.
	 */
	List<ActivityInstance> retrieveInstancesAtSwimlaneForProcess(long swimlaneId, long processId);
	
	/**
	 * Update the properties for an activity, and set its state to COMPLETED.
	 * @param key Activity key/identifier.
 	 * @param values Property value set to associated with the activity.
	 */
	void updatePropertiesForCompleted(long key, Set<PropertyValue> values);
}
