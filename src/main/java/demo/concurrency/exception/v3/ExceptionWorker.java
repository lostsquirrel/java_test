package demo.concurrency.exception.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionWorker.class);
	
	@Override
	public void run() {
		log.debug("马上抛出异常");
		throw new RuntimeException();
	}

}
