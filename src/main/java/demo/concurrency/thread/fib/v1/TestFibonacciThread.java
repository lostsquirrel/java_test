package demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFibonacciThread {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new FibonacciDemo(i)).start();
		}
	}
}

class FibonacciDemo implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(FibonacciDemo.class);
	
	private int n;
	
	FibonacciDemo(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		printFib();
	}
	
	private void printFib() {
		Fibonacci gen = new Fibonacci();
		for(int i = 0; i < n; i++)
			log.info(gen.next().toString());
		log.info("to fib {}", n);
	}
	
}

class Fibonacci {
	private int count = 0;
	public Integer next(){ 
		return fib(count++);
	}
	private int fib (int n){
		if(n < 2) 
			return 1;
		return fib(n-2) + fib(n-1);
	}
	
}