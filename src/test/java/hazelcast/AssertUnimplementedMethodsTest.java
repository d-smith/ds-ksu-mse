package hazelcast;

import junit.framework.TestCase;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.context.ApplicationContext;

import util.AppConfigFactory;

/**
 * This test class is to formalize the methods that will not be provided from a
 * Hazelcast map and store standpoint. If any are implemented, failure in this
 * test case will indicate the need for unit tests.
 * 
 */
public class AssertUnimplementedMethodsTest extends TestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		assertNotNull(ctx);
	}

	public void testSwimlaneMapUnimplemented() {
		SwimlaneDefMapStore swimlaneMapStore = new SwimlaneDefMapStore();
		try {
			swimlaneMapStore.delete(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			swimlaneMapStore.deleteAll(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			swimlaneMapStore.store(1L, null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			swimlaneMapStore.storeAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}

	public void testPropertyDefMapUnimplemented() {
		PropertyDefMapStore store = new PropertyDefMapStore();
		try {
			store.delete(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.deleteAll(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.store(1L, null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.storeAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}

	public void testProcessDefMapUnimplemented() {
		ProcessDefMapStore store = new ProcessDefMapStore();
		try {
			store.delete(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.deleteAll(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.store(null, null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.storeAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}

	public void testConnectorDefMapUnimplemented() {
		ConnectorDefMapStore store = new ConnectorDefMapStore();
		try {
			store.delete(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.deleteAll(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.store(1L, null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.storeAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}

	public void testProcessInstanceMapUnimplemented() {
		ProcessInstanceMapStore store = new ProcessInstanceMapStore();
		try {
			store.delete(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.deleteAll(null);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.load(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.loadAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}

	public void testCompletedActivitiesMapStoreUnimplemented() {
		CompletedActivitiesMapStore store = new CompletedActivitiesMapStore();

		//Call the no-ops to cover them - note no exception is thrown
		store.delete(1L); 
		store.deleteAll(null);

		try {
			store.load(1L);
			fail();
		} catch (NotImplementedException e) {
		}

		try {
			store.loadAll(null);
			fail();
		} catch (NotImplementedException e) {
		}
	}
}
