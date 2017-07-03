package demo.concurrency.share.v1;

public class EvenCheckerDemo {

	public static void main(String[] args) {
		EvenCheckerTester.test(new EvenGenerator(), 50);
	}
}
