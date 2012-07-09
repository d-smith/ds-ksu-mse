package domain;


/**
 * Class representing the data associated with an activity claim.
 *
 */
public final class ActivityClaim implements java.io.Serializable {


	private static final long serialVersionUID = -9047015838091026950L;
	private ActivityClaimId id;

	public ActivityClaim() {
	}

	public ActivityClaim(ActivityClaimId id) {
		this.id = id;
	}

	public ActivityClaimId getId() {
		return this.id;
	}

	public void setId(ActivityClaimId id) {
		this.id = id;
	}

}
