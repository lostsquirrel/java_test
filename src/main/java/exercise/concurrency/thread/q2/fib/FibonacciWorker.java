package exercise.concurrency.thread.q2.fib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lisong
 *
 *	练习2
 * 打印一个由n 斐波纳契数组成的序列
 */
public class FibonacciWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(FibonacciWorker.class);
	
	private int n;
	
	public FibonacciWorker(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		printFib();
	}
	
	private void printFib() {
		Fibonacci gen = new Fibonacci();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(gen.next());
			sb.append(",");
		}
		log.info("{} fib sequeue: {}", n, sb.toString());
	}
}
