package service;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import util.AppConfigFactory;

public class PropertyDefinitionSvcTest extends TestCase {

	public void testRetrieveList() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();

		PropertyDefinitionSvc propDefService = (PropertyDefinitionSvc) ctx
				.getBean("propertyDefinitionBean");
		assertNotNull(propDefService);

		List<domain.PropertyDefinition> props = propDefService.retrieveList();
		assertNotNull("null property list", props);
		for (domain.PropertyDefinition pd : props) {
			assertNotNull("null prop definition name", pd.getName());
			propDefService.updateDescription(pd.getName(), "description");
		}

	}
}
