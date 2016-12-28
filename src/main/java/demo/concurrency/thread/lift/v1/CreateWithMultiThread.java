package demo.concurrency.thread.lift.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateWithMultiThread {

	private static final Logger log = LoggerFactory.getLogger(CreateWithMultiThread.class);
	
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new Thread(){
				@Override
				public void run() {
					for (int j = 0; j < 30; j++) {
						new Thread(new LiftOff()).start();
					}
				}
			}.start();
		}
		log.debug("等待Lift线程执行结束");
	}
}
