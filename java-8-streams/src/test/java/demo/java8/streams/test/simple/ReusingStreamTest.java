package demo.java8.streams.test.simple;

import org.junit.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReusingStreamTest {

    @Test(expected = IllegalStateException.class)
    public void testGut() {
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        stream.noneMatch(s -> true);   // exception
    }

    @Test
    public void test() {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
    }
}
