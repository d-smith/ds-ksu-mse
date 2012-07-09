package domain.stats;

import java.util.List;

/**
 * Value object used to hold statistic values expressed as
  * name/value pairs. Note there is utility in using this as opposed
  * to a generic name/value pair class based on how Java reflection
  * is used to build the web service WSDL.
  */
public final class Statistic {
	private String name;
	private String value;
	
	public Statistic() {
		
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

	public static void addStat(List<Statistic> output, String name,
			String value) {
		Statistic stat = new Statistic();
		stat.setName(name);
		stat.setValue(value);
		output.add(stat);
		
	}

	
	
}
