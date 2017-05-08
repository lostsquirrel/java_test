package demo.concurrency.interrupt.v3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CloseResourcesDemo {
	
//	private static final Logger log = LoggerFactory.getLogger(CloseResourcesDemo.class);
	
	/**
	 * @param args
	 * @throws Exception
	 * 需要在命令行执行， IDE不请允许关闭控制台
	 * java -cp target/* demo.concurrency.interrupt.v3.CloseResourcesDemo
	 */
	public static void main(String[] args) throws Exception {
//		testSocketIn();
		testSystemIn();
	}
	
	static void testSystemIn() throws InterruptedException, IOException {
		InputStream systemInput = System.in;
		IOBlockedTester.test(systemInput);
	}
	
	static void testSocketIn() throws InterruptedException, IOException {
		ServerSocket server = new ServerSocket(9090);
		Socket socket = new Socket("localhost", 9090);
		InputStream socketInput = socket.getInputStream();
		IOBlockedTester.test(socketInput);
		socket.close();
		server.close();
	}
	
}
