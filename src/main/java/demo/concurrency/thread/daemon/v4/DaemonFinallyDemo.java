package demo.concurrency.thread.daemon.v4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.thread.daemon.v2.DaemonThreadFactory;

public class DaemonFinallyDemo {

	
	private static final Logger log = LoggerFactory.getLogger(DaemonFinallyDemo.class);
	
	public static void main(String[] args) {
		testManualCreateThread();
		testExcutorCreateThrad();
		
	}
	private static void testExcutorCreateThrad() {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		exec.execute(new DaemonFinallyWorker());
		log.debug("create daemons finshed");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("ready to terminate");
	}
	
	private static void testManualCreateThread() {
		Thread t = new Thread(new DaemonFinallyWorker());
		t.setDaemon(true);
		t.start();
		log.debug("thread [{}] isDaemon:{}", t.getName(), t.isDaemon());
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("to be continued ...");
	}
}
