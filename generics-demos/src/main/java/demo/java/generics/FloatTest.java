package demo.java.generics;

import java.util.Collections;
import java.util.List;

public class FloatTest extends NumberTest<Float> {
    @Override
    public List<Float> getNumber() {
        return Collections.singletonList(0.00000000005f);
    }

    @Override
    protected Float minus(Float sum, Float e) {
        return sum - e;
    }

    @Override
    protected Float nextFloat(Float sum) {
        return r.nextFloat() * sum;
    }

    public static void main(String[] args) {
        List<Float> list = new FloatTest().getRandomListBySum(8, 1f);
        Hello h = new Hello();
        h.setA(list.get(0));
        System.out.println(list);
        System.out.println(h);
    }
}
