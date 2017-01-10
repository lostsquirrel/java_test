package demo.concurrency.priority.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePriorities implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(SimplePriorities.class);
	
	private int countDown = 5000;
	
	@SuppressWarnings("unused")
	private volatile double d; 
	
	private int priority;
	
	public SimplePriorities(int priority) {
		super();
		this.priority = priority;
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
			log.debug("start at {}", System.currentTimeMillis());
			for (int i = 1; i < 10000 * countDown; i++) {
				d += (Math.PI + Math.E) / (double)i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}
			log.debug("{} finished at {}", priority, System.currentTimeMillis());
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int p : new int[]{Thread.MAX_PRIORITY, Thread.NORM_PRIORITY, Thread.MIN_PRIORITY}) {
			for (int i = 0; i < 5; i++) {
				exec.execute(new SimplePriorities(p));
			}
		}
	}
}
