package Model;

public class Edge <T> {

	private Node<T> start;
	private Node<T> end;
	private String name;
	private double weight;


	public Edge(Node<T> start, Node<T> end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Node<T> getStart() {
		return start;
	}

	public void setStart(Node<T> start) {
		this.start = start;
	}

	public Node<T> getEnd() {
		return end;
	}

	public void setEnd(Node<T> end) {
		this.end = end;
	}



}
