package controller;

import dao.PropertyDefinitionDAO;
import domain.PropertyDefinition;

/**
 * Implementation of PropertyDefinitionController
 * @see PropertyDefinitionController
 */
public final class PropertyDefinitionControllerImpl implements
		PropertyDefinitionController {
	
	private PropertyDefinitionDAO propertyDefinitionDAO;
	
	/**
	 * For spring dependency injection.
	 * @param propertyDefinitionDAO
	 */
	public void setPropertyDefinitionDAO(PropertyDefinitionDAO propertyDefinitionDAO) {
		this.propertyDefinitionDAO = propertyDefinitionDAO;
	}

	public void updatePropertyDescription(String name, String description) {
		PropertyDefinition pd = propertyDefinitionDAO.retrieve(name);
		pd.setDescription(description);
		propertyDefinitionDAO.persist(pd);
	}

}
