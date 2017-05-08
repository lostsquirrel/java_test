package demo.concurrency.thread.v1;

public class SimpleThreadDemo {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThreadWorker();
		}
	}
}
