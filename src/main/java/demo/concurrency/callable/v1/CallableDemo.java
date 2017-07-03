package demo.concurrency.callable.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallableDemo {
	
	private static Logger log = LoggerFactory.getLogger(CallableDemo.class);
	
	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool();
		
		List<Future<String>> res = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			res.add(exec.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> fs : res) {
			try {
				log.debug(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
