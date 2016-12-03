
public class Node {
	
	private int Number;
	private String name;
	private int earliestStart;
	private int earliestFinish;
	private int latestStart;
	private int latestFinish;	
	
	
	public Node(int number, String name) {
		Number = number;
		this.name = name;
	}
	
	
	public Node(int number) {
		Number = number;
	}


	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
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
	
	
	

	
	
	

}
