package demo.concurrency.thread01.join;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 当前线程会 等待目标线程结束后再继续执行
 */
public class JoinDemo {
    private static final Logger log = LoggerFactory.getLogger(JoinDemo.class);

    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            log.debug("join demo start");
            Utils.doWork(500L);
            log.debug("join demo finished");
        }, "join demo");
        t.start();
        log.debug("start to wait thread join demo");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("main thread finished");
    }
}
