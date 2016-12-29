package exercise.concurrency.thread.q2.fib;

public class TestFibonacciThread  {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new Thread(new FibonacciWorker(i)).start();
		}
	}
}

