package service;

import java.util.List;

import javax.jws.WebService;

import domain.stats.Statistic;

/**
 * Service interface for the hibernate stats service. This 
 * service provides an interface for obtaining hiberate 
 * statistics from a running instance.
 */
@WebService(name="hibernateStats",
		targetNamespace="http://people.cis.ksu.edu/dougs")
public interface HibernateStats {
	/**
	 * getStats Get Hibernate statistics.
	 * @return List of Hibernate statistics, each statistic wrapped
	 * in a Statistic value object.
	 */
	List<Statistic> getStats();
}
