package exercise.concurrency.q10.fib;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exercise.concurrency.q02.fib.Fibonacci;

public class FibonacciMethod {
	
	private static final Logger log = LoggerFactory.getLogger(FibonacciMethod.class);
	
	ExecutorService exec = Executors.newCachedThreadPool();
	
	public Future<String> runTask(final int n) {
		return exec.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				Fibonacci gen = new Fibonacci();
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < n; i++) {
					sb.append(gen.next());
					sb.append(",");
				}
				log.debug("generate finished for {}", n);
				return sb.toString();
			}
		});
		
	}
	
}
