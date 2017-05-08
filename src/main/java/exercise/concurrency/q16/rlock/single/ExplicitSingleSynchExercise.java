package exercise.concurrency.q16.rlock.single;

public class ExplicitSingleSynchExercise {

	/**
	 * @param args
	 * 使用相同的锁对象，会执行完一个方法再执行下一个
	 */
	public static void main(String[] args) {
		final ExplicitSingleSynch ss = new ExplicitSingleSynch();
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
