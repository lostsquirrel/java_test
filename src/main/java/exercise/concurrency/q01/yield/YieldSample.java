package exercise.concurrency.q01.yield;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lisong
 * 
 * 练习 1
 * 打印一行消息，然后执行 yield, 重复三次
 * 在构建器中打印一条启动消息
 * 任务关闭时打印消息
 * 使用大量线程执行此任务
 */
public class YieldSample implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(YieldSample.class);
	
	private static int initer = 0;
	
	private final int counter = initer++;
	
	public YieldSample() {
		log.info("start YieldSample #{}", counter);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			log.info("YieldSample #{}-{}", counter, i);
			Thread.yield();
		}
		log.info("YieldSample #{} has been finished", counter);
	}
	
}
