package persistence;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import dao.ActivityDefinitionDAO;
import dao.ProcessDefinitionDAO;
import dao.ProcessInstanceDAO;
import dao.SwimlaneDAO;
import domain.ActivityInstance;
import domain.ProcessDefinition;
import domain.ProcessInstance;

public class ProcessInstanceDAOTest extends TestCase {
	private ProcessInstanceDAO processInstanceDAO;
	private ProcessDefinitionDAO processDefinitionDAO;
	private ActivityDefinitionDAO activityDefinitionDAO;
	private SwimlaneDAO swimlaneDAO;
	
	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();
		assertNotNull(ctx);

		processInstanceDAO = (ProcessInstanceDAO) ctx
				.getBean("processInstanceDAO");
		assertNotNull(processInstanceDAO);
		
		processDefinitionDAO = (ProcessDefinitionDAO) ctx
				.getBean("processDefinitionDAO");
		assertNotNull(processDefinitionDAO);
		
		activityDefinitionDAO = (ActivityDefinitionDAO) ctx
				.getBean("activityDefinitionDAO");
		assertNotNull(activityDefinitionDAO);
		
		swimlaneDAO = (SwimlaneDAO) ctx
				.getBean("swimlaneDAO");
	}
	
	public final void testPersistence() {
		ProcessInstance pi = new ProcessInstance();
		ProcessDefinition pd = 
			processDefinitionDAO.retrieveProcessDefinition("update beneficiary");
		assertNotNull(pd);
		
		pi.setProcessDefinition(pd);
		
		ActivityInstance a1 = new ActivityInstance();
		a1.setActivityDefinition(activityDefinitionDAO.retrieve("scan request"));
		assertNotNull(a1.getActivityDefinition());
		a1.setProcessDefinition(pd);
		a1.setProcessInstance(pi);
		a1.setState(1);
		a1.setSwimlane(swimlaneDAO.retrieve("Scan dept"));
		assertNotNull(a1.getSwimlane());
		
		ActivityInstance a2 = new ActivityInstance();
		a2.setActivityDefinition(activityDefinitionDAO.retrieve("process request"));
		assertNotNull(a2.getActivityDefinition());
		a2.setProcessDefinition(pd);
		a2.setProcessInstance(pi);
		a2.setState(0);
		a2.setSwimlane(swimlaneDAO.retrieve("Account maint dept"));
		assertNotNull(a2.getSwimlane());
		
		ActivityInstance a3 = new ActivityInstance();
		a3.setActivityDefinition(activityDefinitionDAO.retrieve("check request"));
		assertNotNull(a3.getActivityDefinition());
		a3.setProcessDefinition(pd);
		a3.setProcessInstance(pi);
		a3.setState(0);
		a3.setSwimlane(swimlaneDAO.retrieve("QA dept"));
		assertNotNull(a3.getSwimlane());
		
		Set<ActivityInstance> activities = new HashSet<ActivityInstance>();
		activities.add(a1);
		activities.add(a2);
		activities.add(a3);
		pi.setActivityInstances(activities);
		
		processInstanceDAO.persist(pi);
		
		
	}
}
