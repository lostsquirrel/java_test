package demo.concurrency.thread.yield.v1;

public class TestYieldSimple {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new YieldSample()).start();
		}
	}
}

