package demo.java.v8.lambda.use.caze.approach;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 1: Create Methods That Search for Members That Match One Characteristic
 */
public class MatchEach {

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsAsMale(List<Person> roster, Person.Sex gender) {
        for (Person p : roster) {
            if (Person.Sex.MALE.equals(p.getGender())) {
                p.printPerson();
            }
        }
    }
}
