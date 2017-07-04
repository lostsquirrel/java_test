package demo.java.v8.lambda.use.caze.approach05;

import demo.java.v8.lambda.use.caze.CheckPersonProcessor;
import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 5: Specify Search Criteria Code with a Lambda Expression
 * 并没有看到有什么好处
 */
public class CriteriaLambda extends CheckPersonProcessor {
    /**
     *
     *
     * @param rosters person list
     */
    public static void printPersonsAgeRanage(List<Person> rosters, int low, int high) {
        printPersons(
                rosters,
                (Person p) -> p.getAge() >= low
                        && p.getAge() <= high
        );
    }

}
