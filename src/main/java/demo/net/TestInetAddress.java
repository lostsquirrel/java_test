package demo.net;

import static org.junit.Assert.*;

import java.net.InetAddress;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInetAddress {

	private static Logger log = LoggerFactory.getLogger(TestInetAddress.class);
	
	public static void main(String[] args) {
		
	}
	

	@Test
	public void testGetAllByName() throws Exception {
		String host = "baidu.com";
		InetAddress[] addresses =
				InetAddress.getAllByName(host );
		log.info("{}:{}", host, addresses);
		assertTrue(addresses.length > 1);
	}
	
	@Test
	public void testGetLocalhost() throws Exception {
		InetAddress localHostAddress =
				InetAddress.getLocalHost();
		log.info("localhost:{}", localHostAddress);
		log.info("address:{}", localHostAddress.getAddress());
//		Assert.assertEquals("localhost", localHostAddress.getHostAddress());
	}
}
