package demo.concurrency.section;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriticalSectionDemo {

	
	private static final Logger log = LoggerFactory.getLogger(CriticalSectionDemo.class);
	
	static void testApproches(PairManager ...managers) {
		if (managers.length >= 2) {
			ExecutorService exec = Executors.newCachedThreadPool();
			List<PairManipulator> pmrs = new ArrayList<>();
			for (PairManager pm : managers) {
				PairManipulator pmr = new PairManipulator(pm);
				pmrs.add(pmr);
				exec.execute(pmr);
			}
			for (PairManager pm : managers) {
				exec.execute(new PairChecker(pm));
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			log.info("pms: {};", pmrs.toString());
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		testApproches(new PairManager1(), new PairManager2(), new PairManager3());
	}
}
