package domain;

import junit.framework.TestCase;

public class FieldDataTest extends TestCase {
	public void testFieldData() {
		FieldData fd = new FieldData("name", "value");
		FieldData fd2 = new FieldData();
		fd2.setName(fd.getName());
		fd2.setValue(fd.getValue());
		assertEquals("name not equals", fd.getName(), fd2.getName());
		assertEquals("value not equals", fd.getValue(), fd2.getValue());
	}
}
