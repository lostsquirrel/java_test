package demo.concurrency.dead.v1;

public class Chopstick {
	
	private boolean take = false;
	
	private final int id;
	
	public Chopstick(int id) {
		this.id = id;
	}

	public synchronized void take() throws InterruptedException {
		while(take) { // 没拿到就一直等着
			wait();
		}
		take = true;
	}
	
	public synchronized void drop() {
		take = false;
		this.notifyAll(); // 谁要啊，都不洗洗？
	}

	@Override
	public String toString() {
		return "Chopstick[" + id + ":" + take + "]";
	}
	
	
}
