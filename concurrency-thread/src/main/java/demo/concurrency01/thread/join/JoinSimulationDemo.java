package demo.concurrency01.thread.join;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证：在主线程直接使用目标线程对象调用 wait(),
 * 预期：主线程会在该线程结束后结束
 */
public class JoinSimulationDemo {
    private static final Logger log = LoggerFactory.getLogger(JoinSimulationDemo.class);

    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            log.debug("join simulation demo start");
            Utils.doWork(500L);
            log.debug("join simulation demo finished");
        }, "join simulation demo");
        t.start();
        log.debug("start to wait thread join simulation demo");
        synchronized (t) {
            try {
                t.wait(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.debug("main thread finished");
    }
}
