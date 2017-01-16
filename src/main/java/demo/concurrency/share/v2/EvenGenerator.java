package demo.concurrency.share.v2;

import demo.concurrency.share.v1.IntGenerator;

public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	
	@Override
	public int next() {
		++currentEvenValue; // 这是在zuo
		Thread.yield(); // zuo 得彻底一点
		++currentEvenValue;
		
		return currentEvenValue;
	}

}
