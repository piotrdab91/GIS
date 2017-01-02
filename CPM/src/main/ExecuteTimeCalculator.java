package main;

import java.util.ArrayList;

public class ExecuteTimeCalculator {
	private long startTime;
	private long topologicalSortingTime;
	private long CPMTime;
	private ArrayList<String> list = new ArrayList<String>();

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getTopologicalSortingTime() {
		return topologicalSortingTime;
	}

	public void setTopologicalSortingTime(long topologicalSortingTime) {
		this.topologicalSortingTime = topologicalSortingTime;
	}

	public long getCPMTime() {
		return CPMTime;
	}

	public void setCPMTime(long cPMTime) {
		CPMTime = cPMTime;
	}

	public ArrayList<String> getExecuteTimes() {
		list.add("Czas sortowania: " + (topologicalSortingTime - startTime));
		list.add("Czas CPM: " + (CPMTime - topologicalSortingTime));
		list.add("Czas wykonania: " + (CPMTime - startTime));
		return list;
	}
}
