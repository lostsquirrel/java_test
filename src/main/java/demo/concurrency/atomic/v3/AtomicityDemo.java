package demo.concurrency.atomic.v3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtomicityDemo {
	
	private static final Logger log = LoggerFactory.getLogger(AtomicityDemo.class);
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Atomicity val = new Atomicity();
		exec.execute(val);
		
		while(true) {
			int v = val.getValue();
			if (v % 2 != 0) {
				log.debug("{}", v);
				System.exit(0);
			}
		}
	}
}
