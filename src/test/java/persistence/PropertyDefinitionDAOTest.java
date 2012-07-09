package persistence;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import dao.PropertyDefinitionDAO;
import domain.PropertyDefinition;

public class PropertyDefinitionDAOTest extends TestCase {

	private PropertyDefinitionDAO propDefDAO;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		propDefDAO = (PropertyDefinitionDAO) ctx
				.getBean("propertyDefinitionDAO");
		assertNotNull(propDefDAO);
	}

	public final void testRetrieveList() {

		List<PropertyDefinition> propDefs = propDefDAO.retrieveList();
		assertNotNull(propDefs);

		Iterator<PropertyDefinition> itor = propDefs.iterator();
		while (itor.hasNext()) {
			PropertyDefinition pd = itor.next();
			System.out.println(pd.getName());
		}
	}

	public final void testPersistAndRetrieve() {
		
		for (int i = 0; i < 2; i++) {
			PropertyDefinition pd = new PropertyDefinition();
			String name = "" + System.currentTimeMillis();
			pd.setDescription("pd " + name);
			pd.setName("" + name);
			pd.setType(1);
 
			System.out.println("Saving " + name);
			propDefDAO.persist(pd);

			pd = propDefDAO.retrieve(name);
			assertNotNull(pd);
			assertEquals(name, pd.getName());
			
			pd.setDescription("update");
			propDefDAO.persist(pd);
			
			pd = propDefDAO.retrieve(pd.getPropertydefinitionid());
			assertNotNull(pd);
		}
	}

	
	
	

}
