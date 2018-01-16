package demo.java.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class NumberTest<T extends Number> {

    public abstract List<T> getNumber();

    Random r = new Random();
    public List<T> getRandomListBySum(int size, T sum){
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            T e = nextFloat(sum);
            sum = minus(sum, e);
            System.out.println(String.format("sum:%s, e: %s", sum , e));
            if (i == size - 1) {
                list.add(sum);
            } else {
                list.add(e);
            }

        }
        return list;
    }

    protected abstract T minus(T sum, T e);

    protected abstract T nextFloat(T sum);
}
