package test.concurrency.unsafe;

import demo.concurrency.unsafe.SecretHolder;
import demo.concurrency.unsafe.UnsafeUtils;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class AlteringPrivateFieldTest {

    Unsafe unsafe = UnsafeUtils.getUnsafe();

    /**
     * @throws NoSuchFieldException
     *
     * Once we get a field by the reflection call, we can alter its value to any other int value using the Unsafe.
     */
    @Test
    public void test() throws NoSuchFieldException {
        SecretHolder secretHolder = new SecretHolder();

        Field f = secretHolder.getClass().getDeclaredField("SECRET_VALUE");
        unsafe.putInt(secretHolder, unsafe.objectFieldOffset(f), 1);

        assertTrue(secretHolder.secretIsDisclosed());
    }
}
