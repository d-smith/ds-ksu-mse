package dao;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IdGenerator;

import domain.ActivityInstance;
import domain.ProcessInstance;

/**
 * Concrete implementaton of the ProcessInstanceDAO interface using the Hibernte ORM.
 * @see ProcessInstanceDAO
 *
 */
public final class ProcessInstanceDAOImpl extends HibernateDaoSupport implements ProcessInstanceDAO {
	private static Log log = LogFactory.getLog(ProcessInstanceDAOImpl.class);
	private IdGenerator idGenerator;
	
	public ProcessInstanceDAOImpl() {
		idGenerator = Hazelcast.getIdGenerator("activity-instance-ids");
	}
	
	public void persist(ProcessInstance pi) {
		Session session = getSession(false);
		try {
			
			log.debug("save process " + pi.getProcessinstanceid());
			session.saveOrUpdate(pi);
			
			log.debug("save activities...");
			Set<ActivityInstance> activities = pi.getActivityInstances();
			Iterator<ActivityInstance> itor = activities.iterator();
			//
			// NOTE: when persisting these in the write behind thread that hazelcast manages, the
			//       id generator is not called, resulting in integrity constraint violations.
			long baselineActivityId = System.currentTimeMillis();
			while(itor.hasNext()) {
				ActivityInstance ai = itor.next();
				ai.setActivityinstanceid(baselineActivityId + idGenerator.newId()); //Added to work around issue - see NOTE above
				ai.setProcessDefinition(pi.getProcessDefinition());
				ai.setProcessInstance(pi);
				session.saveOrUpdate(ai);
			}
		} catch(HibernateException e) {
			throw convertHibernateAccessException(e);
		}

	}

}
