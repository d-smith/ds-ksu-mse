package persistence;

import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import util.ProcessInstanceFactory;
import dao.ActivityInstanceDAO;
import domain.ActivityInstance;
import domain.ProcessInstance;

public class ActivityInstanceDAOTest extends TestCase {
	private ActivityInstanceDAO activityInstanceDAO;
	private ProcessInstanceFactory factory;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		activityInstanceDAO = (ActivityInstanceDAO) ctx
				.getBean("activityInstanceDAO");
		assertNotNull(activityInstanceDAO);

		factory = new ProcessInstanceFactory();
		assertNotNull(factory);
	}

	public final void testRetrieve() {

		ProcessInstance pi = factory.createProcessInstance();
		assertNotNull(pi);

		Set<ActivityInstance> activities = pi.getActivityInstances();
		for (ActivityInstance activity : activities) {
			ActivityInstance ai = activityInstanceDAO.retrieve(activity
					.getActivityinstanceid());
			assertNotNull(ai);
		}

	}
}
