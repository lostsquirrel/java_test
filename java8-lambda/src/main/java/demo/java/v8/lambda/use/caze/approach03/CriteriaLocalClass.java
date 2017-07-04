package demo.java.v8.lambda.use.caze.approach03;

import demo.java.v8.lambda.use.caze.CheckPerson;
import demo.java.v8.lambda.use.caze.CheckPersonProcessor;
import demo.java.v8.lambda.use.caze.Person;

import java.util.List;

/**
 * Approach 3: Specify Search Criteria Code in a Local Class
 * 将查询代码封装为本地类
 * 面向接口编程，进步了
 */
public class CriteriaLocalClass extends CheckPersonProcessor {

    static class CheckPersonAgeRangeService implements CheckPerson {
        private int low;
        private int heigh;
        CheckPersonAgeRangeService (int low, int high) {
            this.low = low;
            this.heigh = high;
        }

        public boolean test(Person p) {
            return p.getAge() >= low &&
                    p.getAge() <= heigh;
        }
    }

    /**
     *
     *
     * @param rosters person list
     */
    public static void printPersonsWithinAgeRange(List<Person> rosters, int low, int high) {
        printPersons(rosters, new CheckPersonAgeRangeService(low, high));
    }
}
