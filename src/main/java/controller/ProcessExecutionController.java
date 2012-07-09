package controller;

import java.util.List;

import fault.Fault;
import domain.FieldData;
import domain.marshall.Task;

/**
 * This interface defines the process execution runtime transaction scripts
 * offered by the system.
 *
 */
public interface ProcessExecutionController {
	/**
	 * Execute a task, providing the data associated with the task execution. 
	 * The system applies the field data associated with the task to the persistent 
	 * state of the task, and updates the state of the task based on the process 
	 * definition. If indicated by the process definition, other tasks may be 
	 * activated, or the process may be terminated.
	 * @param username User identity associated with the operation.
	 * @param taskId Identifier of the task being updated.
	 * @param fieldData Field data associated with the execution of this task instance.
	 * @throws Fault If an error occurs in the execution of this method.
	 */
	void executeTask(String username, long taskId, List<FieldData> fieldData) throws Fault;
	
	/**
	 * Claim an activity to work on.
	 * @param userid User requesting work.
	 * @param swimlaneName Swimlane from which to pull work. Swimlanes in this implementation
	 * represent logical collections of work in the context of a process definition.
	 * @return The task id of the work claimed by the user if a task is available
	 * (greater than 0), -1 if no task is available.
	 */
	long claimActivity(String userid, String swimlaneName);
	
	/**
	 * Release a claimed task.
	 * @param userid User releasing the claim.
	 * @param activityId Task/activity id being released.
	 */
	void releaseClaim(String userid, long activityId);
	
	/**
	 * Instantiate a process.
	 * @param userid Identity of the user instantiating the process.
	 * @param processName Name of the process being instantiated.
	 * @return Process id of the process that was instantiated.
	 * @throws Fault If the process could not be instantiated.
	 */
	long instantiateProcess(String userid, String processName) throws Fault;
	
	/**
	 * Retrieve the data associated with a task
	 * @param activityId 
	 * @return Data associated with the specified task if a valid id is given, a
	 * null object if no task with the given id is found.
	 */
	Task retrieveTask(long activityId);
	
	/**
	 * List the tasks associated with the given swimlane
	 * @param swimlaneId Identifier of the swimlane of interest
	 * @return List of tasks
	 */
	List<Task> retrieveTaskList(long swimlaneId);
	
	/**
	 * Retrieve a list of tasks associated with a given process instance at a given swimlane.
	 * @param processId Process instance id
	 * @param swimlaneId Swimlane id
	 * @return List of tasks associated with the specific process instance at the given
	 * swimland
	 */
	List<Task> retrieveProcessTaskList(long processId, long swimlaneId);
	
	/**
	 * Search for process instances based on field data
	 * @param fieldVals Collection of field name/value pairs used as search criteria
	 * @return List of process instances matching search criteria
	 */
	List<Long> findInstances(List<FieldData> fieldVals);
}
