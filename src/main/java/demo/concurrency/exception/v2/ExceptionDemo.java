package demo.concurrency.exception.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.exception.v1.ExceptionWorker;

public class ExceptionDemo {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionDemo.class);
	
	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionWorker());
		} catch (Exception e) {
//			据说不会执行
			log.error(e.getMessage());
		}
	}
}
