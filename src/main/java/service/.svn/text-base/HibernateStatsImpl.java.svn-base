package service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.stat.CollectionStatistics;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.stats.Statistic;

/**
 * Concrete implementation of the Hibernate statistics 
 * service interface.
 * @see HibernateStats
 */
@WebService(endpointInterface="service.HibernateStats")
public final class HibernateStatsImpl extends HibernateDaoSupport implements HibernateStats {
	private static Log log = LogFactory.getLog(HibernateStatsImpl.class);

	public List<Statistic> getStats() {
		SessionFactory sf = getSessionFactory();
		List<Statistic> output = new ArrayList<Statistic>();
		
		Statistics stats = sf.getStatistics();
		Statistic.addStat(output, "QueryCacheHitCount", stats.getQueryCacheHitCount() + "");
		Statistic.addStat(output, "QueryCacheMissCount", stats.getQueryCacheMissCount() + "");
		Statistic.addStat(output, "QueryCachePutCount", stats.getQueryCachePutCount() + "");
		
		Statistic.addStat(output, "SecondLevelCacheHitCount", stats.getSecondLevelCacheHitCount() + "");
		Statistic.addStat(output, "SecondLevelCacheMissCount", stats.getSecondLevelCacheMissCount() + "");
		Statistic.addStat(output, "SecondLevelCachePutCount", stats.getSecondLevelCachePutCount() + "");
		
		String[] entityNames = stats.getEntityNames();
		for(int i = 0; i < entityNames.length; i++) {
			EntityStatistics es = stats.getEntityStatistics(entityNames[i]);
			Statistic.addStat(output, entityNames[i] + " fetch count", es.getFetchCount() + "");
			Statistic.addStat(output, entityNames[i] + " insert count", es.getInsertCount() + "");
			Statistic.addStat(output, entityNames[i] + " load count", es.getLoadCount() + "");
			Statistic.addStat(output, entityNames[i] + " update count", es.getUpdateCount() + "");
			
		}
		
		String[] collectionRoles = stats.getCollectionRoleNames();
		for(int i = 0; i < collectionRoles.length; i++) {
			String roleName = collectionRoles[i];
			CollectionStatistics collStats = stats.getCollectionStatistics(roleName);
			Statistic.addStat(output, roleName + " fetch count", collStats.getFetchCount() + "");
			Statistic.addStat(output, roleName + " load count", collStats.getLoadCount() + "");
			Statistic.addStat(output, roleName + " recreate count", collStats.getRecreateCount() + "");
			Statistic.addStat(output, roleName + " remove count", collStats.getRemoveCount() + "");
			Statistic.addStat(output, roleName + " update count", collStats.getUpdateCount() + "");
		}
		
		
		String[] regions  = sf.getStatistics().getSecondLevelCacheRegionNames();
		for(int i = 0; i < regions.length; i++) {
			log.info("Region: " + regions[i]);
			SecondLevelCacheStatistics slStats = sf.getStatistics().getSecondLevelCacheStatistics(regions[i]);
			log.info(slStats);
		}
		
		
		
		return output;
		
	}

}
