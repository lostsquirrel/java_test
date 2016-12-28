package demo.concurrency.thread.excutor.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.thread.lift.v1.LiftOff;

public class TestCachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdown(); // 阻止加入新的任务
	}
}
