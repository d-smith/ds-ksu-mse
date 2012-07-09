package hazelcast;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import dao.ProcessDefinitionDAO;
import domain.ProcessDefinition;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see ProcessDefMapStore
 */
@Transactional
public final class ProcessDefMapStoreDelegateImpl implements
MapStore<String, ProcessDefinition>, MapLoader<String, ProcessDefinition>, ApplicationContextAware {

	private static Log log = LogFactory.getLog(ProcessDefMapStoreDelegateImpl.class);
	private static ApplicationContext ctx;
	private ProcessDefinitionDAO processDefinitionDAO;
	

	public static ApplicationContext getAppCtx() {
		return ctx;
	}

	public void setProcessDefinitionDAO(
			ProcessDefinitionDAO processDefinitionDAO) {
		this.processDefinitionDAO = processDefinitionDAO;
	}

	public void delete(String key) {
		log.warn("unimplemented delete called with " + key);
		throw new NotImplementedException("delete unimplemented");
	}

	public void deleteAll(Collection<String> keys) {
		log.warn("unimplemented deleteAll called");
		throw new NotImplementedException("deleteAll unimplemented");
	}

	public void store(String arg0, ProcessDefinition arg1) {
		log.warn("unimplemented store called");
		throw new NotImplementedException("storeAll unimplemented");
	}

	public void storeAll(Map<String, ProcessDefinition> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("storeAll unimplemented");

	}

	public ProcessDefinition load(final String key) {
		log.debug("load");
		return processDefinitionDAO.retrieveProcessDefinition(key);
	}

	public Map<String, ProcessDefinition> loadAll(Collection<String> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx) {
		log.debug("app context set");
		ctx = theCtx;

	}

}
