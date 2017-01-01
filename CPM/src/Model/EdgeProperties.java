package Model;

public class EdgeProperties <T> extends Edge <T>{

	private double est;
	private double lst;
	private double eft;
	private double lft;
	
	public EdgeProperties(Node<T> start, Node<T> end, double weight, double est, double lst, double eft, double lft) {
		super(start, end, weight);
		this.est = est;
		this.lst = lst;
		this.eft = eft;
		this.lft = lft;
	}

	public double getEst() {
		return est;
	}

	public void setEst(double est) {
		this.est = est;
	}

	public double getLst() {
		return lst;
	}

	public void setLst(double lst) {
		this.lst = lst;
	}

	public double getEft() {
		return eft;
	}

	public void setEft(double eft) {
		this.eft = eft;
	}

	public double getLft() {
		return lft;
	}

	public void setLft(double lft) {
		this.lft = lft;
	}
	
	public String toString() {
		return "Krawedz: " + getStart().getNumber() + "_" + getEnd().getNumber() + ". Waga:" + getWeight() + ". EST:" + getEst() + ". LST:" + getLst() + ". EFT: " + getEft() + ". LFT: " + getLft();
	}
	
	
}