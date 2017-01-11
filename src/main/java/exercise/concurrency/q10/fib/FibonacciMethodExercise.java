package exercise.concurrency.q10.fib;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciMethodExercise {
	
	private static final Logger log = LoggerFactory.getLogger(FibonacciMethodExercise.class);
	
	public static void main(String[] args) {
		FibonacciMethod m = new FibonacciMethod();
		
		for (int i = 0; i < 10; i++) {
			try {
				log.debug("{}:{}",i, m.runTask(i).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
