package demo.java.v8.lambda.use.caze.approach07;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Approach 7: Use Lambda Expressions Throughout Your Application
 * 引入Consumer  解耦结果输出业务
 * 引入Function<Person, String> 解耦数据清洗处理业务
 */
public class LambdaFull {
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

    public static void printPersonsAgeRanage(List<Person> rosters, int low, int high) {
        processPersons(
                rosters,
                p -> p.getAge() >= low
                        && p.getAge() <= high,
                p -> p.printPerson()
        );
    }

    public static void printPersonEmailByAgeRange(List<Person> rosters, int low, int high) {
        processPersonsWithFunction(
                rosters,
                p -> p.getAge() >= low
                        && p.getAge() <= high,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }
}
