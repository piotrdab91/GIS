
package main;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;

import Model.EdgeProperties;
import Model.Graph;
import Model.Milestone;
import graphAlgorithms.CriticalPathCalculator;
import graphAlgorithms.TopologicalSorter;

public class Main {

	private static Graph <Milestone> graph = new Graph<Milestone>(1,Milestone.class);
	private static TopologicalSorter sorter = new TopologicalSorter();
	private static CriticalPathCalculator criticalPath = new CriticalPathCalculator();
	
	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException {
		
		graph = DataReader.graphCreator("Edges.txt");
		List<EdgeProperties<Milestone>> listOfActivities = criticalPath.properties(sorter.sortKhansAlgortithm(graph));
		
		for (int i = 0 ; i<listOfActivities.size(); i++){
			System.out.println(listOfActivities.get(i));
		}
		
	}
	

}