package demo.java.codewars.data_structure;

import java.util.Arrays;

//https://www.codewars.com/kata/count-of-positives-slash-sum-of-negatives/train/java
public class CountPAndSumN {

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input != null && input.length > 0) {
            return new int[]{(int) Arrays.stream(input).filter(e -> e > 0).count(), Arrays.stream(input).filter(e-> e < 0).sum()};
        }

        return new int[0]; //return an array with count of positives and sum of negatives
    }
}
