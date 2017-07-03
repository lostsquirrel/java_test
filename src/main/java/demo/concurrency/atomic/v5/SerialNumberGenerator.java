package demo.concurrency.atomic.v5;

/**
 * volatile 依赖于其之前的值时，会有并发问题
 * @author lisong
 *
 */
public class SerialNumberGenerator {

	private static int serialNumber = 0;
	
	public synchronized static int nextSerialNumber() {
		return serialNumber++;
	}
}
