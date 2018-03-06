package demo.java.v8.lambda.use.caze;

import java.util.List;

public class CheckPersonProcessor {
    /**
     * 解耦查询方法和查询逻辑
     * @param roster person list
     * @param tester characteristic tester
     */
    protected static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
