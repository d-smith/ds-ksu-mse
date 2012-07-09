package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import dao.PropertyValueDAO;
import domain.FieldData;

public class PropretyValueDAOTest extends TestCase {
	private PropertyValueDAO propValueDAO;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		propValueDAO = (PropertyValueDAO) ctx
				.getBean("propertyValueDAO");
		assertNotNull(propValueDAO);
	}
	
	public void testScratch() {
		List<FieldData> fdl = new ArrayList<FieldData>();
		FieldData fd = new FieldData();
		fd.setName("policy_no");
		fd.setValue("123");
		fdl.add(fd);
		
		FieldData fd2 = new FieldData();
		fd2.setName("beneficiary");
		fd2.setValue("bob boone");
		fdl.add(fd2);
		
		List<Long> l = propValueDAO.findInstancesByPropertyValues(fdl);
		Iterator<Long> itor = l.iterator();
		while(itor.hasNext()) {
			System.out.println("pid: " + itor.next());
		}
		assertTrue(true);
	}
}
