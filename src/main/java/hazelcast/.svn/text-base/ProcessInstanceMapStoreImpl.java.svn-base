package hazelcast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import dao.ProcessInstanceDAO;
import domain.ActivityInstance;
import domain.ProcessInstance;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see ProcessInstanceMapStore
 */
@Transactional
public final class ProcessInstanceMapStoreImpl implements MapStore<Long, ProcessInstance>, MapLoader<Long, ProcessInstance>, ApplicationContextAware {


	private static Log log = LogFactory
			.getLog(SwimlaneDefMapStoreImpl.class);
	private static ApplicationContext ctx;
	private ProcessInstanceDAO processInstanceDAO;
	
	
	
	public void setProcessInstanceDAO(ProcessInstanceDAO processInstanceDAO) {
		this.processInstanceDAO = processInstanceDAO;
	}

	public void delete(Long arg0) {
		throw new NotImplementedException("delete unimplemented");
		
	}

	public void deleteAll(Collection<Long> arg0) {
		throw new NotImplementedException("deleteAll unimplemented");
		
	}

	public void store(Long key, ProcessInstance pi) {
		log.debug("Write behind storing process instance " + pi.getProcessinstanceid());
		Map<Long, ProcessInstance> map = new HashMap<Long, ProcessInstance>();
		map.put(key, pi);
		storeAll(map);
	}

	public void storeAll(Map<Long, ProcessInstance> allMap) {
		Collection<ProcessInstance> all = allMap.values();
		for(ProcessInstance instance : all) {
			processInstanceDAO.persist(instance);
			Set<ActivityInstance> activities = instance.getActivityInstances();
			Iterator<ActivityInstance> itor = activities.iterator();
			while(itor.hasNext()) {
				ActivityInstance ai = itor.next();
				BlockingQueue<ActivityInstance> q = Hazelcast.getQueue(ai.getSwimlane().getName());
				q.offer(ai);
			}
			
		}
		
	}

	public ProcessInstance load(Long arg0) {
		throw new NotImplementedException("load unimplemented");
	}

	public Map<Long, ProcessInstance> loadAll(Collection<Long> arg0) {
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx) {
		ctx = theCtx;
	}
	
	public static ApplicationContext getAppCtx() {
		return ctx;
	}

}
