package dao;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityClaim;
import domain.ActivityClaimId;

/**
 * Implementation of the activity claim DAO interface. This version goes against a relational
 * database using the Hibernate ORM.
 * @see ActivityClaimDAO
 */
public final class ActivityClaimDAOImpl extends HibernateDaoSupport implements
		ActivityClaimDAO {
	private static Log log = LogFactory
			.getLog(ActivityClaimDAOImpl.class);

	public void claimActivity(String userid, long activityId) {
		log.debug("claimActivity called for user " + userid + ", activityID " + activityId);
		Session session = getSession(false);
		try {
			ActivityClaim claim = new ActivityClaim(new ActivityClaimId(userid,
					activityId));
			session.save(claim);
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);

		}
	}

	public void releaseClaim(String userid, long activityId) {
		log.debug("releaseClaim called for user " + userid + ", activityID " + activityId);
		Session session = getSession(false);
		try {
			ActivityClaim claim = new ActivityClaim(new ActivityClaimId(userid,
					activityId));
			session.delete(claim);
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public boolean activityClaimed(String userid, long activityId) {
		log.debug("activityClaimed called for user " + userid + ", activityID " + activityId);
		Session session = getSession(false);
		try {
			List claims = session.createCriteria(ActivityClaim.class).add(
					Restrictions.eq("id.userid", userid)).add(
					Restrictions.eq("id.activityinstanceid", activityId))
					.list();

			boolean activityClaimed = false;
			if (claims.size() > 0) {
				activityClaimed = true;

				Iterator itor = claims.iterator();
				while (itor.hasNext()) {
					session.evict(itor.next());
				}
			}

			return activityClaimed;

		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
