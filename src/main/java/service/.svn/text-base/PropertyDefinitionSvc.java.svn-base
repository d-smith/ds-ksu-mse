package service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import domain.PropertyDefinition;

/**
 * Service interface for property definitions.
 */
@WebService(name="propertyDefinition",
	targetNamespace="http://people.cis.ksu.edu/dougs")
public interface PropertyDefinitionSvc {
	/**
	 * Retrieve a list of all property definitions in the system.
	 * @return List of all property definitions in the system.
	 */
	List<PropertyDefinition> retrieveList();
	
	/**
	 * Update the description associated with a property definition.
	 * @param name Name of the property being updated.
	 * @param description Description to be associated with the 
	 * property defintion.
	 */
	void updateDescription(@WebParam(name="name")String name, @WebParam(name="description")String description);
}
