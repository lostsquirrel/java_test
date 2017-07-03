package demo.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 并发示例工具类
 */
public class Utils {

    public static final int TIMEOUT_1S = 1;
    public static final int TIMEOUT_2S = 2;
    public static final int TIMEOUT_3S = 3;
    public static final int TIMEOUT_4S = 4;
    public static final int TIMEOUT_5S = 5;

    public static final long TIMEOUT_100MS = 100;
    public static final long TIMEOUT_500MS = 500;
    /**
     * 睡眠指定毫秒
     * @param timeout 睡眠时长
     */
    public static void doWork(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 睡眠指定秒
     * @param timeout 睡眠时长
     */
    public static void doWork(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
