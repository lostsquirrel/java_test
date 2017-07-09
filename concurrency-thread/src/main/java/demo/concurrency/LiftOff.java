package demo.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiftOff implements Runnable {

    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    private static final Logger log = LoggerFactory.getLogger(LiftOff.class);

    public LiftOff() {
        log.debug("create LiftOff #{}", id);
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return String.format("#%d(%s)", id, (countDown > 0 ? countDown : "Liftoff!"));
    }

    public void run() {
        while (countDown-- > 0) {
            log.info(status());
            Thread.yield();
        }
    }
}