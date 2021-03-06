package Model;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.NodeList;

public class Graph<T> {
	private ArrayList<Node<T>> nodesList = new ArrayList<Node<T>>();
	
	public Graph(ArrayList<Node<T>> nodesList) {
		this.nodesList = nodesList;
	}

	public Graph(int numberOfNodes, Class<T> clazz){
		createNodes(numberOfNodes,clazz);
	}

	private void createNodes(int numberOfNodes, Class <T> clazz) {
	
		for (int i = 0; i < numberOfNodes; i++) {
			try {
				nodesList.add(new Node<T>(i,clazz));
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addEdge(Edge<T> edge) {

		edge.getStart().addConnection(edge);
		edge.getEnd().addConnection(edge);
	}

	public void addEdge(int start, int end, double weight) {

		Edge<T> edge = new Edge<>(nodesList.get(start), nodesList.get(end), weight);
		edge.getStart().addConnection(edge);
		edge.getEnd().addConnection(edge);
		edge.getStart().addOutgoingEdges(edge);
		edge.getEnd().addIngoingEdges(edge);
	}

	public ArrayList<Node<T>> getNodesList() {
		return nodesList;
	}

	public void setNodesList(ArrayList<Node<T>> nodesList) {
		this.nodesList = nodesList;
	}
	//TODO poprawic to i mozna usunać connections z grafu
/* DO poprawy
	public void deleteEdge(int from, int to){
		Node<T>start  = this.getNodesList().get(from);
		Node<T> end = this.getNodesList().get(to);
		Edge<T> currentEdge;
		Iterator<Edge<T>> it;
		
		it = start.getConnections().iterator();
		while(it.hasNext()){
			currentEdge = it.next();
			if (currentEdge.getStart() == start && currentEdge.getEnd() == end)
				it.remove();
			}
	    it= end.getConnections().iterator();
		while(it.hasNext()){
			currentEdge = it.next();
			if (currentEdge.getStart() == start && currentEdge.getEnd() == end)
				it.remove();
			}
	}*/

	public int getNumberOfEdges(){
		int degreeOfNode = 0;
		
		for (Node<T> node : nodesList) {
			degreeOfNode += node.connections.size();	
		}
		return degreeOfNode/2;
	}
	@Override
	public String toString() {
		return "Liczba wierzcholków: " + nodesList.size() + " Liczba krawedzi: " + getNumberOfEdges();
	}


}
