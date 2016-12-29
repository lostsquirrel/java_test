package demo.concurrency.thread.fib.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciWorker implements Runnable{
	
	private static final Logger log = LoggerFactory.getLogger(FibonacciWorker.class);
	
	private int n;
	
	FibonacciWorker(int n) {
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
		log.info("fib sequeue of {}:{}", n, sb.toString());
	}
}
