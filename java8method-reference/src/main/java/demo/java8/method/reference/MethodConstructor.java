package demo.java8.method.reference;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 构造器 方法引用
 */
public class MethodConstructor extends MethodReferenceBaseTest {

    public MethodConstructor() {
        super(10);
    }

    @Test
    public void testAsLambda() {
        List<Person> peopleList = getPeopleList();
        Set<Person> rosterSetLambda =
                transferElements(peopleList, () -> { return new HashSet<>(); });
        printPersonArray(peopleList);
        printPersonArray(rosterSetLambda);
    }

    @Test
    public void testConstructor() {
        List<Person> peopleList = getPeopleList();
        Set<Person> rosterSet = transferElements(peopleList, HashSet::new);
        printPersonArray(peopleList);
        printPersonArray(rosterSet);
    }
}
