package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestThread {

	@Test
	public void testCreateThread() {
		System.out.println(Thread.currentThread().getName());
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}

		}.start();
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	public void testCreateThread1() {
		System.out.println(Thread.currentThread().getName());
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName());
					int x = 123_456;
				}
			}

		}).start();
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	public void testCreateThread2() {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
			pool.execute(new Runnable(){public void run(){
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}});
		}

		Executors.newCachedThreadPool().execute(new Runnable(){public void run(){
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}});

		Executors.newSingleThreadExecutor().execute(new Runnable(){public void run(){
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}});
		System.out.println(Thread.currentThread().getName());

	}
}
