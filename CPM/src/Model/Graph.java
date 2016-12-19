package Model;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Milestone> nodesList;

	public Graph(ArrayList<Milestone> nodesList) {
		this.nodesList = nodesList;
	}

	public Graph(int numberOfNodes) {
		for (int i = 0; i < numberOfNodes; i++) {
		 nodesList.add(new Milestone(i));
		}
	}
	
	public void addAction(Action act){
		
	}

}
