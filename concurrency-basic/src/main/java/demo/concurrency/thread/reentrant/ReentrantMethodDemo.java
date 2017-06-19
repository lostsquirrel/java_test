package demo.concurrency.thread.reentrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * synchronized的重入， 因此第一个线程执行完三个方法才会开始第二个线程
 */
public class ReentrantMethodDemo {

    private static final Logger log = LoggerFactory.getLogger(ReentrantMethodDemo.class);

    public static final int SLEEP_TIME_A_HUNDRED_MS = 100;

    public synchronized void method1() {
        doSomeWork();
        log.info("method1..");
        method2();
    }

    private void doSomeWork() {
        try {
            TimeUnit.MILLISECONDS.sleep(SLEEP_TIME_A_HUNDRED_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        doSomeWork();
        log.info("method2..");
        method3();
    }

    public synchronized void method3() {
        doSomeWork();
        log.info("method3..");
    }

    public static void main(String[] args) {
        final ReentrantMethodDemo d = new ReentrantMethodDemo();
        new Thread(() -> d.method1()).start();
        new Thread(() -> d.method1()).start();
    }
}
