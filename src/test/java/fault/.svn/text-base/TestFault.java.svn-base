package fault;

import junit.framework.TestCase;

public class TestFault extends TestCase {
	public void testFaultStuff() {
		Fault theFault = new Fault("theCode");
		assertEquals("unexpected code", theFault.getCode(), "theCode");
		theFault.setCode("anotherCode");
		assertEquals("unexpected code", theFault.getCode(), "anotherCode");
	}
}
