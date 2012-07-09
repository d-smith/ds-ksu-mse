package service;

import java.util.List;

import javax.jws.WebService;

import fault.Fault;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import controller.ProcessExecutionController;
import domain.FieldData;
import domain.marshall.Task;

/**
 * Concrete implementation of the ProcessExecution service interface.
 * @see ProcessExecution
 */
@WebService(endpointInterface = "service.ProcessExecution")
public final class ProcessExecutionImpl implements ProcessExecution {

	private ProcessExecutionController processExecutionController;

	public void setProcessExecutionController(
			ProcessExecutionController processExecutionController) {
		this.processExecutionController = processExecutionController;
	}

	public void executeTask(String userid, long taskId,
			List<FieldData> fieldData) throws Fault {
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.executeTask");
		try {
			processExecutionController.executeTask(userid, taskId, fieldData);
		} finally {
			mon.stop();
		}
	}

	public void releaseClaim(String userid, long activityId) {
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.releaseClaim");
		try {
			processExecutionController.releaseClaim(userid, activityId);
		} finally {
			mon.stop();
		}

	}

	public long claimActivity(String userid, String swimlaneName) {
		long activityId;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.claimActivity");
		try {
			activityId = processExecutionController.claimActivity(userid, swimlaneName);

		} finally {
			mon.stop();
		}
		
		return activityId;
		
	}

	public long instantiateProcess(String userid, String processName)
			throws Fault {
		long processId = -1;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.instantiateProcess");
		try {
			processId = processExecutionController.instantiateProcess(userid,
					processName);
		} finally {
			mon.stop();
		}
		return processId;
	}

	public Task retrieveTask(String userid, long activityId) {
		Task task = null;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.retrieveTask");
		try {
			task = processExecutionController.retrieveTask(activityId);
		} finally {
			mon.stop();
		}
		return task;
	}

	public List<Task> retrieveTaskList(String userid, long swimlaneId) {
		List<Task> taskList = null;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.retrieveTaskList");
		try {
			taskList = processExecutionController.retrieveTaskList(swimlaneId);
		} finally {
			mon.stop();
		}
		return taskList;
	}

	public List<Long> findInstances(String userid, List<FieldData> fieldVals) {
		List<Long> instanceList = null;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.findInstances");
		try {
			instanceList = processExecutionController.findInstances(fieldVals);
		} finally {
			mon.stop();
		}
		return instanceList;
	}

	public List<Task> retrieveProcessTaskList(String userid, long processId,
			long swimlaneId) {
		List<Task> taskList = null;
		Monitor mon = MonitorFactory
				.start("service.ProcessExecution.retrieveProcessTaskList");
		try {
			taskList = processExecutionController.retrieveProcessTaskList(processId, swimlaneId);
		} finally {
			mon.stop();
		}
		return taskList;
	}

}
