package demo.concurrency.exception.v3;

import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlerThreadFactory implements ThreadFactory {

	
	private static final Logger log = LoggerFactory.getLogger(HandlerThreadFactory.class);
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		log.debug("创建了一个线程: ", t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		log.debug("{}", t.getUncaughtExceptionHandler());
		
		return t;
	}

}
