package test.concurrency.unsafe;

import demo.concurrency.unsafe.CASCounter;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CASCounterTest {

    @Test
    public void test() throws Exception {
        int NUM_OF_THREADS = 1_000;
        int NUM_OF_INCREMENTS = 10_000;
        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
        CASCounter casCounter = new CASCounter();

        IntStream.rangeClosed(0, NUM_OF_THREADS - 1)
                .forEach(i -> service.submit(() -> IntStream
                        .rangeClosed(0, NUM_OF_INCREMENTS - 1)
                        .forEach(j -> casCounter.increment())));
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(NUM_OF_INCREMENTS * NUM_OF_THREADS, casCounter.getCounter());
    }
}
