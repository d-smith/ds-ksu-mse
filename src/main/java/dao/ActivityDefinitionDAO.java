package dao;

import domain.ActivityDefinition;

/**
 * 
 * Interface defining data access for activity definitions.
 *
 */
public interface ActivityDefinitionDAO {
	/**
	 * Retrieve an activity definition.
	 * @param name Name of the activity associated with the activity definition.
	 * @return ActivityDefinition if found, otherwise null.
	 */
	ActivityDefinition retrieve(String name);
}
