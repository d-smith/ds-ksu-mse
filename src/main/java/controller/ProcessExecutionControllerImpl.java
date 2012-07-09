package controller;

import hazelcast.HazelcastConsts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fault.Fault;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;

import dao.ActivityInstanceDAO;
import dao.PropertyValueDAO;
import domain.ActivityDefinition;
import domain.ActivityInstance;
import domain.ActivityProperty;
import domain.ActivityState;
import domain.ConnectorDefinition;
import domain.FieldData;
import domain.ProcessDefinition;
import domain.ProcessInstance;
import domain.PropertyDefinition;
import domain.PropertyValue;
import domain.Swimlane;
import domain.marshall.Task;

/**
 * Concrete implementation of the ProcessExecutionController interface
 */
public final class ProcessExecutionControllerImpl implements
		ProcessExecutionController {
	
	private static Log log = LogFactory.getLog(ProcessExecutionControllerImpl.class);
	
	//String literal to avoid Sonar rule stupidity
	private static final String UNCHECKED = "unchecked"; 

	private ActivityInstanceDAO activityInstanceDAO;
	private PropertyValueDAO propertyValueDAO;

	/**
	 * Spring configuration injection method.
	 * @param propertyValueDAO
	 */
	public void setPropertyValueDAO(PropertyValueDAO propertyValueDAO) {
		this.propertyValueDAO = propertyValueDAO;
	}

	/**
	 * Spring configuration injection method.
	 * @param activityInstanceDAO
	 */
	public void setActivityInstanceDAO(ActivityInstanceDAO activityInstanceDAO) {
		this.activityInstanceDAO = activityInstanceDAO;
	}

	/**
	 *  * @see ProcessExecutionController#executeTask(String, long, List)
	 */
	@SuppressWarnings(UNCHECKED)
	public void executeTask(String userid, long taskId,
			List<FieldData> fieldData) throws Fault {

		// Check claim
		Map claimMap = Hazelcast.getMap(HazelcastConsts.CLAIMED_ACTIVITY_MAP);
		String key = userid + "::" + taskId;
		ActivityInstance ai = (ActivityInstance) claimMap.get(key);
		if (ai == null) {
			throw new Fault("activity not claimed");
		}

		// What's the definition of the activity we are executing?
		ActivityDefinition ad = ai.getActivityDefinition();
		log.debug("activity type: " + ad.getName());

		// All properties supplied
		Set<PropertyValue> props = verifyActivityPropertiesSupplied(ai, ad,
				fieldData);

		// Persist data, and update state to complete
		Map completedActivitiesMap = Hazelcast
				.getMap(HazelcastConsts.COMPLETED_ACTIVITIES_MAP);
		completedActivitiesMap.put(taskId, props);

		// Activate next state
		updateProcessActivityStates(ad, ai);

		// Release claim
		claimMap.remove(userid + "::" + taskId);

	}

	@SuppressWarnings(UNCHECKED)
	private void updateProcessActivityStates(ActivityDefinition ad,
			ActivityInstance ai) {
		// Get the activity instance
		long pid = ai.getProcessInstance().getProcessinstanceid();

		IMap activityConnectorsMap = Hazelcast
				.getMap(HazelcastConsts.CONNECTOR_DEF_MAP);
		List<ConnectorDefinition> connectors = (List<ConnectorDefinition>) activityConnectorsMap
				.get(ad.getActivitydefinitionid());

		Iterator<ConnectorDefinition> itor = connectors.iterator();

		// Activate connected activities
		// TODO - include expression evaluation
		ProcessInstance pi = ai.getProcessInstance();
		while (itor.hasNext()) {
			long sink = itor.next().getSinkid();
			log.debug("+++++get activity associated with sink " + sink
					+ "for process" + pid + ", activity "
					+ ai.getActivityinstanceid());
			ActivityInstance connectedActivity = getActivity(pi, sink);
			log.debug("change activity instance "
					+ connectedActivity.getActivityinstanceid() + " to active");
			connectedActivity.setState(ActivityState.ACTIVE.getCode());
		}

	}

	private ActivityInstance getActivity(ProcessInstance pi, long sink) {
		Set<ActivityInstance> activities = pi.getActivityInstances();
		Iterator<ActivityInstance> itor = activities.iterator();
		while (itor.hasNext()) {
			ActivityInstance ai = itor.next();
			if (ai.getActivityDefinition().getActivitydefinitionid() == sink) {
				return ai;
			}
		}

		return null;
	}

	@SuppressWarnings(UNCHECKED)
	private Set<PropertyValue> verifyActivityPropertiesSupplied(
			ActivityInstance ai, ActivityDefinition ad,
			List<FieldData> fieldData) throws Fault {
		Map propDefMap = Hazelcast.getMap(HazelcastConsts.PROP_DEF_MAP);
		Set<PropertyValue> props = new HashSet<PropertyValue>();

		Set<ActivityProperty> ap = ad.getActivityProperties();
		if (ap == null) {
			log.debug("$$$no properties on definition");
			if (fieldData != null && fieldData.size() > 0) {
				throw new Fault("ExtraProperties");
			}
			return props;
		}

		if (fieldData == null) {
			log.debug("$$$no properties supplied for call");
			throw new Fault("MissingProperties");
		} else {

			log.debug("supplied props size: " + fieldData.size());
			if (ap.size() != fieldData.size()) {
				throw new Fault("WrongNumberOfProperties");
			}
		}

		HashMap<String, FieldData> suppliedProps = new HashMap<String, FieldData>();
		Iterator<FieldData> fieldDataItor = fieldData.iterator();
		while (fieldDataItor.hasNext()) {
			FieldData fd = fieldDataItor.next();
			suppliedProps.put(fd.getName(), fd);
		}

		Iterator<ActivityProperty> defItor = ap.iterator();
		while (defItor.hasNext()) {
			ActivityProperty defProp = defItor.next();
			PropertyDefinition propDef = (PropertyDefinition) propDefMap
					.get(defProp.getId().getPropertydefinitionid());
			String propName = propDef.getName();
			log.debug("$$$check for property '" + propName + "'");
			FieldData fd = suppliedProps.get(propName);
			if (fd == null) {
				throw new Fault("MissingProperties");
			} else {
				PropertyValue pv = new PropertyValue();
				pv.setActivityInstance(ai);
				pv.setName(propName);
				pv.setValue(fd.getValue());
				pv.setPropertyDefinition(propDef);
				props.add(pv);
			}
		}

		return props;

	}

	/**
	 * @see ProcessExecutionController#claimActivity(String, String)
	 */
	public long claimActivity(String userid, String swimlaneName) {

		BlockingQueue<ActivityInstance> q = Hazelcast.getQueue(swimlaneName);
		log.debug("queue size before poll: " + q.size());
		ActivityInstance claimed = q.poll();
		if (claimed == null) {
			return -1L;
		} else {
			Map<String, ActivityInstance> claimedMap = Hazelcast
					.getMap(HazelcastConsts.CLAIMED_ACTIVITY_MAP);
			String key = userid + "::" + claimed.getActivityinstanceid();
			claimedMap.put(key, claimed);
			return claimed.getActivityinstanceid();
		}

	}

	/**
	 * @see ProcessExecutionController#releaseClaim(String, long)
	 */
	public void releaseClaim(String userid, long activityId) {
		// activityClaimDAO.releaseClaim(userid, activityId);
		log.debug("releaseClaim called for user " + userid + ", activityId "
				+ activityId);
		Map<String, ActivityInstance> claimedMap = Hazelcast
				.getMap(HazelcastConsts.CLAIMED_ACTIVITY_MAP);
		String key = userid + "::" + activityId;
		ActivityInstance ai = claimedMap.get(key);
		if (ai != null) {
			log.debug("put activity back into queue");
			String swimlaneName = ai.getSwimlane().getName();
			log.debug("getting queue for swimlane " + swimlaneName);
			BlockingQueue<ActivityInstance> q = Hazelcast
					.getQueue(swimlaneName);
			if (q != null) {
				q.offer(ai);
			}
		}

	}

	/**
	 * @see ProcessExecutionController#instantiateProcess(String, String)
	 */
	@SuppressWarnings(UNCHECKED)
	public long instantiateProcess(String userid, String processName)
			throws Fault {
		log.debug("instantiate an instance of " + processName);

		// Check process name
		Map processDefMap = Hazelcast.getMap(HazelcastConsts.PROCESS_DEF_MAP);
		ProcessDefinition processDef = (ProcessDefinition) processDefMap
				.get(processName);
		if (processDef == null) {
			throw new Fault("UnknownProcessDefinition");
		}

		// Process ok - create an instance
		ProcessInstance pi = new ProcessInstance();
		pi.setProcessDefinition(processDef);

		// Create the activity set
		Set<ActivityInstance> activities = new HashSet<ActivityInstance>();
		pi.setActivityInstances(activities);

		// Loop through the activities - start activity is created in an active
		// state, others are created in a pending state.
		Set<ActivityDefinition> activityDefs = processDef
				.getActivityDefinitions();
		for (ActivityDefinition ad : activityDefs) {
			log.debug("activity name: '" + ad.getName() + "' in swimlane '"
					+ ad.getSwimlaneid() + "'");

			ActivityInstance ai = new ActivityInstance();
			activities.add(ai);
			ai.setActivityDefinition(ad);
			ai.setProcessInstance(pi);
			ai.setProcessDefinition(processDef);
			if (ad.getIsstart()) {
				ai.setState(ActivityState.ACTIVE.getCode());
			} else {
				ai.setState(ActivityState.PENDING.getCode());
			}
			Map swimlaneDefMap = Hazelcast
					.getMap(HazelcastConsts.SWIMLANE_DEF_MAP);
			Swimlane swimlane = (Swimlane) swimlaneDefMap.get(ad
					.getSwimlaneid());
			ai.setSwimlane(swimlane);

		}

		// Persist the process
		long id = System.currentTimeMillis();
		pi.setProcessinstanceid(id);
		Map processInstanceMap = Hazelcast
				.getMap(HazelcastConsts.PROCESS_INSTANCE_MAP);
		processInstanceMap.put(id, pi);
		// TODO - map backer processInstanceDAO.persist(pi);

		// Return the process id
		return pi.getProcessinstanceid();
	}

	/**
	 * @see ProcessExecutionController#retrieveTask(long)
	 */
	public Task retrieveTask(long activityId) {
		Task task = null;
		ActivityInstance ai = activityInstanceDAO.retrieve(activityId);
		if (ai != null) {
			task = new Task(ai);
		}

		return task;
	}

	/**
	 * @see ProcessExecutionController#retrieveTaskList(long)
	 */
	public List<Task> retrieveTaskList(long swimlaneId) {
		List<ActivityInstance> instances = activityInstanceDAO
				.retrieveInstancesAtSwimlane(swimlaneId);
		List<Task> taskList = new ArrayList<Task>();
		Iterator<ActivityInstance> itor = instances.iterator();
		while (itor.hasNext()) {
			taskList.add(new Task(itor.next()));
		}

		return taskList;
	}

	/**
	 * @see ProcessExecutionController#findInstances(List)
	 */
	public List<Long> findInstances(List<FieldData> fieldVals) {
		return propertyValueDAO.findInstancesByPropertyValues(fieldVals);
	}

	/**
	 * @see ProcessExecutionController#retrieveTaskList(long)
	 */
	public List<Task> retrieveProcessTaskList(long processId, long swimlaneId) {
		List<ActivityInstance> instances = activityInstanceDAO
				.retrieveInstancesAtSwimlaneForProcess(swimlaneId, processId);
		List<Task> taskList = new ArrayList<Task>();
		Iterator<ActivityInstance> itor = instances.iterator();
		while (itor.hasNext()) {
			taskList.add(new Task(itor.next()));
		}

		return taskList;
	}

}
