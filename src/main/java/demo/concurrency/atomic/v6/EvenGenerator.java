package demo.concurrency.atomic.v6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * getValue方法与evenIncrement 之间存在中间状态，收起脏读
 * @author lisong
 *
 */
public class EvenGenerator {

	private AtomicInteger i = new AtomicInteger(0);

	public int getValue() {
		return i.get();
	}

	public synchronized void evenIncrement() {
		i.getAndAdd(2);
	}

}
