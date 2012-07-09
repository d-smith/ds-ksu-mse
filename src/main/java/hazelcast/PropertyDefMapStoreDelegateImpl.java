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

import dao.PropertyDefinitionDAO;
import domain.PropertyDefinition;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see PropertyDefMapStore
 */
@Transactional
public final class PropertyDefMapStoreDelegateImpl implements
MapStore<Long, PropertyDefinition>, MapLoader<Long, PropertyDefinition>, ApplicationContextAware {

	private static Log log = LogFactory.getLog(PropertyDefMapStoreDelegateImpl.class);
	private static ApplicationContext ctx;
	private PropertyDefinitionDAO propertyDefinitionDAO;
	

	public static ApplicationContext getAppCtx() {
		return ctx;
	}

	public void setPropertyDefinitionDAO(
			PropertyDefinitionDAO propertyDefinitionDAO) {
		this.propertyDefinitionDAO = propertyDefinitionDAO;
	}

	public void delete(Long key) {
		log.warn("unimplemented delete called with " + key);
		throw new NotImplementedException("delete unimplemented");
	}

	public void deleteAll(Collection<Long> keys) {
		log.warn("unimplemented deleteAll called");
		throw new NotImplementedException("deleteAll unimplemented");
	}

	public void store(Long arg0, PropertyDefinition arg1) {
		log.warn("unimplemented store called");
		throw new NotImplementedException("storeAll unimplemented");
	}

	public void storeAll(Map<Long, PropertyDefinition> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("storeAll unimplemented");

	}

	public PropertyDefinition load(final Long key) {
		log.debug("load");
		return propertyDefinitionDAO.retrieve(key);
	}

	public Map<Long, PropertyDefinition> loadAll(Collection<Long> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx) {
		log.debug("app context set");
		ctx = theCtx;
	}

}
