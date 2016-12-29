package demo.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoWorker implements Runnable {

	private final Socket incoming;

	public EchoWorker(Socket incoming) {
		this.incoming = incoming;
	}

	@Override
	public void run() {
		try {

			InputStream inStream = incoming.getInputStream();
			OutputStream outStream = incoming.getOutputStream();
			try (Scanner in = new Scanner(inStream)) {

				PrintWriter out = new PrintWriter(outStream, true /*
																	 * autoFlush
																	 */);
				out.println(Thread.currentThread().getName() + " Hello! Enter BYE to exit.");
				boolean done = false;
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					out.println("Echo: " + line);
					if (line.trim().equals("BYE")) {
						done = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
