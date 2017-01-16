package demo.concurrency.share.v1;

public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	
	@Override
	public int next() {
		++currentEvenValue; // 这是在zuo
		++currentEvenValue;
		
		return currentEvenValue;
	}

}
