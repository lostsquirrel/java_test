package demo.concurrency.pipe.v1;

import java.io.IOException;
import java.io.PipedReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reciver implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Reciver.class);

	private PipedReader in;

	public Reciver(Sender sender) throws IOException {
		in = new PipedReader(sender.getOut());
	}

	@Override
	public void run() {
		try {
			while (true) {
				log.debug(String.format("%c", in.read()));
			}
		} catch (IOException e) {
			log.error("读取出错");
		}
	}

}
