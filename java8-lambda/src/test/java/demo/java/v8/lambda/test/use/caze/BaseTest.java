package demo.java.v8.lambda.test.use.caze;

import demo.java.v8.lambda.use.caze.Person;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    public List<Person> getRandomPersonList(int size) {
        List<Person> list = new ArrayList<>(size);
        for (int i = 0; i <size; i++) {
            Person p = new Person();

        }
        return list;
    }
}
