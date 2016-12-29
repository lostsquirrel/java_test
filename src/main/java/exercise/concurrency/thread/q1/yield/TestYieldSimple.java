package exercise.concurrency.thread.q1.yield;

public class TestYieldSimple {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new YieldSample()).start();
		}
	}
}

