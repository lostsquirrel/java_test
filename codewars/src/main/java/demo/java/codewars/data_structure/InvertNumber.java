package demo.java.codewars.data_structure;

import java.util.Arrays;

//https://www.codewars.com/kata/invert-values/train/java
public class InvertNumber {

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(x -> x * -1).toArray();
    }
}
