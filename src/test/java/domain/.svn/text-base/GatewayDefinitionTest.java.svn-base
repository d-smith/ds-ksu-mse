package domain;

import junit.framework.TestCase;

public class GatewayDefinitionTest extends TestCase {
	public void testGatewayDefinition() {
		GatewayDefinition gd = new GatewayDefinition();
		gd.setGatewayid(1);
		assertEquals(gd.getGatewayid(), 1);
		
		gd.setName("name");
		assertEquals(gd.getName(), "name");
		
		gd.setProcessDefinition(null);
		assertNull(gd.getProcessDefinition());
		
		gd.setType(0);
		assertEquals(gd.getType(), 0);
	}
}
