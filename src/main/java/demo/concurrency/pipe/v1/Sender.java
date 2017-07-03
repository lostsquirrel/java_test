package demo.concurrency.pipe.v1;

import java.io.IOException;
import java.io.PipedWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Sender implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	
	private PipedWriter out = new PipedWriter();

	public PipedWriter getOut() {
		return out;
	}

	@Override
	public void run() {
		try {
			while (true) {
				for (char c = 'A'; c <= 'z'; c++) {
					log.debug(String.format("%c", c));
					out.write(c);
					SleepUtils.sleepRandomMilliseconds(500);
				}
			}
		} catch (IOException e) {
			log.error("写入出错");
		} catch (InterruptedException e) {
			log.error("打爆");
		}
	}

}
