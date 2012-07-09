package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.PropertyDefinition;

/**
 * Concrete implementation of the PropertyDefinitionDAO interface using the Hibernate ORM.
 * @see PropertyDefinitionDAO
 */
public final class PropertyDefinitionDAOImpl extends HibernateDaoSupport implements PropertyDefinitionDAO {

	private static Log log = LogFactory.getLog(PropertyDefinitionDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<PropertyDefinition> retrieveList() {
		Session session = getSession(false);
		try {
			log.debug("*************retrieveList");
			Query query = session.createQuery("from domain.PropertyDefinition");
			query.setCacheable(true);
			query.setCacheRegion("propQueryRegion");
			return query.list();
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	public void persist(PropertyDefinition pd) {
		Session session = getSession(false);
		try {
			log.debug("*************saveOrUpdate " + pd.getName());
			session.saveOrUpdate(pd);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public PropertyDefinition retrieve(String name) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + name);
			List propDefs = session.createCriteria(PropertyDefinition.class)
				.setCacheable(true)
				.add( Restrictions.eq("name", name))
				.list();
			//TODO - guard against non-unique names
			return (PropertyDefinition) propDefs.get(0);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	
	public PropertyDefinition retrieve(long id) {
		Session session = getSession(false);
		try {
			log.debug("*************retrieve " + id);
			
			return (PropertyDefinition) session.get(PropertyDefinition.class, id);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}
	

}
