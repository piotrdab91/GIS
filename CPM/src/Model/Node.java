package Model;
import java.util.ArrayList;

public class Node {
	
	private int number;
	ArrayList <Edge> connections;
		
	public Node(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}			
	
}
