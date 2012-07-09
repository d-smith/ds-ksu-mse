package persistence;

import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import util.ProcessInstanceFactory;
import dao.ActivityClaimDAO;
import domain.ActivityInstance;
import domain.ProcessInstance;

public class ActivityClaimDAOTest extends TestCase {

	private ActivityClaimDAO activityClaimDAO;
	private ProcessInstanceFactory factory;
	

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		activityClaimDAO = (ActivityClaimDAO) ctx.getBean("activityClaimDAO");
		assertNotNull(activityClaimDAO);
		
		factory = new ProcessInstanceFactory();
		assertNotNull(factory);


	}

	public final void testClaim() {

		ProcessInstance pi = factory.createProcessInstance();
		assertNotNull(pi);
		Set<ActivityInstance> activities = pi.getActivityInstances();
		long activityId = -1;
		for(ActivityInstance ai : activities)
		{
			activityId = ai.getActivityinstanceid();
			break;
		}

		String userId = "u1";
		activityClaimDAO.claimActivity(userId, activityId);
		assertTrue(activityClaimDAO.activityClaimed(userId, activityId));
		activityClaimDAO.releaseClaim(userId, activityId);
		assertFalse(activityClaimDAO.activityClaimed(userId, activityId));

	}

}
