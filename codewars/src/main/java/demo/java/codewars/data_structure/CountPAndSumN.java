package demo.java.codewars.data_structure;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://www.codewars.com/kata/count-of-positives-slash-sum-of-negatives/train/java
public class CountPAndSumN {

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input != null && input.length > 0) {
            int[] res = new int[2];
            IntStream s = Arrays.stream(input);
            s.forEach((x) -> {
                        if (x > 0) {
                            res[0] += 1;
                        } else {
                            res[1] += x;
                        }
                    }

            );
            return res;
        }

        return new int[0]; //return an array with count of positives and sum of negatives
    }
}
