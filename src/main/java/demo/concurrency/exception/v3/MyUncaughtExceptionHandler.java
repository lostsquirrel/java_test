package demo.concurrency.exception.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(MyUncaughtExceptionHandler.class);
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		log.info("逮到一个异常：{}", e);
		log.info("逮完了。。。");
	}

}
