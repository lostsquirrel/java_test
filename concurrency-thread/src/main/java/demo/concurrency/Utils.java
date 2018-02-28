package demo.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 并发示例工具类
 */
public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static final int TIMEOUT_1S = 1;
    public static final int TIMEOUT_2S = 2;
    public static final int TIMEOUT_3S = 3;
    public static final int TIMEOUT_4S = 4;
    public static final int TIMEOUT_5S = 5;

    public static final long TIMEOUT_100MS = 100;
    /**
     * 睡眠指定毫秒
     * @param timeout 睡眠时长
     */
    public static void doWork(long timeout) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        doWork(timeout, timeUnit);
    }

    /**
     * 用睡觉代替工作
     * @param timeout 睡眠时长
     * @param timeUnit 时间单位
     */
    private static void doWork(long timeout, TimeUnit timeUnit) {
        try {
            log.debug("do work in {} {}", timeout, timeUnit.toString());
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 睡眠指定秒
     * @param timeout 睡眠时长
     */
    public static void doWork(int timeout) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        doWork(timeout, timeUnit);
    }

    /**
     * 假装工作的任务
     * @param amount 循环次数
     */
    public static void busyBoy(int amount) {
        int logStep = amount / 10;
        for (int i = 0; i < amount; i++) {
            if (i % logStep == 0) {
                log.debug("busy boy count to {}", i);
            }
        }
    }
}
