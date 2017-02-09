package demo.concurrency.interrupt.v7;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.util.ComplexWorker;

public class Blocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Blocked.class);
	
	private static final int timeout = 1;
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				NeedsCleanup n = new NeedsCleanup(1);
				try {
					log.info("睡{}秒", timeout);
					TimeUnit.SECONDS.sleep(timeout);
					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						log.info("做一个需要花些时间的工作");
						new ComplexWorker().finiteWorker(2500000);
						log.info("完成一个需要花些时间的工作");
					} finally {
						n2.cleanup();
					}
				}  finally {										
					n.cleanup();
				}
			}
			log.info("以退出while循环方式退出");
		}catch (InterruptedException e) {
			log.info("以InterruptedException方式退出");
		}
	}

}
