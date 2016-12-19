public class Edge {
	
	private	Node start;
	private Node end;
	private double weight;

		
	public Edge(Node begin, Node end) {
		this.start = begin;
		this.end = end;
	}

	public Edge(Node begin, Node end, double weight) {
		this.start = begin;
		this.end = end;
		this.weight = weight;

	}

	public Node getStart() {
		return start;
	}
	public void setStart(Node begin) {
		this.start = begin;
	}
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}

	
}
