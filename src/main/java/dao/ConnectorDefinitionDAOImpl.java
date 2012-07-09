package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityDefinition;
import domain.ConnectorDefinition;

/** 
 * Concrete implementation of the ConnectorDefinitionDAO interface, using Hibernate ORM.
 * @see ConnectorDefinitionDAO
 *
 */
public final class ConnectorDefinitionDAOImpl extends HibernateDaoSupport 
									implements ConnectorDefinitionDAO {

	private static Log log = LogFactory.getLog(ConnectorDefinitionDAOImpl.class);
	
	public List<ConnectorDefinition> getConnected(ActivityDefinition ad) {
		return getConnectedByActivityId(ad.getActivitydefinitionid());
	}

	@SuppressWarnings("unchecked")
	public ConnectorDefinition getConnectorDefinition(long connectorId) {
		Session session = getSession(false);
		try {
			log.debug("*************getConnector");
			List connected = 
				session.createCriteria(ConnectorDefinition.class)
				.setCacheable(true)
				.add(Restrictions.eq("connectorid", connectorId))
				.list();
			return (ConnectorDefinition) connected.get(0);
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ConnectorDefinition> getConnectedByActivityId(long activityDefinitionId) {
		Session session = getSession(false);
		try {
			log.debug("*************getConnected");
			List connected = 
				session.createCriteria(ConnectorDefinition.class)
				.setCacheable(true)
				.add(Restrictions.eq("sourceid", activityDefinitionId))
				.list();
			return connected;
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	

}
