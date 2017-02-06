package demo.concurrency.synobj.v2;

public class SingleSynchDemo {

	/**
	 * f 和 g 方法使用相同的锁对象，所以相互会阻塞，
	 * @param args
	 */
	public static void main(String[] args) {
		final SingleSynch ds = new SingleSynch();
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
