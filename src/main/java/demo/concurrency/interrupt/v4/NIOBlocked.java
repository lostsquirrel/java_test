package demo.concurrency.interrupt.v4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NIOBlocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(NIOBlocked.class);
	
	private final SocketChannel sc;
	
	public NIOBlocked(SocketChannel sc) {
		this.sc = sc;
	}
	@Override
	public void run() {
		log.debug("开始读...");
		try {
			sc.read(ByteBuffer.allocate(1));
		} catch (ClosedByInterruptException e0) {
			log.error("ClosedByInterruptException");
		} catch (AsynchronousCloseException e1) {
			log.error("AsynchronousCloseException");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		log.debug("读取结束\n");
	}

}
