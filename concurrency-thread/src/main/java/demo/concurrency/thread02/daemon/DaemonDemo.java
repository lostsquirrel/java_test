package demo.concurrency.thread02.daemon;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 当一个Java应用内，只有守护线程时，Java虚拟机就会自然退出
 * 当主线程结束后，程序结束, 且数字打印还未到设置的值
 */
public class DaemonDemo {
    private static final Logger log = LoggerFactory.getLogger(DaemonDemo.class);

    public static void main(String[] args) {

        Thread t = new Thread(()-> Utils.busyBoy(Integer.MAX_VALUE), "daemon thread demo");
        t.setDaemon(true);
        t.start();
        Utils.doWork(Utils.TIMEOUT_3S);
        log.debug("main thread finished");
    }
}
