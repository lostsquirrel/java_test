package demo.java8.method.reference;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 静态方法使用
 */
public class MethodStatic extends MethodReferenceBaseTest {

    public MethodStatic() {
        super(10);
    }

    @Test
    public void compareByAge() {
        Arrays.sort(getPeopleArray(), Person::compareByAge);
    }
}
