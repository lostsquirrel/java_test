package demo.concurrency.section;

/**
 * @author lisong
 * 使用同步方法，使Pair线程安全
 */
public class PairManager1 extends PairManager {

	@Override
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}

}
