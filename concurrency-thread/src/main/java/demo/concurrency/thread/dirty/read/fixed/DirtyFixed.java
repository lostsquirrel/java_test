package demo.concurrency.thread.dirty.read.fixed;

import java.util.concurrent.TimeUnit;

/**
 * setValue 和 getValue 为互斥的
 */
public class DirtyFixed {

    private static final long SLEEP_TIME_IN_TWO_SEC = 2;
    private String username;

    private String password;

    public synchronized void setValue(String username, String password) {
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME_IN_TWO_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.username = username;
        this.password = password;
    }

    public synchronized String getValue() {
        return String.format("username: %s, password: %s", username, password);
    }

    public DirtyFixed(String username, String password) {
        this.setValue(username, password);
    }
}
