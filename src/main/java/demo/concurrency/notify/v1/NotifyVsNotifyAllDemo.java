package demo.concurrency.notify.v1;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class NotifyVsNotifyAllDemo {
	
	private static final Logger log = LoggerFactory.getLogger(NotifyVsNotifyAllDemo.class);
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new Task());
		}
		
		exec.execute(new Task2());
		
		Timer t = new Timer();
		
		t.scheduleAtFixedRate(new TimerTask() {
			boolean prod = true;
			
			@Override
			public void run() {
				if(prod) {
					log.info("调用notify()");
					Task.blocker.prod();
					prod = false;
				} else {
					log.info("调用notifyAll()");
					Task.blocker.prodAll();
					prod = true;
				}
			}
			
		}, 400, 400);
		
		SleepUtils.sleepInSeconds(4);
		
		t.cancel();
		log.info("Timer cancled");
		SleepUtils.sleepInMilliseconds(500);
		log.info("Task2.blocker.prodAll()");
		Task2.blocker.prodAll();
		SleepUtils.sleepInMilliseconds(500);
		log.info("exec.shutdownNow();");
		exec.shutdownNow();
		
		
	}
}
