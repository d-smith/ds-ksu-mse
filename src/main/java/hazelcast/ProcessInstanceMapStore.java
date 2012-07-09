package hazelcast;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.ProcessInstance;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the process
 * instances map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class ProcessInstanceMapStore implements MapStore<Long, ProcessInstance>, MapLoader<Long, ProcessInstance> {

	//ProcessDefMapStoreDelegate delegate;
	private MapStore<Long, ProcessInstance> store;
	private MapLoader<Long, ProcessInstance> loader;
	
	
	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapStore<Long, ProcessInstance> getStore() {
		if(store == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			store = (MapStore<Long, ProcessInstance>)ctx.getBean("processInstanceMapDelegate");
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
	public MapLoader<Long, ProcessInstance> getLoader() {
		if(loader == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			loader = (MapLoader<Long, ProcessInstance>)ctx.getBean("processInstanceMapDelegate");
		}
		return loader;
	}


	
	
	
	public void delete(Long key) {
		getStore().delete(key);
		
	}

	public void deleteAll(Collection<Long> keys) {
		getStore().deleteAll(keys);
		
	}

	public void store(Long key, ProcessInstance pi) {
		getStore().store(key, pi);
		
	}

	public void storeAll(Map<Long, ProcessInstance> all) {
		getStore().storeAll(all);
		
	}

	public ProcessInstance load(Long key) {
		return getLoader().load(key);
	}

	public Map<Long, ProcessInstance> loadAll(Collection<Long> keys) {
		return getLoader().loadAll(keys);
	}

}
