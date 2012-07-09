package domain;

/**
 * Representation of an activity role id.
 *
 */
public final class ActivityRoleId implements java.io.Serializable {



	private static final long serialVersionUID = 8706999331703460042L;
	private long processdefinitionid;
	private long activitydefinitionid;

	public ActivityRoleId() {
	}

	public ActivityRoleId(long processdefinitionid, long activitydefinitionid) {
		this.processdefinitionid = processdefinitionid;
		this.activitydefinitionid = activitydefinitionid;
	}

	public long getProcessdefinitionid() {
		return this.processdefinitionid;
	}

	public void setProcessdefinitionid(long processdefinitionid) {
		this.processdefinitionid = processdefinitionid;
	}

	public long getActivitydefinitionid() {
		return this.activitydefinitionid;
	}

	public void setActivitydefinitionid(long activitydefinitionid) {
		this.activitydefinitionid = activitydefinitionid;
	}


}
