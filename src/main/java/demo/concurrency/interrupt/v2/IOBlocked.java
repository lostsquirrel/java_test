package demo.concurrency.interrupt.v2;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOBlocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(IOBlocked.class);
	
	private InputStream in;
	
	public IOBlocked(InputStream is) {
		in = is;
	}
	
	@Override
	public void run() {
		log.info("等待输入 {}", in.getClass().getName());
		try {
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				log.info("输入中断 {}", in.getClass().getName());
			} else {
				throw new RuntimeException(e);
			}
		}
		
		log.info("输入结束 {} \n", in.getClass().getName());
	}

}
