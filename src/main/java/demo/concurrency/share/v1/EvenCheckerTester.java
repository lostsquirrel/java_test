package demo.concurrency.share.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenCheckerTester {

	private static final int DEFAULT_COUNT = 10;
	
	public static void test(IntGenerator g, int count) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(g));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator g) {
		test(g, DEFAULT_COUNT);
	}
}
