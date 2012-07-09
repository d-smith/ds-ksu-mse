package hazelcast;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.Swimlane;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the swimlane
 * definitions map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class SwimlaneDefMapStore implements MapStore<Long, Swimlane>, MapLoader<Long, Swimlane> {

	//ProcessDefMapStoreDelegate delegate;
	private MapStore<Long, Swimlane> store;
	private MapLoader<Long, Swimlane> loader;
	
	

	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapStore<Long, Swimlane> getStore() {
		if(store == null) {
			ApplicationContext ctx = SwimlaneDefMapStoreImpl.getAppCtx();
			store = (MapStore<Long, Swimlane>)ctx.getBean("swimlaneDefMapDelegate");
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
	public MapLoader<Long, Swimlane> getLoader() {
		if(loader == null) {
			ApplicationContext ctx = SwimlaneDefMapStoreImpl.getAppCtx();
			loader = (MapLoader<Long, Swimlane>)ctx.getBean("swimlaneDefMapDelegate");
		}
		return loader;
	}

	

	public void delete(Long key) {
		getStore().delete(key);	
	}

	public void deleteAll(Collection<Long> keys) {
		getStore().deleteAll(keys);
	}

	public void store(Long key, Swimlane value) {
		getStore().store(key, value);
		
	}

	public void storeAll(Map<Long, Swimlane> pairs) {
		getStore().storeAll(pairs);
		
	}


	public Swimlane load(Long key) {
		return getLoader().load(key);
	}


	public Map<Long, Swimlane> loadAll(Collection<Long> keys) {
		return getLoader().loadAll(keys);
	}
}
