package demo.concurrency.join;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinDemo {
	
	private static final Logger log = LoggerFactory.getLogger(JoinDemo.class);
	
	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper("Sleeper", 1500);
		Sleeper grumpy = new Sleeper("Grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleeper);
		Joiner doc = new Joiner("Doc", grumpy);
		log.debug("{}, {}", dopey, doc);
		grumpy.interrupt();
		
	}
}
