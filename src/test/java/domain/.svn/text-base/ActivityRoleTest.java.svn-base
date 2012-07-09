package domain;

import junit.framework.TestCase;

public class ActivityRoleTest extends TestCase {
	public void testActivityRole()
	{
		ActivityRole activityRole = new ActivityRole();
		activityRole.setActivityDefinition(null);
		assertNull(activityRole.getActivityDefinition());
		
		ActivityRoleId activityRoleId = new ActivityRoleId();
		activityRoleId.setActivitydefinitionid(1);
		activityRoleId.setProcessdefinitionid(2);
		
		activityRole.setId(activityRoleId);
		activityRoleId = activityRole.getId();
		assertEquals(activityRoleId.getActivitydefinitionid(), 1);
		assertEquals(activityRoleId.getProcessdefinitionid(), 2);
		
		activityRole.setProcessDefinition(null);
		assertNull(activityRole.getProcessDefinition());
		activityRole.setRole(null);
		assertNull(activityRole.getRole());
		
		activityRoleId = new ActivityRoleId(100, 200);
		assertEquals(activityRoleId.getActivitydefinitionid(), 200);
		assertEquals(activityRoleId.getProcessdefinitionid(), 100);
		
	}
}
