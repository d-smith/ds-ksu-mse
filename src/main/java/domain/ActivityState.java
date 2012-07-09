package domain;

/**
 * Representation of the states of an activity. Activities are instantiated when a process
 * is instantiated in an active or pending state, and are marked completed when done.
 *
 */
public enum ActivityState {
	PENDING(0), ACTIVE(1), COMPLETE(2);
	
	private int state;
	
	private ActivityState(int stateCode) {
		state = stateCode;
	}
	
	public int getCode() {
		return state;
	}
}
