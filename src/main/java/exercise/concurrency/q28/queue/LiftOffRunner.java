package exercise.concurrency.q28.queue;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.lift.v1.LiftOff;

public class LiftOffRunner implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(LiftOffRunner.class);

	private BlockingQueue<LiftOff> rockets;

	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		this.rockets = rockets;
	}

	public void add(LiftOff lo) {
		try {
			rockets.put(lo);
		} catch (InterruptedException e) {
			log.error("在放的时候被打手了\n");
		}
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				rockets.take().run();
			}
		} catch (InterruptedException e) {
			log.error("在拿的时候被打手了\n");
		}
		log.info("任务结束");
	}

}
