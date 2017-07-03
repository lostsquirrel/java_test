package demo.concurrency.thread.volatilea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 因为 volatile 字段的线程不安全性，所以最后一个线程打印的数字很大可能不是 10000 (= 1000 * 10)
 */
public class VolatileUnsafeDemo {

    private static final Logger log = LoggerFactory.getLogger(VolatileUnsafeDemo.class);

    private volatile int count;

    public void increment() {
        count++;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        final VolatileUnsafeDemo vuf = new VolatileUnsafeDemo();
        for (int i = 0; i <= 9; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    vuf.increment();
                }
                log.info("{}", vuf.count());
            }).start();
        }
    }
}
