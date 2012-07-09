package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityDefinition;


/**
 * Implementation of the activity definition DAO interface. This version goes against a relational
 * database using the Hibernate ORM.
 * @see ActivityDefinitionDAO
 */
public final class ActivityDefinitionDAOImpl extends HibernateDaoSupport implements ActivityDefinitionDAO
{
	private static Log log = LogFactory.getLog(ActivityDefinitionDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public ActivityDefinition retrieve(String name) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + name);
			List propDefs = session.createCriteria(ActivityDefinition.class)
				.setCacheable(true)
				.add( Restrictions.eq("name", name))
				.list();
			//TODO - guard against non-unique names
			return (ActivityDefinition) propDefs.get(0);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}
	
}
