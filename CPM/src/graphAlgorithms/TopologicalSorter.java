package graphAlgorithms;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

import Model.Edge;
import Model.Graph;
import Model.Milestone;
import Model.Node;

public class TopologicalSorter {
	private Graph<Milestone> graph;
	private List<Node<Milestone>> list = new ArrayList<Node<Milestone>>();

	public TopologicalSorter(Graph<Milestone> graph) {
		this.graph = graph;
	}

	public List<Node<Milestone>> sortKhansAlgortithm() throws InvalidAlgorithmParameterException {
		countIndegree();
		addRoots();
		if(list.size()!=1)
			adjustGraph();
		addRemainingNodes();
		System.out.println(list);
		if (list.size() != graph.getNodesList().size())
			throw new InvalidAlgorithmParameterException("Graf zawiera cykl !!! " + list.size());
		return list;
	}

	public void countIndegree() {

		for (Node<Milestone> node : graph.getNodesList())
			for (Edge<Milestone> e : node.getIngoingEdges())
				e.getEnd().getNodeProperties().incInDegree();
	}

	public List<Node<Milestone>> addRoots() {
		for (Node<Milestone> node : graph.getNodesList()) {
			if (node.getNodeProperties().getInDegree() == 0) {
				list.add(node);
			}
		}
		return list;
	}

	private void addRemainingNodes() {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Node<Milestone> node = list.get(i);
			node.getNodeProperties().setNumberAfterSort(i);
			for (Edge<Milestone> e : node.getOutgoingEdges()) {
				e.getEnd().getNodeProperties().decInDegree();
				if (e.getEnd().getNodeProperties().getInDegree() == 0) {
					++size;
					list.add(e.getEnd());
				}
			}
		}
	}
	public void adjustGraph(){
		int begin = list.size()-1;
		for(Node n:list){
			graph.addEdge(begin,n.getNumber(),0);
		}
		
	}
}