package test.concurrency.unsafe;

import demo.concurrency.unsafe.OffHeapArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OffHeapArrayTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        OffHeapArray array = new OffHeapArray(SUPER_SIZE);

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set((long) Integer.MAX_VALUE + i, (byte) 3);
            sum += array.get((long) Integer.MAX_VALUE + i);
        }

        assertEquals(array.size(), SUPER_SIZE);
        assertEquals(sum, 300);
        array.freeMemory();
    }
}
