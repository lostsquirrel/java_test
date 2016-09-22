package demo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSocketServer {

	private static final Logger log = LoggerFactory.getLogger(TestSocketServer.class);

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(SocketConfig.PORT);
		} catch (IOException e) {
			log.error("cant not create serversocket with port:" + SocketConfig.PORT);
		}
		Socket socket = null;
		try {
			socket = server.accept();
		} catch (IOException e) {
			log.error("server accept fail");
		}
		
		try (
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				){
			String l = reader.readLine();
			writer.write("echo: " + l);
			
		} catch (IOException e) {
			log.error("get socket input stream fail");
		}
	}
}
