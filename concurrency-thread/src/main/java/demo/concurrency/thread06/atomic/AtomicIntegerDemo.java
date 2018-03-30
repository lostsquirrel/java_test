package demo.concurrency.thread06.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {


    public static final int EXPECTED = 0;
    public static final int UPDATE = 10;
    public static final int MAX_THREAD = 5;

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(EXPECTED);

        for(int i = 0; i < MAX_THREAD; i++) {
            new Thread(()->a.compareAndSet(EXPECTED, UPDATE)).start();
        }
        assert a.get() == UPDATE : "AtomicInteger.compareAndSet线程不安全";
    }
}
