package Model;

import java.util.ArrayList;

public class Node<T> {

	private int number;
	private T nodeProperties;
	ArrayList<Edge<T>> connections = new ArrayList<Edge<T>>();
	ArrayList<Edge<T>> ingoingEdges = new ArrayList<Edge<T>>();
	ArrayList<Edge<T>> outgoingEdges = new ArrayList <Edge<T>>();

	public Node(int number, T nodeProperties) {
		this.number = number;
		this.nodeProperties = nodeProperties;
	}

	public int getNumber() {
		return number;
	}

	public Node (int number) {
		this.number = number;
		
	}
	public Node (int number,Class<T> clazz) throws InstantiationException, IllegalAccessException {
		this.number = number;
		this.nodeProperties= clazz.newInstance();
		
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public T getNodeProperties() {
		return nodeProperties;
	}

	public void setNodeProperties(T nodeProperties) {
		this.nodeProperties = nodeProperties;
	}

	public ArrayList<Edge<T>> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Edge<T>> connections) {
		this.connections = connections;
	}

	public void addConnection( Edge<T> edge ){
		connections.add(edge);
	}
	
	public void addOutgoingEdges( Edge<T> edge ){
		outgoingEdges.add(edge);
	}
	
	public void addIngoingEdges( Edge<T> edge ){
		ingoingEdges.add(edge);
	}
	
	public ArrayList<Edge<T>> getIngoingEdges() {
		return ingoingEdges;
	}

	public ArrayList<Edge<T>> getOutgoingEdges() {
		return outgoingEdges;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + "]";
	}

}
