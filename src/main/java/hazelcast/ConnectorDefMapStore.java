package hazelcast;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.ConnectorDefinition;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the connector
 * definitions map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class ConnectorDefMapStore implements MapStore<Long, List<ConnectorDefinition>>, MapLoader<Long, List<ConnectorDefinition>> {
	
	
	//ProcessDefMapStoreDelegate delegate;
	private MapStore<Long, List<ConnectorDefinition>> store;
	private MapLoader<Long, List<ConnectorDefinition>> loader;
	
	
	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	public MapStore<Long, List<ConnectorDefinition>> getStore() {
		if(store == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			store = (MapStore<Long, List<ConnectorDefinition>>)ctx.getBean("connectorDefMapDelegate");
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
	public MapLoader<Long, List<ConnectorDefinition>> getLoader() {
		if(loader == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			loader = (MapLoader<Long, List<ConnectorDefinition>>)ctx.getBean("connectorDefMapDelegate");
		}
		return loader;
	}



	

	public void delete(Long key) {
		getStore().delete(key);	
	}

	public void deleteAll(Collection<Long> keys) {
		getStore().deleteAll(keys);
	}

	public void store(Long key, List<ConnectorDefinition> value) {
		getStore().store(key, value);
		
	}

	public void storeAll(Map<Long, List<ConnectorDefinition>> pairs) {
		getStore().storeAll(pairs);
		
	}


	public List<ConnectorDefinition> load(Long key) {
		return getLoader().load(key);
	}


	public Map<Long, List<ConnectorDefinition>> loadAll(Collection<Long> keys) {
		return getLoader().loadAll(keys);
	}

}
