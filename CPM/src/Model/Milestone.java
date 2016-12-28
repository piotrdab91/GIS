package Model;

public class Milestone {
	
	private int numberAfterSort; 
	private String name;
	private int inDegree;


	private int earliestStart;
	private int earliestFinish;
	private int latestStart;
	private int latestFinish;
	
	
	public Milestone() {}

	public Milestone(String name) {
		this.name = name;
	}

	public Milestone( String name, int earliestStart, int earliestFinish, int latestStart,
			int latestFinish) {
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
	public int getEarliestStart() {
		return earliestStart;
	}
	public void setEarliestStart(int earliestStart) {
		this.earliestStart = earliestStart;
	}
	public int getEarliestFinish() {
		return earliestFinish;
	}
	public void setEarliestFinish(int earliestFinish) {
		this.earliestFinish = earliestFinish;
	}
	public int getLatestStart() {
		return latestStart;
	}
	public void setLatestStart(int latestStart) {
		this.latestStart = latestStart;
	}
	public int getLatestFinish() {
		return latestFinish;
	}
	public void setLatestFinish(int latestFinish) {
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
