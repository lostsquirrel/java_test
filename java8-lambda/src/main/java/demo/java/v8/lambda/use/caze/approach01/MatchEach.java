package demo.java.v8.lambda.use.caze.approach01;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 1: Create Methods That Search for Members That Match One Characteristic
 * 缺点：
 * 1. 重复代码
 * 2. 不方便业务修改
 */
public class MatchEach {

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsGender(List<Person> roster, Person.Sex gender) {
        for (Person p : roster) {
            if (gender.equals(p.getGender())) {
                p.printPerson();
            }
        }
    }
}
