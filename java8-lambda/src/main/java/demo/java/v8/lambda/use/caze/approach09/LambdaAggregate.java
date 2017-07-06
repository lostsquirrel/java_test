package demo.java.v8.lambda.use.caze.approach09;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * 使用jdk聚合操作，
 *
 */
public class LambdaAggregate {
    public static void printPersonEmailByAgeRange(List<Person> rosters, int low, int high) {
        rosters
                .stream()
                .filter(
                        p -> p.getAge() >= low
                                && p.getAge() <= high)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }
}
