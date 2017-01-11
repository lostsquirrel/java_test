package exercise.concurrency.q01.yield;

public class YieldSimpleExercise {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new YieldSample()).start();
		}
	}
}

