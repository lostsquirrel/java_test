package demo.java.codewars;

/**
 * https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java
 *
 * you don't want to be early or late!, so should be just 10 elements
 * return you to your starting point, so n s should be at same count while w e should be at same count
 */
public class TenMinWalk {

    private static final char NORTH = 'n';
    private static final char SOUTH = 's';
    private static final char WEST = 'w';
    private static final char EAST = 'e';

    public static boolean isValid(char[] walk) {
        if (walk.length != 10 ){
            return false;
        }
        return count(walk, NORTH) == count(walk, SOUTH) && count(walk, WEST) == count(walk, EAST);
    }

    public static int count(final char[] walk, final char d) {
        int sum = 0;
        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == d) {
                sum++;
            }
        }
        return sum;
    }
}
