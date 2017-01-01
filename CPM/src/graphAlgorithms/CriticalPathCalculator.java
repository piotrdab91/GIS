package graphAlgorithms;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.EdgeProperties;
import Model.Milestone;
import Model.Node;


public class CriticalPathCalculator {
	List<EdgeProperties<Milestone>> edgesWithProperties = new ArrayList<EdgeProperties<Milestone>>();
	
	public List<EdgeProperties<Milestone>> properties(List<Node<Milestone>> list){
		forwardPass(list);
		backwardPass(list);
		propertiesCalculator(list);
		return edgesWithProperties;
	}
	
	public void forwardPass(List<Node<Milestone>> list){
		for (int i = 1 ; i<list.size() ; i++){
			int ingoingEdges = list.get(i).getIngoingEdges().size();
			List<Double> possibleEarliestStarts = new ArrayList<Double>();
			
			for (int j = 0 ; j<ingoingEdges ; j++){
				double weightOfIngoingEdge = list.get(i).getIngoingEdges().get(j).getWeight();
				int numberOfPredecessor = list.get(i).getIngoingEdges().get(j).getStart().getNodeProperties().getNumberAfterSort();
				double predecessorEarliestStart = list.get(numberOfPredecessor).getNodeProperties().getEarliestStart();
				double possibleEartliestStart = predecessorEarliestStart + weightOfIngoingEdge;
				possibleEarliestStarts.add(possibleEartliestStart);
			}
			
			double earlyStartToSet  = Collections.max(possibleEarliestStarts);
			list.get(i).getNodeProperties().setEarliestStart(earlyStartToSet);				
		}
	}
	
	public void backwardPass(List<Node<Milestone>> list){
		for (int i = list.size()-1 ; i>=0 ; i--){
			int outgoingEdges = list.get(i).getOutgoingEdges().size();
			List<Double> possibleLatestFinishes = new ArrayList<Double>();
			
			double earliestStartOfLastNode = list.get(list.size()-1).getNodeProperties().getEarliestStart();
			list.get(list.size()-1).getNodeProperties().setLatestFinish(earliestStartOfLastNode);
			possibleLatestFinishes.add(earliestStartOfLastNode);
			
			for (int j = 0 ; j<outgoingEdges ; j++){
				double weightOfOutgoingEdge = list.get(i).getOutgoingEdges().get(j).getWeight();
				int numberOfSuccessor = list.get(i).getOutgoingEdges().get(j).getEnd().getNodeProperties().getNumberAfterSort();
				double successorLatestFinish = list.get(numberOfSuccessor).getNodeProperties().getLatestFinish();
				double possibleLatestFinish = successorLatestFinish - weightOfOutgoingEdge;
				possibleLatestFinishes.add(possibleLatestFinish);
			}
			
			double numberToSet  = Collections.min(possibleLatestFinishes);
			list.get(i).getNodeProperties().setLatestFinish(numberToSet);
		}
	}
	
	public void propertiesCalculator(List<Node<Milestone>> list){
		for (int i = 0 ; i<list.size() ; i++){
			int outgoingEdges = list.get(i).getOutgoingEdges().size();
			for (int j = 0 ; j<outgoingEdges ; j++){
				double weightOfEdge = list.get(i).getOutgoingEdges().get(j).getWeight();
				Node<Milestone> startOfEdge = list.get(i);
				Node<Milestone> endOfEdge = list.get(i).getOutgoingEdges().get(j).getEnd();

				double EST = list.get(i).getNodeProperties().getEarliestStart();
				double LFT = list.get(i).getOutgoingEdges().get(j).getEnd().getNodeProperties().getLatestFinish();
				double LST = LFT - weightOfEdge;
				double EFT = EST + weightOfEdge; 
				EdgeProperties<Milestone> edgeWithProperties = new EdgeProperties<>(startOfEdge, endOfEdge, weightOfEdge, EST, LST, EFT, LFT);
				
				if (edgeWithProperties.getWeight()!=0){
					edgesWithProperties.add(edgeWithProperties);
				}			
			}
		}
	}
	
	
}