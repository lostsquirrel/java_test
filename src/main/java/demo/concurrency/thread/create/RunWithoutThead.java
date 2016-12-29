package demo.concurrency.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.thread.lift.v1.LiftOff;

public class RunWithoutThead {

	private static final Logger log = LoggerFactory.getLogger(RunWithoutThead.class);
	
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
		log.debug("等待Lift线程执行结束");
	}
	
}
