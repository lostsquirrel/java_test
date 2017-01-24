package demo.concurrency.atomic.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * getValue方法与evenIncrement 之间存在中间状态，收起脏读
 * @author lisong
 *
 */
public class EvenGeneratorChecker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(EvenGeneratorChecker.class);
	
	private EvenGenerator g;
	
	public EvenGeneratorChecker(EvenGenerator g) {
		this.g = g;
	}
	
	@Override
	public void run() {
		while (true) {
			g.evenIncrement();
			int value = g.getValue();
			if (value % 2 != 0) {
				log.debug("{} is not even", value);
				break;
			}
		}
	}

}
