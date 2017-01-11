package demo.concurrency.inner.v1;

public class ThreadVariationsDemo {

	public static void main(String[] args) {
		new InnerThreadWorker("a");
		new InnerRunnableWorkerAnonymous("aa");
		new InnerThreadWorker("b");
		new InnerThreadWorkerAnonymous("bb");
		new ThreadMethod("c").runTask();
	}
	
}
