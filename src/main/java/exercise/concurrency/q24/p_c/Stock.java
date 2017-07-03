package exercise.concurrency.q24.p_c;

public class Stock {

	private int capaciity;
	
	private int[] waiting;
	
	private int size = 0;
	
	private int header = 0;
	
	private int tail = 0;
	
	public Stock() {
		capaciity = 7;
		waiting = new int[capaciity];
	}
	
	public Stock(int capaciity) {
		this.capaciity = capaciity;
	}
	
	public synchronized int stockIn(int orderNum) {
		int status = -1;
		if (size < capaciity) {
			size++;
			header = ++header % capaciity;
			waiting[header] = orderNum;
			status = 1;
		}
		return status;
	}
	
	public synchronized int stockOut() {
		int orderNum = -1;
		if (size > 0) {
			size--;
			tail = ++ tail % capaciity;
			orderNum = waiting[tail];
		}
		return orderNum;
	}
	
	public synchronized boolean isFull() {
		return size >= capaciity;
	}
	
	public synchronized boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		Stock s = new Stock();
		for (int i = 0; i < 20; i++) {
			int orderNum = i * 100;
			System.out.println("in: \t"+s.stockIn(orderNum ) + "\t" + orderNum);
			if (i % 2 == 0) {
				System.out.println("out: \t" + s.stockOut());
			}
			System.out.println();
		}
	}
}
