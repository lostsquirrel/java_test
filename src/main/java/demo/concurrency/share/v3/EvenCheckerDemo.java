package demo.concurrency.share.v3;

import demo.concurrency.share.v1.EvenCheckerTester;

public class EvenCheckerDemo {

	public static void main(String[] args) {
		EvenCheckerTester.test(new SynchronizedEvenGenerator());
	}
}
