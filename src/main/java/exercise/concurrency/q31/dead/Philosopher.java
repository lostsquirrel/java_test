package exercise.concurrency.q31.dead;

import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.dead.v1.Chopstick;
import demo.util.SleepUtils;

public class Philosopher implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Philosopher.class);

	private final int id;

	private final int ponderFactor;

	private LinkedBlockingQueue<Chopstick> bin;

	public Philosopher(LinkedBlockingQueue<Chopstick> bin, int id, int ponderFactor) {
		super();
		this.bin = bin;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	private void pause() throws InterruptedException {
		
		if (ponderFactor != 0) {
			SleepUtils.sleepRandomMilliseconds(ponderFactor * 250);
		}
	}

	private void thinking() throws InterruptedException {
		log.debug("{}思考，基数{}", this, ponderFactor);
		pause();
	}
	
	private void eating() throws InterruptedException {
		log.debug("{}吃饭，基数{}", this, ponderFactor);
		pause();
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				thinking();

				Chopstick right = bin.take();
				log.info("{}拿右边{}", this, right); // 思想家应该是左撇子才有范啊
				right.take();
				Chopstick left = bin.take();
				log.info("{}拿左边{}", this, left);
				left.take();
				log.info("{}开吃", this);
				eating();
				log.info("{}吃完，丢筷子", this);
				right.drop();
				left.drop();
				bin.put(right);
				bin.put(left);
			}
		} catch (InterruptedException e) {
			log.error("{}思想家睡过去了。。。", this);
		}
	}

	@Override
	public String toString() {
		return "Philosopher [" + id + "]";
	}
	
}
