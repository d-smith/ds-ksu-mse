package hazelcast;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import dao.ActivityInstanceDAO;
import domain.PropertyValue;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see CompletedActivitiesMapStore
 */
@Transactional
public final class CompletedActivitiesMapStoreImpl implements MapStore<Long, Set<PropertyValue>>, MapLoader<Long, Set<PropertyValue>>, ApplicationContextAware {


	private static Log log = LogFactory
			.getLog(CompletedActivitiesMapStoreImpl.class);
	private static ApplicationContext ctx;
	private ActivityInstanceDAO activityInstanceDAO;
	
	
	
	public void setActivityInstanceDAO(ActivityInstanceDAO activityInstanceDAO) {
		this.activityInstanceDAO = activityInstanceDAO;
	}

	public void delete(Long arg0) {
		//No need to delete from the backing store
	}

	public void deleteAll(Collection<Long> arg0) {
		//No need to delete from the backing store
	}

	public void store(Long key, Set<PropertyValue> values) {
		log.debug("Write behind storing activity properties");
		activityInstanceDAO.updatePropertiesForCompleted(key, values);
		
	}

	public void storeAll(Map<Long, Set<PropertyValue>> allMap) {
		
		Set<Long> keys = allMap.keySet();
		for(Long key : keys) {
			Set<PropertyValue> props = allMap.get(key);
			store(key, props);
		}
	}

	public Set<PropertyValue> load(Long arg0) {
		throw new NotImplementedException("load unimplemented");
	}

	public Map<Long, Set<PropertyValue>> loadAll(Collection<Long> arg0) {
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx)  {
		ctx = theCtx;
		
	}
	
	public static ApplicationContext getAppCtx() {
		return ctx;
	}

}
