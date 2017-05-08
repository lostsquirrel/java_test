package demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class ReaderTest {

	@Test
	public void testBufferedRader() {
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			try {
				while ((line = br.readLine()) != null)
				{
					if (line.trim().equals("bye"))
					{
//					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("Shen-PC"), 1234);
						break;
					}
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
