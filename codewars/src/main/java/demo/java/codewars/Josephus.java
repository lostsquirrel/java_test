package demo.java.codewars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://www.codewars.com/kata/5550d638a99ddb113e0000a2/train/java
 * they formed a circle and proceeded to kill one man every three,
 * until one last man was left (and that it was supposed to kill himself to end the act)
 */
public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> josephus = new ArrayList<>();
        int amount = items.size();

        int x = 1;
        while(!items.isEmpty()) {
            for ( Iterator<T> it = items.iterator();it.hasNext();) {
                T t = it.next();
                if (x % k == 0) {
                    josephus.add(t);
                    it.remove();
                }
                x++;
            }
        }

        return josephus;
    }
}
