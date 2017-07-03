package demo.concurrency.atomic.v4;

/**
 * volatile 依赖于其之前的值时，会有并发问题
 * @author lisong
 *
 */
public class SerialNumberGenerator {

	private static volatile int serialNumber = 0;
	
	public static int nextSerialNumber() {
		return serialNumber++;
	}
}
