package exercise.concurrency.q14.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerFactory {
	
	private static final Logger log = LoggerFactory.getLogger(TimerFactory.class);
	
	private static final long DEFAULT_DELAY = 1000;
	
	private static final int DEFAULT_TIMERS = 1000;
	
	private static final List<Timer> timers = new ArrayList<Timer>(DEFAULT_TIMERS);
	
	static  {
		
		createTimer(DEFAULT_TIMERS);
	}
	
	private static void createTimer(int n) {
		log.debug("create {} Timers", n);
		for (int i = 0; i < n; i++) {
			Timer timer = new Timer();
			timers.add(timer);
		}
	}
	public synchronized static void createTimer(TimerTask task, long delay) {
		if (timers.size() <= 600) {
			createTimer(400);
		}
		timers.remove(0).schedule(task, delay);
	}
	
	public static void createTimer(TimerTask task) {
		createTimer(task, DEFAULT_DELAY);
	}
}
