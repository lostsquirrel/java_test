package demo.concurrency.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.thread.lift.v1.LiftOff;

public class RunWithSingleThread {

	private static final Logger log = LoggerFactory.getLogger(RunWithSingleThread.class);
	
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		log.debug("等待Lift线程执行结束");
	}
}
