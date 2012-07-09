package fault;

/**
 * This class provides a representations of a soap fault. It
 * is used to throw exceptions back to clients.
 */
public final class Fault extends Exception {

	private static final long serialVersionUID = -5453668540933032930L;
	private String code;

	/**
	 * Construct a Fault instance with an error code.
	 * @param code Error code
	 */
	public Fault(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
