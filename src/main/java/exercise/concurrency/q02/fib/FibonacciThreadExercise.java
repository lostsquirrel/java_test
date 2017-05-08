package exercise.concurrency.q02.fib;

public class FibonacciThreadExercise  {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new Thread(new FibonacciWorker(i)).start();
		}
	}
}

