package demo.concurrency.interrupt.v4;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOInterruptionDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		int port = 9090;
		ServerSocket server = new ServerSocket(port);
		
		String hostname = "localhost";
		InetSocketAddress isa = new InetSocketAddress(hostname, port);
		
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		
		Future<?> f = exec.submit(new NIOBlocked(sc1));
		exec.execute(new NIOBlocked(sc2));
		
		exec.shutdown();
		
		TimeUnit.SECONDS.sleep(1);
		
		f.cancel(true); // 发送一个interrupt, 结束阻塞线程
		
		TimeUnit.SECONDS.sleep(1);
		
		sc2.close(); // 通过关闭底层资源，结束阻塞线程
		
		server.close();
	}
}
