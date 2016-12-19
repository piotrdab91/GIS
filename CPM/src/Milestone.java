
public class Milestone extends Node {
	
	private int numberAfterSort; 
	private String name;

	private int earliestStart;
	private int earliestFinish;
	private int latestStart;
	private int latestFinish;

	public Milestone(int number) {
		super(number);
		this.earliestStart = 0;
		this.earliestFinish = 0;
		this.latestFinish = 0;
		this.latestStart = 0;
	}

	public Milestone(int number, String name) {
		super(number);
		this.name= name;
		this.earliestStart = 0;
		this.earliestFinish = 0;
		this.latestFinish = 0;
		this.latestStart = 0;
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
	

}
