package service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import fault.Fault;
import util.AppConfigFactory;
import domain.FieldData;
import domain.marshall.Task;

public class ProcessExecutionSvcTest extends TestCase {
	private void writeBehindDelay() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void testIntantiateProcess() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		try {
			long pid = pe.instantiateProcess("u1", "update beneficiary v2");
			assertFalse("invalid process id", pid == -1);
			// Not needed - run with write behind wait configured to 0 -->
			// writeBehindDelay();
		} catch (Fault e) {
			assertFalse("fault generated", true);
		}
	}

	public void testClaimAndExecuteTask() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		try {
			long activityId = pe.claimActivity("u1", "Scan dept");
			assertFalse("no activity claimed", activityId == -1);
			pe.releaseClaim("u1", activityId);
			activityId = pe.claimActivity("u1", "Scan dept");
			assertFalse("no activity claimed", activityId == -1);

			pe.executeTask("u1", activityId, createFieldData(true, false));
		} catch (Fault e) {
			assertFalse("fault generated: " + e.getCode(), true);
		}
	}

	public void testClaimAndExecuteTaskWithMissingProperties() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		try {
			long activityId = pe.claimActivity("u1", "Scan dept");
			pe.executeTask("u1", activityId, createFieldData(false, false));
			assertFalse("expected exception - didn't happen", true);
		} catch (Fault e) {
			assertTrue("fault generated: " + e.getCode(), true);
		}
	}
	
	public void testClaimAndExecuteTaskWithBadPropertyName() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		try {
			long activityId = pe.claimActivity("u1", "Scan dept");
			pe.executeTask("u1", activityId, createFieldData(true, true));
			assertFalse("expected exception - didn't happen", true);
		} catch (Fault e) {
			assertTrue("fault generated: " + e.getCode(), true);
		}
	}
	
	public void testRetrieveList() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);
		

		List<Task> taskList = pe.retrieveTaskList("u1", 1);
		assertNotNull("task list is null", taskList);
		assertTrue("task list empty", taskList.size() > 0);
		
	}

	public void testBadClaim() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		long activityId = pe.claimActivity("flibbidy foo", "Scabby dept");
		assertTrue("no activity claimed", activityId == -1);

	}

	public void testListAndRetrieve() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);

		long pid;
		try {
			pid = pe.instantiateProcess("u1", "update beneficiary v2");
			assertFalse("invalid process id", pid == -1);

			List<Task> taskList = pe.retrieveProcessTaskList("u1", pid, 1);
			assertNotNull("task list is null", taskList);
			assertTrue("task list empty", taskList.size() > 0);
			
			for(Task task : taskList) {
				Task rt = pe.retrieveTask("u1", task.getActivityId());
				assertNotNull(rt);
			}
		} catch (Fault e) {
			assertFalse("unexpected exception: " + e.getCode(), true);
		}
	}
	
	public void testFind() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		ProcessExecution pe = (ProcessExecution) ctx
				.getBean("processExecutionBean");
		assertNotNull(pe);
		
		List<FieldData> fieldVals = new ArrayList<FieldData>();
		FieldData fd = new FieldData();
		fd.setName("p1");
		fd.setValue("p1");
		fieldVals.add(fd);
		List<Long> idList = pe.findInstances("u1", fieldVals );
		assertNotNull(idList);
		assertTrue("empty list", idList.size() > 0);
	}

	private List<FieldData> createFieldData(boolean all, boolean badName) {
		List<FieldData> fieldData = new ArrayList<FieldData>();

		FieldData p1 = new FieldData();
		if(!badName) {
			p1.setName("p1");
		} else {
			p1.setName("fooby dooby do");
		}
		p1.setValue("p1");
		fieldData.add(p1);

		FieldData p2 = new FieldData();
		p2.setName("p2");
		p2.setValue("p2");
		fieldData.add(p2);

		FieldData p3 = new FieldData();
		p3.setName("p3");
		p3.setValue("p3");
		fieldData.add(p3);

		FieldData p4 = new FieldData();
		p4.setName("p4");
		p4.setValue("p4");
		fieldData.add(p4);

		FieldData p5 = new FieldData();
		p5.setName("p5");
		p5.setValue("p5");
		fieldData.add(p5);

		FieldData p6 = new FieldData();
		p6.setName("p6");
		p6.setValue("p6");
		fieldData.add(p6);

		FieldData p7 = new FieldData();
		p7.setName("p7");
		p7.setValue("p7");
		fieldData.add(p7);

		FieldData p8 = new FieldData();
		p8.setName("p8");
		p8.setValue("p8");
		fieldData.add(p8);

		FieldData p9 = new FieldData();
		p9.setName("p9");
		p9.setValue("p9");
		fieldData.add(p9);

		if (all) {
			FieldData p10 = new FieldData();
			p10.setName("p10");
			p10.setValue("p10");
			fieldData.add(p10);
		}

		return fieldData;
	}
}
