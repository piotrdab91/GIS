package main;

import java.util.ArrayList;

public class ExecuteTimeCalculator {
	private long startTime;
	private long topologicalSortingTime;
	private long CPMTime;
	private ArrayList<String> list = new ArrayList<String>();
	private int repeat;
	
	
	public ExecuteTimeCalculator(int repeat) {
		this.repeat = repeat;
	}

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
		long TimeSort = (topologicalSortingTime - startTime)/repeat;
		long TimeCPM = (CPMTime - topologicalSortingTime)/repeat;
		list.add("Czas sortowania: " + TimeSort);
		list.add("Czas CPM: " + TimeCPM);
		list.add("Czas wykonania: " + (TimeCPM+ TimeSort));
		list.add("liczba powtórzeń kazdej czesci algorymtmu:" + repeat);
		return list;
	}
}
