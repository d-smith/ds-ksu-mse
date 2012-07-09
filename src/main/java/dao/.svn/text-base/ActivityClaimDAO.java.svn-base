package dao;

/**
 * Interface defining data access for activity claims.
 */
public interface ActivityClaimDAO {
	/**
	 * Write a claim for an activity. Note only unclaimed activities can be claimed.
	 * @param userid Id of the user the claim is owned by
	 * @param activityId Id of the claimed activity
	 * @exception When someone else has the claim or if no activity can be found
	 * for the specified activityId 
	 */
	void claimActivity(String userid, long activityId);
	
	/**
	 * Release an activity claim. Note only the owner of a claim may release a claim.
	 * @param userid Id of the user the claim is owned by
	 * @param activityId Id of the claimed activity
	 * @exception When the user does not have the activity claimed, or the activity
	 * ID is invalid.
	 */
	void releaseClaim(String userid, long activityId);
	
	/**
	 * Predicate to determine if an activity is claimed by the given user.
	 * @param userid Id of the user to check claim against.
	 * @param activityId Id of the activity to determine if it is claimed by the user.
	 * @return True if claimed, false if not claimed.
	 */
	boolean activityClaimed(String userid, long activityId);
}
