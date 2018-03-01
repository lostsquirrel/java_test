package demo.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Vector;

public class LiftOff implements Runnable {

    protected int countDown = 10; // Default

    private static int taskCount = 0;

    private final int id = taskCount++;

    private boolean showDetail = true;

    private static final Logger log = LoggerFactory.getLogger(LiftOff.class);

    public LiftOff() {
        init();
    }

    private void init() {
        log.debug("create LiftOff #{}", id);
    }

    public LiftOff(int countDown) {
        init();
        this.countDown = countDown;
    }

    public LiftOff(int countDown, boolean showDetail) {
        init();
        this.countDown = countDown;
        this.showDetail = showDetail;
    }

    public String status() {
        return String.format("#%d(%s)", id, (countDown > 0 ? countDown : "Liftoff!"));
    }

    public void run() {
        while (countDown-- > 0) {
            if (showDetail) {
                log.info(status());
            } else {
                if (countDown == 0) {
                    log.info(status());
                    log.debug("priority: {}", Thread.currentThread().getPriority());
                }
            }

            Thread.yield();
        }
    }
}