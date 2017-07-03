package demo.concurrency.exception.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionDemo {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionWorker());
	}
}
