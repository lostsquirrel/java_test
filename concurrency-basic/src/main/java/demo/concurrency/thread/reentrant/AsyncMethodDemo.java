package demo.concurrency.thread.reentrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 无锁， 因此第一个线程与第二个线程可能交替
 */
public class AsyncMethodDemo {

    private static final Logger log = LoggerFactory.getLogger(AsyncMethodDemo.class);

    public static final int SLEEP_TIME_A_HUNDRED_MS = 100;

    public void method1() {
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

    public void method2() {
        doSomeWork();
        log.info("method2..");
        method3();
    }

    public void method3() {
        doSomeWork();
        log.info("method3..");
    }

    public static void main(String[] args) {
        final AsyncMethodDemo d = new AsyncMethodDemo();
        new Thread(() -> d.method1()).start();
        new Thread(() -> d.method1()).start();
    }
}
