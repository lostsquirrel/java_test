package demo.concurrency.queue.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.lift.v1.LiftOff;

public class BlockingQueuesDemo {
	
	private static final Logger log = LoggerFactory.getLogger(BlockingQueuesDemo.class);
	
	static void getKey() {
		try {
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	static void getKey(String message) {
		log.info("{}", message);
		getKey();
	}
	
	static void test(String message, BlockingQueue<LiftOff> queue) {
		
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		
		for (int i = 0; i < 5; i++) {
			runner.add(new LiftOff(5));
		}
		getKey(String.format("按 回车 （%s）", message));
		t.interrupt();
		log.info("{} 测试结束\n", message);
	}
	public static void main(String[] args) {
		test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
		test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
		test("SynchronousQueue", new SynchronousQueue<LiftOff>());
	}
}
