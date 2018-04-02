package test.concurrency.unsafe;

import demo.concurrency.unsafe.InitializationOrdering;
import demo.concurrency.unsafe.UnsafeUtils;
import org.junit.Test;
import sun.misc.Unsafe;

import static org.junit.Assert.assertEquals;

public class InitializationOrderingTest {

    Unsafe unsafe = UnsafeUtils.getUnsafe();
    @Test
    public void normalInitialization() {
        InitializationOrdering o1 = new InitializationOrdering();
        assertEquals(o1.getA(), 1);
    }

    /**
     * @throws InstantiationException
     * create the instance without calling the constructor
     */
    @Test
    public void unsafeInitialization() throws InstantiationException {
        InitializationOrdering o3
                = (InitializationOrdering) unsafe.allocateInstance(InitializationOrdering.class);

        assertEquals(o3.getA(), 0);
    }


}
