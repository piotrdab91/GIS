package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Graph;
import Model.Milestone;

public class DataReader {
	
	public static Path fileToRead(){
		Path path = Paths.get("C:\\Users\\Patryk", "Edges.txt");
		return path;
	}
	
	public static Graph<Milestone> graphCreator() throws IOException{
		int numberOfNodes = numberOfNodesReader();
		int numberOfEdges = numberOfEdgesReader();

		Graph<Milestone> graph = new Graph <Milestone> (numberOfNodes, Milestone.class);
		
		String line = null;
		for (int i = 1 ; i <= numberOfEdges ; i++){
			line = Files.readAllLines(fileToRead()).get(i);
			beginReader(line);
	    	endReader(line);
	    	weightReader(line);	
	    	graph.addEdge(beginReader(line), endReader(line), weightReader(line));
		}	
	
		return graph;
	}

	
	public static int beginReader(String lineOfFile) throws IOException {
		int beginOfEdge=0;
		Pattern beginPattern = Pattern.compile("(.*)\\s+\\d+\\s+.*");
		Matcher beginMatcher = beginPattern.matcher(lineOfFile);
		if (beginMatcher.matches()) {
			beginOfEdge = Integer.parseInt(beginMatcher.group(1));		
		}
		return beginOfEdge;
	}
	
	public static int endReader(String lineOfFile) throws IOException {
		int endOfEdge=0;
		Pattern endPattern = Pattern.compile("\\d+\\s+(.*)\\s+.*");
		Matcher endMatcher = endPattern.matcher(lineOfFile);
		if (endMatcher.matches()) {
			endOfEdge = Integer.parseInt(endMatcher.group(1));		
		}
		return endOfEdge;
	}	
	
	public static double weightReader(String lineOfFile) throws IOException {
		double weightOfEdge=0.0;
		Pattern weightPattern = Pattern.compile("\\d+\\s+\\d+\\s+(.*)");
		Matcher weightMatcher = weightPattern.matcher(lineOfFile);
		if (weightMatcher.matches()) {
			weightOfEdge = Double.parseDouble(weightMatcher.group(1));		
		}
		return weightOfEdge;
	}
	
	public static int numberOfNodesReader() throws IOException {
		int numberOfNodes = 0;	
		String line = Files.readAllLines(fileToRead()).get(0);
		numberOfNodes = Integer.parseInt(line);
		return numberOfNodes + 1; // Adding one because first node has index 0.
	}
	
	public static int numberOfEdgesReader() throws IOException {
		int numberOfLines = 0;  
		numberOfLines = (int) Files.lines(fileToRead()).count();
		int numberOfEdges = numberOfLines -1; // Substracting one because first line of file isn't an edge.
		return numberOfEdges;	
	}
}
