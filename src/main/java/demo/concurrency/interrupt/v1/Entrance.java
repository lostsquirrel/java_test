package demo.concurrency.interrupt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrance implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Entrance.class);
	
	/**
	 * 每个入口有各自的计数
	 */
	private static Count count = new Count();
	
	private static List<Entrance> entrances = new ArrayList<>();
	
	private int number;
	
	private final int id;
	
	private static volatile boolean canceled = false;
	
	public Entrance(int id) {
		this.id = id;
		entrances.add(this);
	}
	
	@Override
	public void run() {
		while (!canceled) {
			synchronized(this) {
				++number;
			}
			log.debug("{} total: {}", this, count.increment());
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("stopping {}", this);
	}

	public synchronized int getValue() {
		return number;
	}
	
	public String toString() {
		return String.format("Entrance %s: %s", id, getValue());
	}
	
	public static int getTotalCount() {
		return count.value();
	}
	
	public static void cancel() {
		canceled = true;
	}
	public static int sumEntrance() {
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		
		return sum;
	}
}
