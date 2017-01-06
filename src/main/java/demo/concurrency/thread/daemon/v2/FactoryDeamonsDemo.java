package demo.concurrency.thread.daemon.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.thread.daemon.v1.DaemonWorker;

public class FactoryDeamonsDemo {

	private static final Logger log = LoggerFactory.getLogger(FactoryDeamonsDemo.class);
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			exec.execute(new DaemonWorker());
		}
		log.debug("create daemons finshed");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("ready to terminate");
	}
}
