package demo.java8.method.reference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 实例的方法引用
 */
public class MethodParticularObject extends MethodReferenceBaseTest {

    public MethodParticularObject() {
        super(10);
    }

    private ComparisonProvider myComparisonProvider = new ComparisonProvider();

    @Test
    public void testCompareByName() {
        Arrays.sort(getPeopleArray(), myComparisonProvider::compareByName);
    }

    @Test
    public void compareByAge() {
        Arrays.sort(getPeopleArray(), myComparisonProvider::compareByAge);
    }

    class ComparisonProvider {
        int compareByName(Person a, Person b) {
            return a.getName().compareTo(b.getName());
        }

        int compareByAge(Person a, Person b) {
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }
}
