package service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fault.Fault;
import domain.FieldData;
import domain.marshall.Task;

/**
 * Service interface for process execution operations.
 */
@WebService(name = "processExecution", targetNamespace = "http://people.cis.ksu.edu/dougs")
public interface ProcessExecution {
	 String USERID = "userid";
	 String TASKID = "taskId";
	 String FIELD_DATA = "fieldData";
	 String SWIMLANE_NAME = "swimlaneName";
	 String PROCESS_NAME = "processName";
	 String SWIMLANE_ID = "swimlaneId";
	 String PROCESS_ID = "processId";
	 String FIELDS = "fields";
	
	/**
	 * Execute a task (activity instance)
	 * @param userId User invoking the operation.
	 * @param taskId Identification of the task being executed.
	 * @param fieldData Data associated with the task instance.
	 * @throws Fault If an exception is generated during task executuion.
	 */
	void executeTask(@WebParam(header = true, name = USERID) String userId,
			@WebParam(name=TASKID) long taskId, 
			@WebParam(name=FIELD_DATA)List<FieldData> fieldData) throws Fault;

	/**
	 * Claim an activity.
	 * @param userid User invoking the operation.
	 * @param swimlaneName Swimlane to claim an activity from.
	 * @return Id of the activity assigned as claimed to the user. Note
	 * a value of -1 denotes no activity was available.
	 */
	long claimActivity(
			@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=SWIMLANE_NAME) String swimlaneName);

	/**
	 * Release an activity claim.
	 * @param userid User invoking the operation.
	 * @param taskId Id of the claimed task being released.
	 */
	void releaseClaim(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=TASKID)long taskId);
	
	/**
	 * Instantiate a process instance.
	 * @param userid User invoking the operation.
	 * @param processName Name of the process being instantiated.
	 */
	long instantiateProcess(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=PROCESS_NAME) String processName) throws Fault;
	
	/**
	 * Retrieve a task.
	 * @param userid User invoking the operation.
	 * @param activityId Id of the activity beibg retrieved.
	 * @return Task value object containing the data associated with the activity/task.
	 */
	Task retrieveTask(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=TASKID) long activityId);
	/**
	 * Retrieve a list of the tasks in the specified swimlane.
	 * @param userid User invokving the operation.
	 * @param swimlaneId Swimlane of interest.
	 * @return List of Task value objects containing the data associated 
	 * with the activity instances in the specified swimlane.
	 */
	List<Task> retrieveTaskList(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=SWIMLANE_ID) long swimlaneId);
	
	/**
	 * Retrieve a list of tasks at a swimland associated with a specific
	 * process instance.
	 * @param userid User invoking the operation.
	 * @param processId Process instance id to retrieve tasks for.
	 * @param swimlaneId Id of the swimlane from which to retrieve tasks.
	 * @return List of tasks matching the input criteria.
	 */
	List<Task> retrieveProcessTaskList(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=PROCESS_ID) long processId,
			@WebParam(name=SWIMLANE_ID) long swimlaneId);
	
	/**
	 * Find process instances containing field values matching specified
	 * values.
	 * @param userid User invoking the operation.
	 * @param fieldVals List of values encoded in FieldData value objects.
	 * @return List of process instance ids for matching process instances.
	 */
	List<Long> findInstances(@WebParam(header = true, name = USERID) String userid,
			@WebParam(name=FIELDS)List<FieldData> fieldVals);
}
