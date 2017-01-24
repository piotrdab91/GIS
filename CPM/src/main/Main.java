
package main;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

import Model.EdgeProperties;
import Model.Graph;
import Model.Milestone;
import Model.Node;
import graphAlgorithms.CriticalPathCalculator;
import graphAlgorithms.TopologicalSorter;

public class Main {

	
	private static Graph <Milestone> graph = new Graph<Milestone>(0,Milestone.class);
	private static TopologicalSorter sorter = new TopologicalSorter();
	private static CriticalPathCalculator criticalPath = new CriticalPathCalculator();
	private static List<String> outputData = new ArrayList<String>();
    private static ExecuteTimeCalculator timeCalculator = new ExecuteTimeCalculator(1);
	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException {

		System.out.println(graph.getNodesList().size());
		graph = DataReader.graphCreator("Edges.txt");
		
		//System.out.println(graph.g);
		timeCalculator.setStartTime(System.nanoTime());
		List<Node<Milestone>> sortNodes= sorter.sortKhansAlgortithm(graph);
		//List<Node<Milestone>> sortRoots=sorter.addRoots();
		//System.out.println(sortRoots);
		timeCalculator.setTopologicalSortingTime(System.nanoTime());
		List<EdgeProperties<Milestone>> listOfActivities = criticalPath.properties(sortNodes);
		timeCalculator.setCPMTime(System.nanoTime());
			
		outputData.add(graph.toString());
		for (int i = 0 ; i<listOfActivities.size(); i++)
			outputData.add(listOfActivities.get(i).toString());
		outputData.addAll(timeCalculator.getExecuteTimes());
		DataWriter writer = new DataWriter("Edges.txt", outputData);
	}
	

}