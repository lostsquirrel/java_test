package demo.concurrency.thread.v2;

public class SelfManageDemo {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SelfManageWorker();
		}
	}
}
