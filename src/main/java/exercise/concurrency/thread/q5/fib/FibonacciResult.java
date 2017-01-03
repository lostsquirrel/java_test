package exercise.concurrency.thread.q5.fib;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exercise.concurrency.thread.q2.fib.Fibonacci;

/**
 * @author lisong
 *
 *	练习5
 * 生成一个由n 斐波纳契数组成的序列，作为结果返回
 */
public class FibonacciResult implements Callable<String> {
	
	private static final Logger log = LoggerFactory.getLogger(FibonacciResult.class);
	
	private int n;
	
	public FibonacciResult(int n) {
		this.n = n;
	}
	
	@Override
	public String call() {
		return getFib();
	}
	
	private String getFib() {
		Fibonacci gen = new Fibonacci();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(gen.next());
			sb.append(",");
		}
		log.debug("generate finished for {}", n);
		return sb.toString();
	}
}
