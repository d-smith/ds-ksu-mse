package service;

import java.util.List;

import javax.jws.WebService;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import controller.PropertyDefinitionController;
import dao.PropertyDefinitionDAO;
import domain.PropertyDefinition;

/**
 * Concrete implementation of the PropertyDefinitionSvc interface.
 * @see PropertyDefinitionSvc
 */
@WebService(endpointInterface = "service.PropertyDefinitionSvc")
public final class PropertyDefinitionSvcImpl implements PropertyDefinitionSvc {

	private PropertyDefinitionDAO propertyDefinitionDOA;
	private PropertyDefinitionController propertyDefinitionController;

	public void setPropertyDefinitionDAO(
			PropertyDefinitionDAO propertyDefinitionDAO) {
		this.propertyDefinitionDOA = propertyDefinitionDAO;
	}

	public void setPropertyDefinitionController(
			PropertyDefinitionController propertyDefinitionController) {
		this.propertyDefinitionController = propertyDefinitionController;
	}

	public List<PropertyDefinition> retrieveList() {
		Monitor mon = MonitorFactory
				.start("service.PropertyDefinition.retrieveList");
		try {
			return propertyDefinitionDOA.retrieveList();
		} finally {
			mon.stop();
		}
	}

	public void updateDescription(String name, String description) {
		Monitor mon = MonitorFactory
				.start("service.PropertyDefinition.updateDescription");

		try {
			propertyDefinitionController.updatePropertyDescription(name,
					description);
		} finally {
			mon.stop();
		}

	}

}
