package demo.concurrency.thread.dirty.read;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 在一个业务中，取得的数据为修改前的数据或中间数据
 */
public class DirtyReadDemo {

    private static final Logger log = LoggerFactory.getLogger(DirtyReadDemo.class);

    public static final long SLEEP_TIME_IN_TWO_SEC = 2;
    private static final long SLEEP_TIME_IN_ONE_SEC = 1;

    public static void main(String[] args) {
        final Dirty d = new Dirty("oldName", "oldPass");
        new Thread(() -> {
                log.info(d.getValue());
                d.setValue("newName", "newPass");

        }).start();

        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME_IN_ONE_SEC);
            log.info(d.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME_IN_TWO_SEC);
            log.info(d.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
