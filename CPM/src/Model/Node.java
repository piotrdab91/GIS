package Model;

import java.util.ArrayList;

public class Node<T> {

	private int number;
	private T nodeProperties;
	private ArrayList<Edge<T>> connections = new ArrayList<Edge<T>>();

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
}
