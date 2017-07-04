package demo.java.v8.lambda.use.caze.approach04;

import demo.java.v8.lambda.use.caze.CheckPerson;
import demo.java.v8.lambda.use.caze.CheckPersonProcessor;
import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 4: Specify Search Criteria Code in an Anonymous Class
 * 又是一个牵强的例子
 */
public class CriteriaAnonymousClass extends CheckPersonProcessor {
    /**
     *
     *
     * @param rosters person list
     */
    public static void printPersonsAgeRanage(List<Person> rosters, int low, int high) {
        printPersons(rosters, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= low
                        && p.getAge() <= high;
            }
        });
    }

}
