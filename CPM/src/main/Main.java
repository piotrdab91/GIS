package main;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;

import Model.Graph;
import Model.Milestone;
import graphAlgorithms.TopologicalSorter;

public class Main {

	private static Graph <Milestone> graph = new Graph<Milestone>(1,Milestone.class);
	private static TopologicalSorter sorter = new TopologicalSorter();
	
	public static void main(String[] args) throws IOException {
		DataReader dataReader = new DataReader();
		graph = dataReader.graphCreator("Edges.txt");
	
		try {
			sorter.sortKhansAlgortithm(graph);
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		
	}
	

}
