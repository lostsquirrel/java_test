package demo.concurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeUtils {

    private static Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }
}
