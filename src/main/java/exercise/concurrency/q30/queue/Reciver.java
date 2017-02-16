package exercise.concurrency.q30.queue;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reciver implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Reciver.class);

	private CharQueue in;

	public Reciver(CharQueue in) throws IOException {
		this.in = in;
	}

	@Override
	public void run() {
		try {
			while (true) {
				log.debug(String.format("%c", in.take()));
			}
		} catch (InterruptedException e) {
			log.error("打爆");
		}
	}

}
