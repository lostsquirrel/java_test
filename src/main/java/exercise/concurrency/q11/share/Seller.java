package exercise.concurrency.q11.share;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Seller implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Seller.class);
	
	private Stocker clocker;
	
	public Seller(Stocker clocker) {
		super();
		this.clocker = clocker;
	}

	@Override
	public void run() {
		
		while(!clocker.isSoldOut()) {
			int i = new Random().nextInt(10) + 1;
			clocker.sell(i);
		}
		log.debug("{}", clocker);
	}

}
