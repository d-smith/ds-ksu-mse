package service;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import util.AppConfigFactory;
import domain.stats.Statistic;


public class HibernateStatsTest extends TestCase {

	public void testGetStats()
	{
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		
		HibernateStats stats = (HibernateStats) ctx.getBean("hibernateStatsBean");
		List<Statistic> statsList = stats.getStats();   
		assertNotNull(statsList);
		for(Statistic stat : statsList)
		{
			assertNotNull("null stat name", stat.getName());
			assertNotNull("null stat value", stat.getValue());
		}
	}
}
