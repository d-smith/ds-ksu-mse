package util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import dao.ActivityDefinitionDAO;
import dao.ProcessDefinitionDAO;
import dao.ProcessInstanceDAO;
import dao.SwimlaneDAO;
import domain.ActivityInstance;
import domain.ProcessDefinition;
import domain.ProcessInstance;

public class ProcessInstanceFactory {
	
	private ProcessInstanceDAO processInstanceDAO;
	private ProcessDefinitionDAO processDefinitionDAO;
	private ActivityDefinitionDAO activityDefinitionDAO;
	private SwimlaneDAO swimlaneDAO;
	
	public ProcessInstanceFactory()
	{
		ApplicationContext ctx = util.AppConfigFactory.getAppContext();


		processInstanceDAO = (ProcessInstanceDAO) ctx
				.getBean("processInstanceDAO");

		processDefinitionDAO = (ProcessDefinitionDAO) ctx
				.getBean("processDefinitionDAO");

		activityDefinitionDAO = (ActivityDefinitionDAO) ctx
				.getBean("activityDefinitionDAO");

		swimlaneDAO = (SwimlaneDAO) ctx.getBean("swimlaneDAO");
	}

	public ProcessInstance createProcessInstance() {
		ProcessInstance pi = new ProcessInstance();
		ProcessDefinition pd = processDefinitionDAO
				.retrieveProcessDefinition("update beneficiary");

		pi.setProcessDefinition(pd);

		ActivityInstance a1 = new ActivityInstance();
		a1
				.setActivityDefinition(activityDefinitionDAO
						.retrieve("scan request"));
		a1.setProcessDefinition(pd);
		a1.setProcessInstance(pi);
		a1.setState(1);
		a1.setSwimlane(swimlaneDAO.retrieve("Scan dept"));

		ActivityInstance a2 = new ActivityInstance();
		a2.setActivityDefinition(activityDefinitionDAO
				.retrieve("process request"));
		a2.setProcessDefinition(pd);
		a2.setProcessInstance(pi);
		a2.setState(0);
		a2.setSwimlane(swimlaneDAO.retrieve("Account maint dept"));

		ActivityInstance a3 = new ActivityInstance();
		a3.setActivityDefinition(activityDefinitionDAO
				.retrieve("check request"));
		a3.setProcessDefinition(pd);
		a3.setProcessInstance(pi);
		a3.setState(0);
		a3.setSwimlane(swimlaneDAO.retrieve("QA dept"));

		Set<ActivityInstance> activities = new HashSet<ActivityInstance>();
		activities.add(a1);
		activities.add(a2);
		activities.add(a3);
		pi.setActivityInstances(activities);

		processInstanceDAO.persist(pi);
		
		return pi;
	}
}
