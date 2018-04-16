package demo.java.codewars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001
 */
public class SpinWords {
    public String spinWords(String sentence) {
        int lengthLimit = 4;
        return  Stream.of(sentence.split(" "))
                .map(s -> s.length() > lengthLimit ? new StringBuilder(s).reverse().toString() : s)
                .collect(Collectors.joining(" "));
    }
}
