package demo.concurrency.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrnamentalGarden {
	
	private static final Logger log = LoggerFactory.getLogger(OrnamentalGarden.class);
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Entrance(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		
		if (exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
			log.info("有些门还没关上！");
		}
		
		log.info("总计: {}", Entrance.getTotalCount());
		log.info("各门合计: {}", Entrance.sumEntrance());
	}
}
