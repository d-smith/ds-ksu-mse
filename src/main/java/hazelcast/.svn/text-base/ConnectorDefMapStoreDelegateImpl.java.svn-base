package hazelcast;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

import dao.ConnectorDefinitionDAO;
import domain.ConnectorDefinition;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see ConnectorDefMapStore
 */
@Transactional
public final class ConnectorDefMapStoreDelegateImpl implements
MapStore<Long, List<ConnectorDefinition>>, MapLoader<Long, List<ConnectorDefinition>>, ApplicationContextAware {

	private static Log log = LogFactory.getLog(ConnectorDefMapStoreDelegateImpl.class);
	private static ApplicationContext ctx;
	private ConnectorDefinitionDAO connectorDefinitionDAO;
	

	public static ApplicationContext getAppCtx() {
		return ctx;
	}

	public void setConnectorDefinitionDAO(
			ConnectorDefinitionDAO connectorDefinitionDAO) {
		this.connectorDefinitionDAO = connectorDefinitionDAO;
	}

	public void delete(Long key) {
		log.warn("unimplemented delete called with " + key);
		throw new NotImplementedException("delete unimplemented");
	}

	public void deleteAll(Collection<Long> keys) {
		log.warn("unimplemented deleteAll called");
		throw new NotImplementedException("deleteAll unimplemented");
	}

	public void store(Long arg0, List<ConnectorDefinition> arg1) {
		log.warn("unimplemented store called");
		throw new NotImplementedException("storeAll unimplemented");
	}

	public void storeAll(Map<Long, List<ConnectorDefinition>> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("storeAll unimplemented");

	}

	public List<ConnectorDefinition> load(final Long key) {
		log.debug("load");
		return connectorDefinitionDAO.getConnectedByActivityId(key);
	}

	public Map<Long, List<ConnectorDefinition>> loadAll(Collection<Long> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx) {
		log.debug("app context set");
		ctx = theCtx;

	}

}
