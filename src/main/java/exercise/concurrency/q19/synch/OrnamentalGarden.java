package exercise.concurrency.q19.synch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.interrupt.v1.Entrance;

public class OrnamentalGarden {
	
	private static final Logger log = LoggerFactory.getLogger(OrnamentalGarden.class);
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new Entrance(i));
			threads.add(t);
			t.start();
		}
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		for (Thread thread : threads) {
			thread.interrupt();
		}
//			log.info("有些门还没关上！");
		
		log.info("总计: {}", Entrance.getTotalCount());
		log.info("各门合计: {}", Entrance.sumEntrance());
	}
}
