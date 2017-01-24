package exercise.concurrency.q14.timer;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTimerTask extends TimerTask {

	private static final Logger log = LoggerFactory.getLogger(MyTimerTask.class);
	
	@Override
	public void run() {
		log.info("timer up");
//		System.exit(0);
	}

}
