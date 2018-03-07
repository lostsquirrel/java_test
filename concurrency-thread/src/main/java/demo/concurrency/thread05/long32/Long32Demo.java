package demo.concurrency.thread05.long32;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Long32Demo {

    private static final Logger log = LoggerFactory.getLogger(Long32Demo.class);

    public static void main(String[] args) {

        Longer longer = new Longer();
        Thread writer = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                longer.change();
            }
        }, "writer");
        writer.start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                log.debug("current value is {}", longer.read());
            }
            writer.interrupt();
        }, "reader").start();
    }

}

class Longer {
    long item = Long.MAX_VALUE >> 1;

    void change() {
        item -= 1;
    }

    long read() {
        return item;
    }
}
