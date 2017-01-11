package exercise.concurrency.q05.fib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CachedThreadPoolExercise {
	
	private static Logger log = LoggerFactory.getLogger(CachedThreadPoolExercise.class);
	
	/**
	 * @param args
	 * 分三次添加15任务，第二次，马上添加，每三次预计前面任务执行完后添加
	 * 预期使用10个线程
	 */
	public static void main(String[] args) {
		List<Future<String>> res = new ArrayList<>();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			res.add(exec.submit(new FibonacciResult(i)));
		}
		
		for (int i = 0; i < 5; i++) {
			res.add(exec.submit(new FibonacciResult(i)));
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			res.add(exec.submit(new FibonacciResult(i)));
		}
		
		exec.shutdown(); // 阻止加入新的任务
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
