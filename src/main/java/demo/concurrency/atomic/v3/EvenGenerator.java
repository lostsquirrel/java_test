package demo.concurrency.atomic.v3;

/**
 * getValue方法与evenIncrement 之间存在中间状态，收起脏读
 * @author lisong
 *
 */
public class EvenGenerator {

	private int i = 0;

	public synchronized int getValue() {
		return i;
	}

	public synchronized void evenIncrement() {
		i++;
		i++;
	}

}
