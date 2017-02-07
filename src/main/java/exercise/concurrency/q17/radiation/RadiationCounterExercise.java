package exercise.concurrency.q17.radiation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadiationCounterExercise {
	
	private static final Logger log = LoggerFactory.getLogger(RadiationCounterExercise.class);
	
	/**
	 * @param args
	 * 创建一个辐射计数器，可以有任意数量的远程传感器
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Sensor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Sensor.close();
		exec.shutdown();
		
		if (exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
			log.info("有传感器还没关上！");
		}
		
		log.info("示数: {}", Sensor.radiation());
		log.info("各传感器平均数: {}", Sensor.getAvgRadiation());
	}
}
