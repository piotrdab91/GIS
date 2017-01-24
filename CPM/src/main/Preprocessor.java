package main;

import Model.Graph;
import Model.Milestone;
import graphAlgorithms.TopologicalSorter;

public class Preprocessor {
	private TopologicalSorter sorter;
	private Graph<Milestone> graph;
	
	
	public Preprocessor(TopologicalSorter sorter, Graph<Milestone> graph) {
		this.sorter = sorter;
		this.graph = graph;
	}
	
	public void adjustGraph(){
		//sorter..
		
	}
	

}
