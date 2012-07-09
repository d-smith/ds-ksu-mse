package domain;

import java.io.Serializable;

/**
 * Representation of field name/value pairs.
 */
public final class FieldData implements Serializable {
	
	private static final long serialVersionUID = -340850466659069376L;
	private String name;
	private String value;
	
	public FieldData() {
		
	}
	
	public FieldData(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
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
