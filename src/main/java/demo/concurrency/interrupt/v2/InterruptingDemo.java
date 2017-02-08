package demo.concurrency.interrupt.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterruptingDemo {
	
	private static final Logger log = LoggerFactory.getLogger(InterruptingDemo.class);
	
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	/**
	 * @param args
	 * @throws InterruptedException
	 * SleepBlocked 中断生效
	 * IOBlocked 中断没生效
	 * SynchronizedBlocked 中断没生效
	 */
	public static void main(String[] args) throws InterruptedException {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(50);
		log.info("暴力退出");
		System.exit(0);
	}
	
	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		String name = r.getClass().getName();
		log.info("开始扰民{}", name);
		f.cancel(true);
		log.info("扰民{}结束", name);
	}
}
