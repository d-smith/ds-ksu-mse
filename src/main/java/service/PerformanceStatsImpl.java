package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import domain.stats.PerformanceStatistic;

/**
 * Concrete implementation of the PerformanceStats service.
 * @see PerformanceStats
 */
public final class PerformanceStatsImpl implements PerformanceStats {
	private static Log log = LogFactory.getLog(PerformanceStatsImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<PerformanceStatistic> getStats() {
		List<PerformanceStatistic> stats = new ArrayList<PerformanceStatistic>();
		Iterator<Monitor> itor = MonitorFactory.getFactory().iterator();
		while(itor.hasNext()) {
			Monitor mon = itor.next();
			PerformanceStatistic stat = new PerformanceStatistic();
			stats.add(stat);
			stat.setCall(mon.getLabel());
			stat.setAvgTime(mon.getAvg());
			stat.setMaxTime(mon.getMax());
			stat.setMinTime(mon.getMin());
			stat.setNumberOfCalls(mon.getHits());
			
			log.info(mon);
		}
		
		return stats;
	}

	public void reset() {
		MonitorFactory.getFactory().reset();
		
	}

}
