package exercise.concurrency.q11.share;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stocker {

	private static final Logger log = LoggerFactory.getLogger(Stocker.class);

	protected volatile boolean soldOut = false;

	protected int stock = 0;

	protected int sold = 0;

	public Stocker(int stock) {
		this.stock = stock;
	}
	
	public void sell(int x) {
		if (stock >= x) {
//			Thread.yield();
			// 睡起来比较容易发现问题
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stock -= x;
			sold += x;
			log.info("售出{}件", x);
		} else {
			log.info("库存不足{}", x);
		}
		if (stock <= 0) {
			soldOut = true;
		}
	}

	public boolean isSoldOut() {
		return soldOut;
	}
	
	@Override
	public String toString() {
		return String.format("已售出 %d; 剩余库存%d", this.sold, this.stock);
	}

}
