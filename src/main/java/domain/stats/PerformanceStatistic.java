package domain.stats;

/**
 * Value object for holding performance statistics for
 * a service or method call.
 */
public final class PerformanceStatistic {
	private String call;
	private double numberOfCalls;
	private double avgTime;
	private double maxTime;
	private double minTime;
	public double getNumberOfCalls() {
		return numberOfCalls;
	}
	public void setNumberOfCalls(double numberOfCalls) {
		this.numberOfCalls = numberOfCalls;
	}
	public double getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(double avgTime) {
		this.avgTime = avgTime;
	}
	public double getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}
	public double getMinTime() {
		return minTime;
	}
	public void setMinTime(double minTime) {
		this.minTime = minTime;
	}
	
	public String getCall() {
		return call;
	}
	
	public void setCall(String call) {
		this.call = call;
	}
}
