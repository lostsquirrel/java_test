package demo.concurrency.exception.v4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.exception.v3.ExceptionWorker;
import demo.concurrency.exception.v3.MyUncaughtExceptionHandler;

public class ExceptionDemo {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionWorker());
	}
}
