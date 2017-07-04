package demo.java.v8.lambda.use.caze.approach02;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 2: Create More Generalized Search Methods
 * 这也是第二种方式，Oracle 讲 lambda 也是拼了
 */
public class MatchRange {

    /**
     *
     *
     * @param roster person list
     * @param low    age lowest limit
     * @param high   age highest limit
     */
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
}
