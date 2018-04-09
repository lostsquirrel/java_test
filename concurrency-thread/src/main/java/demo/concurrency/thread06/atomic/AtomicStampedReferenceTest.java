package demo.concurrency.thread06.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    public static final int ADD_AMOUNT = 20;
    public static final int REMOVE_AMOUNT = 10;
    public static final int TIMEOUT = 500;

    private static final Logger logger = LoggerFactory.getLogger(AtomicStampedReferenceTest.class);

    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(0, 0);

        for (int i = 0; i < 5; i++) {
            final int timestamp = atomicStampedReference.getStamp();
            new Thread(()-> {
                while (true) {
                    Integer reference = atomicStampedReference.getReference();
                    logger.info(String.format("v: %d", reference));
                    if (reference < 10) {
                        if (atomicStampedReference.compareAndSet(reference, reference + ADD_AMOUNT, timestamp, timestamp + 1)){
                            logger.info(String.format("+%d", ADD_AMOUNT));
                        } else {
                            break;
                        }

                    } else {
                        break;
                    }
                }
            }).start();
            TimeUnit.MILLISECONDS.sleep(TIMEOUT);
        }

        new Thread(()->{
            while (true) {
                Integer reference = atomicStampedReference.getReference();
                final int timestamp = atomicStampedReference.getStamp();
                logger.info(String.format("v: %d", reference));
                if (reference > 0) {
                    if (atomicStampedReference.compareAndSet(reference, reference - REMOVE_AMOUNT, timestamp, timestamp + 1)) {
                        logger.info(String.format("-%d", REMOVE_AMOUNT));
                    } else {
                        break;
                    }

                } else {
                    break;
                }
            }
        }).start();
    }
}
