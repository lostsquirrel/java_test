package test.concurrency.unsafe;

import demo.concurrency.unsafe.UnsafeUtils;
import org.junit.Test;
import sun.misc.Unsafe;

import java.io.IOException;

public class ThrowingExceptionTest {

    Unsafe unsafe = UnsafeUtils.getUnsafe();

    /**
     * After throwing an IOException, which is checked, we don’t need to catch it nor specify it in the method declaration.
     */
    @Test(expected = IOException.class)
    public void test() {
        unsafe.throwException(new IOException());
    }
}
