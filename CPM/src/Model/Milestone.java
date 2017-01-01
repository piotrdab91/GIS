package Model;

public class Milestone {
	
	private int numberAfterSort; 
	private String name;
	private int inDegree;

	private double earliestStart;
	private double earliestFinish;
	private double latestStart;
	private double latestFinish;
		
	public Milestone() {}

	public Milestone(String name) {
		this.name = name;
	}

	public Milestone( String name, double earliestStart, double earliestFinish, double latestStart,
			double latestFinish) {
		this.name = name;
		this.earliestStart = earliestStart;
		this.earliestFinish = earliestFinish;
		this.latestStart = latestStart;
		this.latestFinish = latestFinish;
	}

	public int getNumberAfterSort() {
		return numberAfterSort;
	}
	
	public void setNumberAfterSort(int numberAfterSort) {
		this.numberAfterSort = numberAfterSort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getEarliestStart() {
		return earliestStart;
	}
	public void setEarliestStart(double earliestStart) {
		this.earliestStart = earliestStart;
	}
	public double getEarliestFinish() {
		return earliestFinish;
	}
	public void setEarliestFinish(double earliestFinish) {
		this.earliestFinish = earliestFinish;
	}
	public double getLatestStart() {
		return latestStart;
	}
	public void setLatestStart(double latestStart) {
		this.latestStart = latestStart;
	}
	public double getLatestFinish() {
		return latestFinish;
	}
	public void setLatestFinish(double latestFinish) {
		this.latestFinish = latestFinish;
	}
	public int getInDegree() {
		return inDegree;
	}

	public void incInDegree() {
		this.inDegree++;
	}
	public void decInDegree() {
		this.inDegree--;
	}

	

}
