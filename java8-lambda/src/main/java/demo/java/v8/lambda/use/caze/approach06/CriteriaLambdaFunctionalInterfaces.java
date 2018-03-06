package demo.java.v8.lambda.use.caze.approach06;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Approach 6: Use Standard Functional Interfaces with Lambda Expressions
 * 引入Predicate （Functional Interfaces）解耦判断业务
 * Functional Interfaces的具体使用还要研究下
 */
public class CriteriaLambdaFunctionalInterfaces {

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsAgeRanage(List<Person> rosters, int low, int high) {
        printPersonsWithPredicate(
                rosters,
                p -> p.getAge() >= low
                        && p.getAge() <= high
        );
    }

}
