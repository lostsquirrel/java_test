package demo.concurrency.thread06.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * compareAndSet 应该怎么用以达到同样的效果
 */
public class AtomicReferenceCounter {

    private AtomicReference<Long> v = new AtomicReference(0L);

    public void increment() {
        v.getAndUpdate(aLong -> aLong + 1);
    }

    public long get() {
        return v.get();
    }
}
