package demo.concurrency.thread.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 在成员方法上加synchronized， 锁为当前对象
 * 两个线程使用不同的锁，不会竞争锁，基本同时执行
 */
public class ObjectLockDemo {

    private static final Logger log = LoggerFactory.getLogger(ObjectLockDemo.class);

    public static final int TIMEOUT_IN_SEC = 1;

    private int num = 0;

    private static final String MSG = "tag a, set num over!";

    public synchronized void printNum(String tag) {
        try {

            if (tag.equals("a")) {
                num = 100;
                log.debug(MSG, tag);
                TimeUnit.SECONDS.sleep(TIMEOUT_IN_SEC);
            } else {
                num = 200;
                log.debug(MSG, tag);
            }
            log.debug("tag {}, num = {}", tag, num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> new ObjectLockDemo().printNum("a")).start();
        new Thread(() -> new ObjectLockDemo().printNum("b")).start();
    }
}
