package demo.java.v8.lambda.use.caze.approach08;

import demo.java.v8.lambda.use.caze.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 引入泛型，解耦业务对象
 */
public class LambdaGenerics {
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void printPersonEmailByAgeRange(List<Person> rosters, int low, int high) {
        processElements(
                rosters,
                p -> p.getAge() >= low
                        && p.getAge() <= high,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }
}
