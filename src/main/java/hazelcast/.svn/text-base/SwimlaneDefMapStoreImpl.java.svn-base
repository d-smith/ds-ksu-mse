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

import dao.SwimlaneDAO;
import domain.Swimlane;

/**
 * This class implements the spring managed MapStore/MapLoader delegated
 * to by the hazelcast managed MapStore/MapLoader class.
 * @see SwimlaneDefMapStore
 */
@Transactional
public final class SwimlaneDefMapStoreImpl implements MapStore<Long, Swimlane>,
		MapLoader<Long, Swimlane>, ApplicationContextAware {

	private static Log log = LogFactory
			.getLog(SwimlaneDefMapStoreImpl.class);
	private static ApplicationContext ctx;
	private SwimlaneDAO swimlaneDAO;
	
	public void setSwimlaneDAO(SwimlaneDAO swimlaneDAO) {
		this.swimlaneDAO = swimlaneDAO;
	}
	

	public void delete(Long arg0) {
		log.warn("unimplemented delete called");
		throw new NotImplementedException("delete unimplemented");

	}

	public void deleteAll(Collection<Long> arg0) {
		log.warn("unimplemented deleteAll called");
		throw new NotImplementedException("deleteAll unimplemented");

	}

	public void store(Long arg0, Swimlane arg1) {
		log.warn("unimplemented store called");
		throw new NotImplementedException("store unimplemented");

	}

	public void storeAll(Map<Long, Swimlane> arg0) {
		log.warn("unimplemented storeAll called");
		throw new NotImplementedException("storeAll unimplemented");

	}

	public Swimlane load(Long key) {
		return swimlaneDAO.retrieveById(key);
	}

	public Map<Long, Swimlane> loadAll(Collection<Long> arg0) {
		log.warn("unimplemented loadAll called");
		throw new NotImplementedException("loadAll unimplemented");
	}

	public void setApplicationContext(ApplicationContext theCtx) {
		ctx = theCtx;
	}


	public static ApplicationContext getAppCtx() {
		return ctx;
	}

}
