
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
	private static TopologicalSorter sorter;
	private static CriticalPathCalculator criticalPath = new CriticalPathCalculator();
	private static List<String> outputData = new ArrayList<String>();
    private static ExecuteTimeCalculator timeCalculator = new ExecuteTimeCalculator(1);
	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException {

		String fileName = new String ("Edges_30_72.txt");
		graph = DataReader.graphCreator(fileName);
		
		sorter = new TopologicalSorter(graph);

		timeCalculator.setStartTime(System.nanoTime());
		List<Node<Milestone>> sortNodes= sorter.sortKhansAlgortithm();
		timeCalculator.setTopologicalSortingTime(System.nanoTime());
		List<EdgeProperties<Milestone>> listOfActivities = criticalPath.properties(sortNodes);
		timeCalculator.setCPMTime(System.nanoTime());
			
		outputData.add(graph.toString());
		for (int i = 0 ; i<listOfActivities.size(); i++)
			outputData.add(listOfActivities.get(i).toString());
		outputData.addAll(timeCalculator.getExecuteTimes());
		DataWriter writer = new DataWriter(fileName, outputData);
	}
	

}