package service;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import util.AppConfigFactory;
import domain.stats.PerformanceStatistic;

public class PerformanceStatsSvcTest extends TestCase {
	public void testGetStats() {
		ApplicationContext ctx = AppConfigFactory.getAppContext();
		PerformanceStats service = (PerformanceStats) ctx
				.getBean("performanceStatsBean");
		assertNotNull(service);

		PropertyDefinitionSvc propDefService = (PropertyDefinitionSvc) ctx
				.getBean("propertyDefinitionBean");
		assertNotNull(propDefService);

		@SuppressWarnings("unused")
		List<domain.PropertyDefinition> props = propDefService.retrieveList();

		List<PerformanceStatistic> statsList = service.getStats();
		for(PerformanceStatistic stat : statsList) {
			assertTrue(stat.getAvgTime() >= 0);
			assertTrue(stat.getCall() != null);
			assertTrue(stat.getMaxTime() >= 0);
			assertTrue(stat.getMinTime() >= 0);
			assertTrue(stat.getNumberOfCalls() >=0);
		}
		assertNotNull(statsList);
		assertTrue("empty list returned", statsList.size() > 0);
		
		service.reset();
		statsList = service.getStats();
		assertNotNull(statsList);
	}
}
