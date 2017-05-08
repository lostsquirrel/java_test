package demo.concurrency.interrupt.v3;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.interrupt.v2.IOBlocked;

public class IOBlockedTester {
	
	private static final Logger log = LoggerFactory.getLogger(IOBlockedTester.class);
	
	public static void test(final InputStream in) throws InterruptedException, IOException {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new IOBlocked(in));
		TimeUnit.MILLISECONDS.sleep(500);
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		new Thread() {
			public void run() {
				log.info("关闭 {}", in.getClass().getName());
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
}
