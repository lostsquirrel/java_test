package demo.concurrency.dead.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Philosopher implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Philosopher.class);

	private Chopstick left;

	private Chopstick right;

	private final int id;

	private final int ponderFactor;

	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
		super();
		this.left = left;
		this.right = right;
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
				log.info("{}拿右边{}", this, right); // 思想家应该是左撇子才有范啊
				right.take();
				log.info("{}拿左边{}", this, left);
				left.take();
				log.info("{}开吃", this);
				eating();
				log.info("{}吃完，丢筷子", this);
				right.drop();
				left.drop();
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
