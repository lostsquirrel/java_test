package demo.concurrency.thread.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 当多个线程访问这一个类时，这个对象能表现出正确的行为 从 4 依次打印到 0
 * 线程安全
 */
public class SafeThreadDemo extends Thread {

    private static final Logger log = LoggerFactory.getLogger(SafeThreadDemo.class);

    private int count = 5;

    // synchronized加锁
    public synchronized void run() {
        count--;
        log.debug("{}", count);
    }

    public static void main(String[] args) {
        Thread t = new SafeThreadDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(t).start();
        }
    }

}
