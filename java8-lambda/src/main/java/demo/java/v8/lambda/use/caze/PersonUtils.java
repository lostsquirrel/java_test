package demo.java.v8.lambda.use.caze;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Ideal Use Case for Lambda Expressions
 */
public class PersonUtils {





    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPerson6(List<Person> rosters) {
        printPersonsWithPredicate(
                rosters,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    /**
     *
     *
     * @param rosters person list
     */
    public static void printPersons7(List<Person> rosters) {
        processPersons(
                rosters,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void printPersonsEmail(List<Person> rosters) {
        processPersonsWithFunction(
                rosters,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    /**
     * Approach 8: Use Generics More Extensively
     * @param source
     * @param tester
     * @param mapper
     * @param block
     * @param <X>
     * @param <Y>
     */
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void printPersonsEmail2(List<Person> rosters) {
        processElements(
                rosters,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    public static void printPersonsEmail3(List<Person> rosters) {
        rosters
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }

}
