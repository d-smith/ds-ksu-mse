package service;

import java.util.List;

import javax.jws.WebService;

import domain.stats.PerformanceStatistic;

/**
 * Service interface for obtaining application performance
 * stats captured via Jamon instrumentation.
 */
@WebService(name="performanceStats",
		targetNamespace="http://people.cis.ksu.edu/dougs")
public interface PerformanceStats {
	/**
	 * getStats Get a list of perfirmance statistics.
	 * @return List of performance statistics embedded in 
	 * PerformanceStatistic value objects.
	 */
	List<PerformanceStatistic> getStats();
	
	/**
	 * Reset performance counters.
	 */
	void reset();
}
