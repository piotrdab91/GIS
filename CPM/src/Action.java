
public class Action  extends Edge{
	
	private String name;

	public Action(Node begin, Node end, String name) {
		super(begin, end);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
