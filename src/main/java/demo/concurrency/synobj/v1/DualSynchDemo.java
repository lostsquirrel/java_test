package demo.concurrency.synobj.v1;

public class DualSynchDemo {

	/**
	 * f 和 g 方法使用不同的锁对象，所以相互不会阻塞，
	 * @param args
	 */
	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		new Thread() {
			public void run() {
				ds.g();
			}
		}.start();
	}
}
