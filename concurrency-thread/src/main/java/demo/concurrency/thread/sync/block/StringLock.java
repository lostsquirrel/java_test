package demo.concurrency.thread.sync.block;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注意String常量池的缓存功能
 * 未发现有啥问题，等验证
 * TODO
 */
public class StringLock {

    private static final Logger log = LoggerFactory.getLogger(StringLock.class);

    public void method() {
        while (true) {
            synchronized ("字符串常量锁") {

                log.info("当前线程 : 开始");
                Utils.doWork(Utils.TIMEOUT_1S);
                log.info("当前线程 : 结束");
                Thread.yield();
            }

        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        new Thread(() -> stringLock.method()).start();
        new Thread(() -> stringLock.method()).start();

    }
}
