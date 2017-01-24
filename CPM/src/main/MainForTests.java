
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

public class MainForTests {

	
	private static ArrayList <Graph <Milestone>> graphs = new ArrayList();
	private static ArrayList <TopologicalSorter> sorters = new ArrayList();
	private static Graph <Milestone> graph;
	private static TopologicalSorter sorter = new TopologicalSorter();
	private static CriticalPathCalculator criticalPath = new CriticalPathCalculator();
	private static List<String> outputData = new ArrayList<String>();
    private static ExecuteTimeCalculator timeCalculator; 
	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException {

		List<Node<Milestone>> sortNodes = null;
		List<EdgeProperties<Milestone>> listOfActivities = null;
		int repeat = 1000;
		timeCalculator = new ExecuteTimeCalculator(repeat);
		for(int i = 0; i<repeat; i++){
			TopologicalSorter sorter = new TopologicalSorter();
			sorters.add(sorter);
			}
		for(int i = 0; i<repeat; i++){
			graph = DataReader.graphCreator("Edges 20 32.txt");
			graphs.add(graph);
			}
		timeCalculator.setStartTime(System.nanoTime());
		for(int i =0; i<repeat; i++) {
			sortNodes = sorters.get(i).sortKhansAlgortithm(graphs.get(i));
		}
		
		timeCalculator.setTopologicalSortingTime(System.nanoTime());
		for(int i = 0; i<repeat; i++)
			listOfActivities = criticalPath.properties(sortNodes);
		timeCalculator.setCPMTime(System.nanoTime());
			
		outputData.add(graph.toString());
		for (int i = 0 ; i<listOfActivities.size(); i++)
			outputData.add(listOfActivities.get(i).toString());
		outputData.addAll(timeCalculator.getExecuteTimes());
		DataWriter writer = new DataWriter("Edges 20 32.txt", outputData);
	}
	

}