public class Edge {
	
	private	Node begin;
	private Node end;
	private int weight;
	private int name;
	
	

	public Edge(int weight, int name) {
		this.weight = weight;
		this.name = name;
	}  
	
		
	public Edge(Node begin, Node end) {
		this.begin = begin;
		this.end = end;
	}

	public Edge(Node begin, Node end, int weight, int name) {
		this.begin = begin;
		this.end = end;
		this.weight = weight;
		this.name = name;
	}

	public Node getBegin() {
		return begin;
	}
	public void setBegin(Node begin) {
		this.begin = begin;
	}
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	} 
	
	
	
}
