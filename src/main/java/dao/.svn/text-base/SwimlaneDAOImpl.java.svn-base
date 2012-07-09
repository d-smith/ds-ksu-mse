package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Swimlane;

/**
 * Concrete implementation of the SwimlaneDAO interface using the Hibernate ORM.
 * @see SwimlaneDAO
 *
 */
public final class SwimlaneDAOImpl extends HibernateDaoSupport implements SwimlaneDAO {
	private static Log log = LogFactory.getLog(SwimlaneDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public Swimlane retrieve(String name) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + name);
			List propDefs = session.createCriteria(Swimlane.class)
				.setCacheable(true)
				.add( Restrictions.eq("name", name))
				.list();
			//TODO - guard against non-unique names
			return (Swimlane) propDefs.get(0);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Swimlane retrieveById(long swimlaneId) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + swimlaneId);
			List propDefs = session.createCriteria(Swimlane.class)
				.setCacheable(true)
				.add( Restrictions.eq("swimlaneid", swimlaneId))
				.list();
			//TODO - guard against non-unique names
			return (Swimlane) propDefs.get(0);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
