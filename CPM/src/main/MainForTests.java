
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
	private static TopologicalSorter sorter = new TopologicalSorter(graph);
	private static CriticalPathCalculator criticalPath = new CriticalPathCalculator();
	private static List<String> outputData = new ArrayList<String>();
    private static ExecuteTimeCalculator timeCalculator; 
	public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException {

		List<Node<Milestone>> sortNodes = null;
		List<EdgeProperties<Milestone>> listOfActivities = null;
		int repeat = 1000;
		
		String fileName = new String("Edges_80_100.txt");
		timeCalculator = new ExecuteTimeCalculator(repeat);
		
		for(int i = 0; i<repeat; i++){
			graph = DataReader.graphCreator(fileName);
			graphs.add(graph);
			}
		for(int i = 0; i<repeat; i++){
			TopologicalSorter sorter = new TopologicalSorter(graphs.get(i));
			sorters.add(sorter);
			}
		timeCalculator.setStartTime(System.nanoTime());
		for(int i =0; i<repeat; i++) {
			sortNodes = sorters.get(i).sortKhansAlgortithm();
		}
		
		timeCalculator.setTopologicalSortingTime(System.nanoTime());
		for(int i = 0; i<repeat; i++)
			listOfActivities = criticalPath.properties(sortNodes);
		timeCalculator.setCPMTime(System.nanoTime());
			
		/*outputData.add(graph.toString());
		for (int i = 0 ; i<listOfActivities.size(); i++)
			//outputData.add(listOfActivities.get(i).toString());*/
		outputData.addAll(timeCalculator.getExecuteTimes());
		DataWriter writer = new DataWriter((fileName+"_test"), outputData);
	}
	

}