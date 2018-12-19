package demo.java.codewars.algorithm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.codewars.com/kata/simple-pig-latin/train/java
public class SimplePigLatin {

    public static String pigIt(String str) {
        // Write code here
        return Stream.of(str.split(" "))
                .map(s -> {
                    if (s.chars().allMatch(Character::isLetter)) {
                        return new StringBuilder(s).delete(0, 1).append(s, 0, 1).append("ay").toString();
                    } else {
                        return s;
                    }

                })
                .collect(Collectors.joining(" "));
    }
}
