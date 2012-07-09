package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityInstance;
import domain.ActivityState;
import domain.PropertyValue;

/**
 * Concrete implementation of the ActivityInstanceDAO interface, using the Hibernate
 * ORM.
 * @see ActivityInstanceDAO
 */
public final class ActivityInstanceDAOImpl extends HibernateDaoSupport implements
		ActivityInstanceDAO {


	public void update(long activityId, Set<PropertyValue> propertyValues,
			ActivityState newState) {
		Session session = getSession(false);
		try {
			ActivityInstance activityInstance = retrieve(activityId);
			activityInstance.setState(newState.getCode());

			Iterator<PropertyValue> itor = activityInstance.getPropertyValues()
					.iterator();
			while (itor.hasNext()) {
				session.delete(itor.next());
			}
			activityInstance.setPropertyValues(propertyValues);

			session.saveOrUpdate(activityInstance);
			itor = activityInstance.getPropertyValues().iterator();
			while (itor.hasNext()) {
				session.saveOrUpdate(itor.next());
			}
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}

	}

	public ActivityInstance retrieve(long activityId) {
		Session session = getSession(false);
		try {
			return (ActivityInstance) session.get(ActivityInstance.class,
					activityId);

		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ActivityInstance> retrieveInstancesAtSwimlane(long swimlaneId) {
		Session session = getSession(false);
		try {

			return (List<ActivityInstance>) session.createCriteria(
					ActivityInstance.class).add(
					Restrictions.eq("swimlane.swimlaneid", swimlaneId)).list();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ActivityInstance> retrieveInstancesAtSwimlaneForProcess(
			long swimlaneId, long processId) {
		Session session = getSession(false);
		try {

			return (List<ActivityInstance>) session.createCriteria(
					ActivityInstance.class).add(
					Restrictions.eq("swimlane.swimlaneid", swimlaneId)).add(
					Restrictions.eq("processInstance.processinstanceid",
							processId)).list();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	public void updatePropertiesForCompleted(long key, Set<PropertyValue> values) {
		update(key, values, ActivityState.COMPLETE);

	}

}
