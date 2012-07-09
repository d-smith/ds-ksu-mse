package controller;

/**
 * Interface describing transaction script interfaces for manipulating property
 * definitions. Implementations of this interface are used from the service layer.
 *
 */
public interface PropertyDefinitionController {
	/**
	 * Update the description of a seeded property definition. Property definitions
	 * are metadata describing the names and data types of fields that can be referenced 
	 * by activity definitions.
	 * @param name Property name
	 * @param description New description to set on the property.
	 */ 
	void updatePropertyDescription(String name, String description);
}
