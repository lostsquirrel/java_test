package exercise.concurrency.q18.sleep;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sleeper {
	
	private static final Logger log = LoggerFactory.getLogger(Sleeper.class);
	
	protected long timeout = 10000;

	public void sleep() {
		log.info("准备睡{}ms", timeout);
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("睡眠结束");
	}
	
	public static void main(String[] args) {
		//  测试此类，睡10秒
		new Sleeper().sleep();
	}
}
