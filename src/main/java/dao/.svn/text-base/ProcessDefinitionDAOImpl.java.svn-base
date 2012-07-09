package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ProcessDefinition;

/**
 * Concrete implementation of ProcessDefinitionDAO using the Hibernate ORM.
 * @see ProcessDefinitionDAO
 *
 */
public final class ProcessDefinitionDAOImpl extends HibernateDaoSupport implements ProcessDefinitionDAO {

	private static Log log = LogFactory.getLog(ProcessDefinitionDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public ProcessDefinition retrieveProcessDefinition(String name) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + name);
			List propDefs = session.createCriteria(ProcessDefinition.class)
			.setCacheable(true)
				.add( Restrictions.eq("name", name))
				.list();
			//TODO - guard against non-unique names
			if(propDefs == null || propDefs.size() == 0) {
				return null;
			} else {
				return (ProcessDefinition) propDefs.get(0);
			}
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
