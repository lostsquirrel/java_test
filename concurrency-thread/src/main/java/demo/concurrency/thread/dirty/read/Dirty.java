package demo.concurrency.thread.dirty.read;

import java.util.concurrent.TimeUnit;

public class Dirty {

    private String username;

    private String password;

    private static final Long SLEEP_TIME_IN_TWO_SEC = 2L;
    public void setValue(String username, String password) {
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME_IN_TWO_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.username = username;
        this.password = password;
    }

    public String getValue() {
        return String.format("username: %s, password: %s", username, password);
    }

    public Dirty(String username, String password) {
        this.setValue(username, password);
    }
}
