package hazelcast;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.PropertyDefinition;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the property
 * definitions map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class PropertyDefMapStore implements MapStore<Long, PropertyDefinition>, MapLoader<Long, PropertyDefinition> {
	
	
	//ProcessDefMapStoreDelegate delegate;
	private MapStore<Long, PropertyDefinition> store;
	private MapLoader<Long, PropertyDefinition> loader;
	
	
	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapStore<Long, PropertyDefinition> getStore() {
		if(store == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			store = (MapStore<Long, PropertyDefinition>)ctx.getBean("propertyDefMapDelegate");
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
	public MapLoader<Long, PropertyDefinition> getLoader() {
		if(loader == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			loader = (MapLoader<Long, PropertyDefinition>)ctx.getBean("propertyDefMapDelegate");
		}
		return loader;
	}

	

	public void delete(Long key) {
		getStore().delete(key);	
	}

	public void deleteAll(Collection<Long> keys) {
		getStore().deleteAll(keys);
	}

	public void store(Long key, PropertyDefinition value) {
		getStore().store(key, value);
		
	}

	public void storeAll(Map<Long, PropertyDefinition> pairs) {
		getStore().storeAll(pairs);
		
	}


	public PropertyDefinition load(Long key) {
		return getLoader().load(key);
	}


	public Map<Long, PropertyDefinition> loadAll(Collection<Long> keys) {
		return getLoader().loadAll(keys);
	}

}
