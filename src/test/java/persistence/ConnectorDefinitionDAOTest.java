package persistence;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import dao.ConnectorDefinitionDAO;
import domain.ConnectorDefinition;

public class ConnectorDefinitionDAOTest extends TestCase {

	private ConnectorDefinitionDAO connDefDAO;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		connDefDAO = (ConnectorDefinitionDAO) ctx
				.getBean("connectorDefinitionDAO");
		assertNotNull(connDefDAO);
	}

	
	public void testGetConnectorDefinition() {
		ConnectorDefinition cd = connDefDAO.getConnectorDefinition(1);
		assertNotNull("null connector definition", cd);
		assertTrue(cd.getConnectorid() == 1);
		assertNull(cd.getExpression());
		assertTrue(cd.getSinkid() == 2);
		assertTrue(cd.getSourceid() == 1);
	}

	
	
	

}
