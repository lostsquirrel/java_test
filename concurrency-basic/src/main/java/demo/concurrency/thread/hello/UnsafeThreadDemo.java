package demo.concurrency.thread.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 当多个线程访问这一个类时，这个对象不能表现出正确的行为 从 4 依次打印到 0
 * 线程不安全
 */
public class UnsafeThreadDemo extends Thread {

    private static final Logger log = LoggerFactory.getLogger(UnsafeThreadDemo.class);

    private int count = 5;

//    未synchronized加锁
    public void run() {
        count--;
        log.debug("{}", count);
    }

    public static void main(String[] args) {
        Thread t = new UnsafeThreadDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(t).start();
        }
    }

}
