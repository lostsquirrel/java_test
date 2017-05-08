package exercise.concurrency.q17.radiation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Count {

	private double count = 0;
	
	private Random rand = new Random(47);
	
	private Map<Integer, Double> nearestSensar = new HashMap<>();
	
	/**
	 * 将来自传感器的数据保存与取平均数，作为最终数据
	 * @param value
	 * @return
	 */
	public synchronized double scan(int sensarId, double value) {
		if (rand.nextBoolean()) {
			Thread.yield();
		}
		nearestSensar.put(sensarId, value);
		double temp = 0;
		for (Double iterable_element : nearestSensar.values()) {
			temp += iterable_element;
		}
		return (count = temp / nearestSensar.size());
	}
	
	public synchronized double value() {
		return count;
	}
}
