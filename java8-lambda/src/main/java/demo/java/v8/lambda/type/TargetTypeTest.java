package demo.java.v8.lambda.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class TargetTypeTest {

    private static final Logger log = LoggerFactory.getLogger(TargetTypeTest.class);

    private void invoke(Runnable r) {
        log.debug("Runnable invoke");
        r.run();
    }

    private <T> T invoke(Callable<T> c) throws Exception {
        log.debug("Callable invoke ");
        return c.call();
    }

    public static void main(String[] args) throws Exception {
        TargetTypeTest tt = new TargetTypeTest();

        String s = tt.invoke(() -> "done");
        log.debug(s);
        tt.invoke(() -> {
        });
    }
}
