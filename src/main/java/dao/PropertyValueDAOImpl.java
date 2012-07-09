package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityInstance;
import domain.FieldData;

/**
 * Concrete implementation of the PropertyValueDAO interface using the Hibernate ORM.
 * @see PropertyValueDAO
 */
public final class PropertyValueDAOImpl extends HibernateDaoSupport implements PropertyValueDAO {
	private static Log log = LogFactory.getLog(PropertyValueDAOImpl.class);
	

	
	@SuppressWarnings("unchecked")
	public List<Long> findInstancesByPropertyValues(List<FieldData> fields) {
		log.debug("findInstancesByPropertyValues called");
		Session session = getSession(false);
		try {
			Criteria criteria = 
				session.createCriteria(ActivityInstance.class)
					.createCriteria("propertyValues");
			Iterator<FieldData> itor = fields.iterator();
			LogicalExpression le = null;
			boolean first = true;
			while(itor.hasNext()) {
				FieldData fd = itor.next();
				LogicalExpression current = Restrictions.and(
					Restrictions.eq("name", fd.getName()),
					Restrictions.eq("value", fd.getValue()));
				
				if(!first) {
					le = Restrictions.or(le, current);
				} else {
					first = false;
					le = current;
				}
				
			}
			
			criteria.add(le);
			
			List found = criteria.list();
			Map<Long,Long> resultsMap = new HashMap<Long,Long>();
			
			Iterator foundItor = found.iterator();
			while(foundItor.hasNext()) {
				ActivityInstance ai = (ActivityInstance) foundItor.next();
				logger.debug("activity instance id: " + ai.getActivityinstanceid());
				long pid = ai.getProcessInstance().getProcessinstanceid();
				logger.debug("process instance id: " + pid );
				resultsMap.put(pid, pid);
			}
			
			Set keySet = resultsMap.keySet();
			List<Long> result = new ArrayList<Long>();
			if(keySet != null) {
				Iterator<Long> keyItor = keySet.iterator();
				while(keyItor.hasNext()) {
					result.add(keyItor.next());
				}
			}
			
			return result;
			
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}

	}

}
