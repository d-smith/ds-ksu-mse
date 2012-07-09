package domain;


/**
 * 
 * Representation of an activity property.
 *
 */
public final class ActivityProperty implements java.io.Serializable {


	private static final long serialVersionUID = 7328316441154960204L;
	private ActivityPropertyId id;

	public ActivityProperty() {
	}



	public ActivityPropertyId getId() {
		return this.id;
	}

	public void setId(ActivityPropertyId id) {
		this.id = id;
	}


}
