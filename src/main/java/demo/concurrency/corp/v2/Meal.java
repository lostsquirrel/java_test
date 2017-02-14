package demo.concurrency.corp.v2;

public class Meal {

	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "Meal [" + orderNum + "]";
	}
	
}
