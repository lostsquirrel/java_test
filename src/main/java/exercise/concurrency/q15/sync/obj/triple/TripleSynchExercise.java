package exercise.concurrency.q15.sync.obj.triple;

public class TripleSynchExercise {

	/**
	 * @param args
	 * 使用不同的锁对象，三个方法都同时执行
	 */
	public static void main(String[] args) {
		
		final TripleSynch ss = new TripleSynch();
		
		new Thread() {
			public void run() {
				ss.f1();
			}
		}.start();
		
		new Thread() {
			public void run() {
				ss.f2();
			}
		}.start();
		
		new Thread() {
			public void run() {
				ss.f3();
			}
		}.start();
	}
}
