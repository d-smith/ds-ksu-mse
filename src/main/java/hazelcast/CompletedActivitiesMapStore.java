package hazelcast;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.PropertyValue;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the completed
 * activities map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class CompletedActivitiesMapStore implements MapStore<Long, Set<PropertyValue>>, MapLoader<Long, Set<PropertyValue>> {
	
	
	//ProcessDefMapStoreDelegate delegate;
	private MapStore<Long, Set<PropertyValue>> store;
	private MapLoader<Long, Set<PropertyValue>> loader;
	
	

	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapStore<Long, Set<PropertyValue>> getStore() {
		if(store == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			store = (MapStore<Long, Set<PropertyValue>>)ctx.getBean("completedActivitiesMapDelegate");
		}
		return store;
	}


	/**
	 * Get the actual spring managed loader configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapLoader implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapLoader<Long, Set<PropertyValue>> getLoader() {
		if(loader == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			loader = (MapLoader<Long, Set<PropertyValue>>)ctx.getBean("completedActivitiesMapDelegate");
		}
		return loader;
	}

	

	public void delete(Long key) {
		getStore().delete(key);	
	}

	public void deleteAll(Collection<Long> keys) {
		getStore().deleteAll(keys);
	}

	public void store(Long key, Set<PropertyValue> value) {
		getStore().store(key, value);
		
	}

	public void storeAll(Map<Long, Set<PropertyValue>> pairs) {
		getStore().storeAll(pairs);
		
	}


	public Set<PropertyValue> load(Long key) {
		return  getLoader().load(key);
	}


	public Map<Long, Set<PropertyValue>> loadAll(Collection<Long> keys) {
		return  getLoader().loadAll(keys);
	}

}
