package demo.java8.streams.test.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StartTest {

    @Test
    public void testStart() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
