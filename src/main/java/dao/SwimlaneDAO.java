package dao;

import domain.Swimlane;

/**
 * Data access interface for swimlane definitions.
 * @author dsmith
 *
 */
public interface SwimlaneDAO {
	/**
	 * Retrieve a swimlane definition by swimlane name.
	 * @param name Swimlane name.
	 * @return Associated swimlane definition if exists, otherwise null.
	 */
	Swimlane retrieve(String name);
	
	/**
	 * Retrieve a swimlane definition by id.
	 * @param swimlaneId Swimlane id.
	 * @return Associated swimlane definition if exists, otherwise null.
	 */
	Swimlane retrieveById(long swimlaneId);
}
