package demo.java8.streams.test.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamsTest {

    @Test
    public void testArraysAsList() {
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void testStreamOf() {
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1
    }

    @Test
    public void testIntStreamRange() {
        IntStream.range(1, 4).forEach(System.out::println);
    }
}
