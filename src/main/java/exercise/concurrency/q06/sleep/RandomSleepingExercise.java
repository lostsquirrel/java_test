package exercise.concurrency.q06.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomSleepingExercise {

	private static final Logger log = LoggerFactory.getLogger(RandomSleepingExercise.class);
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new RandomSleepingTask());;
		}
		
		log.debug("add RandomSleepingTask finished");
	}
}
