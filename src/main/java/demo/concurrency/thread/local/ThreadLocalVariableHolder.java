package demo.concurrency.thread.local;

import java.util.Random;

public class ThreadLocalVariableHolder {

	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random random = new Random(123);
		
		protected synchronized Integer initialValue() {
			return random.nextInt(1000);
		}
	};
	
	public static void increment() {
		value.set(value.get() + 1);
	}
	
	public static int get() {
		return value.get();
	}
}
