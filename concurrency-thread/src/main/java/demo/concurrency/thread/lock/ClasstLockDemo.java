package demo.concurrency.thread.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 在静态方法上加synchronized， 锁为当前类(.class)
 * 两个线程使用不同的锁，会竞争锁，一个线程执行完后才会执行另一个
 */
public class ClasstLockDemo {

    private static final Logger log = LoggerFactory.getLogger(ClasstLockDemo.class);

    public static final int TIMEOUT_IN_SEC = 1;

    private static int num = 0;

    private static final String MSG = "tag a, set num over!";

    public static synchronized void printNum(String tag) {
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
        new Thread(() -> new ClasstLockDemo().printNum("a")).start();
        new Thread(() -> new ClasstLockDemo().printNum("b")).start();
    }
}
