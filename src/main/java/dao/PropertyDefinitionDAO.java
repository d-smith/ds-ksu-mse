package dao;

import java.util.List;

import domain.PropertyDefinition;

/**
 * Data access interface for property definitions.
 *
 */
public interface PropertyDefinitionDAO {
	/**
	 * Retrieve a list of all property definitions in the system.
	 * @return List of PropertyDefinition instances.
	 */
	List<PropertyDefinition> retrieveList();
	
	/**
	 * Persist a property definition
	 * @param pd Property definition to make persistent.
	 */
	void persist(PropertyDefinition pd);
	
	/**
	 * Retrieve a property definition by name.
	 * @param name Name of the property of interest.
	 * @return Property definition associated with the given name if exists, otherwise null.
	 */
	PropertyDefinition retrieve (String name);
	
	/**
	 * Retrieve a property definition by id.
	 * @param id Id of the property definition to retrieve.
	 * @return Property definition associated with the id if exists, else null.
	 */
	PropertyDefinition retrieve(long id);
}
