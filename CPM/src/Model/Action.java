package Model;

public class Action  extends Edge{
	
	private String name;

	
	public Action(Milestone begin, Milestone end, double weight) {
		super(begin, end, weight);
	}

	public Action(Milestone begin, Milestone end,double weight, String name) {
		super(begin, end, weight);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
