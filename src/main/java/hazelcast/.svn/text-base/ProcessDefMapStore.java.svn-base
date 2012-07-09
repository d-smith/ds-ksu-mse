package hazelcast;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import domain.ProcessDefinition;

/**
 * This class provides the MapStore/MapLoader hazelcast
 * class used to configure the backing store for the process
 * definitions map.
 * @see <a href="http://hazelcast.googlecode.com/svn/javadoc/index.html">Hazelcast API Documentation</a>
 */
public final class ProcessDefMapStore implements MapStore<String, ProcessDefinition>, MapLoader<String, ProcessDefinition> {
	
	
	//ProcessDefMapStoreDelegate delegate;
	private MapStore<String, ProcessDefinition> store;
	private MapLoader<String, ProcessDefinition> loader;
	private static Log log = LogFactory.getLog(ProcessDefMapStore.class);
	
	/**
	 * Get the actual spring managed store configuration. This lazy-loads the
	 * spring configuration on first access, to avoid race conditions with
	 * spring loading and hazelcast instantiation.
	 * @return MapStore implementation.
	 */
	@SuppressWarnings("unchecked")
	private MapStore<String, ProcessDefinition> getStore() {
		if(store == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			store = (MapStore<String, ProcessDefinition>)ctx.getBean("processDefMapDelegate");
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
	private MapLoader<String, ProcessDefinition> getLoader()
	{
		if(loader == null) {
			ApplicationContext ctx = ProcessDefMapStoreDelegateImpl.getAppCtx();
			loader = (MapLoader<String, ProcessDefinition>)ctx.getBean("processDefMapDelegate");
		}
		
		return loader;
	}

	public ProcessDefMapStore() {
		log.info("ProcessDefMapStore.<init> invoked");
	}
	

	public void delete(String key) {
		getStore().delete(key);	
	}

	public void deleteAll(Collection<String> keys) {
		getStore().deleteAll(keys);
	}

	public void store(String key, ProcessDefinition value) {
		getStore().store(key, value);
		
	}

	public void storeAll(Map<String, ProcessDefinition> pairs) {
		getStore().storeAll(pairs);
		
	}


	public ProcessDefinition load(String key) {
		return getLoader().load(key);
	}


	public Map<String, ProcessDefinition> loadAll(Collection<String> keys) {
		return getLoader().loadAll(keys);
	}

}
