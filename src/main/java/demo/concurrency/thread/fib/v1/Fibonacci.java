package demo.concurrency.thread.fib.v1;

public class Fibonacci {
	
	private long count = 0;

	public long next() {
		return fib(count++);
	}

	private long fib(long n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}
}
