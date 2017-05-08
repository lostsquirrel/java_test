package demo.concurrency.responsive.v2;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponsiveDemo {
	
	private static final Logger log = LoggerFactory.getLogger(ResponsiveDemo.class);
	
	public static void main(String[] args) {
		new ResponsiveUI();
		int x = 0;
		try {
			x = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.debug("echo: {}", x);
	}
}
