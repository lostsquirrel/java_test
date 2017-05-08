package demo.concurrency.section;

/**
 * @author lisong
 * 使用同步方法，使Pair线程安全
 */
public class PairManager2 extends PairManager {

	@Override
	public void increment() {
		Pair temp;
		synchronized(this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}
