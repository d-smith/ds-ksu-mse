package domain.marshall;

import java.io.Serializable;

/**
 * Simplified property name/value container class for
 * marshalling property values back to a client.
 */
public final class Property implements Serializable {
	
	private static final long serialVersionUID = -2785760767299705150L;
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
