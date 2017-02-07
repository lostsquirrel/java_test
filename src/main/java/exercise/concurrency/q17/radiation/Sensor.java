package exercise.concurrency.q17.radiation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sensor implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Sensor.class);
	
	private static Count count = new Count();
	
	private static List<Sensor> sensors = new ArrayList<Sensor>();
	
	private final int id;
	
	private double r = 0;
	
	private static volatile boolean closed = false;
	
	private Random rand = new Random();
	
	public Sensor(int id) {
		this.id = id;
		sensors.add(this);
	}
	
	@Override
	public void run() {
		while(!closed) {
			scan();
			log.debug("{}", this);
		}
		log.info("Sensor[{}] closing...", id);
	}

	public synchronized double getValue() {
		return r;
	}
	
	public synchronized double scan() {
		r = rand.nextDouble() * 1000;
		count.scan(id, r);
		return r;
	}
	
	public String toString() {
		return String.format("Sensor[%s]:%s", id, getValue());
	}
	
	public static double radiation() {
		return count.value();
	}
	
	public static void close() {
		closed = true;
	}
	
	public static double getAvgRadiation() {
		double r = 0;
		if (sensors.size() > 0) {
			
			for (Sensor sensor : sensors) {
				r += sensor.getValue();
			}
			
			r = r / sensors.size();
		}
		return r;
	}
}
