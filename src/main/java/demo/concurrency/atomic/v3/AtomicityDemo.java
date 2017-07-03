package demo.concurrency.atomic.v3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtomicityDemo {
	
	private static final Logger log = LoggerFactory.getLogger(AtomicityDemo.class);
	
	public static void main(String[] args) {
		long delay = 5000;
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				log.error("aborting");
				System.exit(0);
			}
			
		}, delay );
		ExecutorService exec = Executors.newCachedThreadPool();
		
		EvenGeneratorChecker val = new EvenGeneratorChecker(new EvenGenerator());
		for (int i = 0; i < 6; i++) {
			exec.execute(val);
		}
	}
}
