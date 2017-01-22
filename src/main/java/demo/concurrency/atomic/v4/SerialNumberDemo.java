package demo.concurrency.atomic.v4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialNumberDemo {

private static final Logger log = LoggerFactory.getLogger(SerialNumberChecker.class);
	
	private static int SIZE = 10;
	
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	/**
	 * 只能验证最近生成capaciity个元素中有没有重复的
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new SerialNumberChecker());
		}
		try {
			int timeout = 100;
			TimeUnit.SECONDS.sleep(timeout);
			log.info("在{}秒内没有发现生成重复", timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
