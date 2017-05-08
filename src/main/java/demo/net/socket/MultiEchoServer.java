package demo.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiEchoServer {

	public static void main(String[] args) {
		try (ServerSocket s = new ServerSocket(8189)) {
			ExecutorService exec = Executors.newCachedThreadPool();
			while(true) {
				Socket incoming = s.accept();
				exec.execute(new EchoWorker(incoming));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
