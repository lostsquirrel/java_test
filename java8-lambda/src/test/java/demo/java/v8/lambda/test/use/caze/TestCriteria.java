package demo.java.v8.lambda.test.use.caze;

import demo.java.v8.lambda.use.caze.approach03.CriteriaLocalClass;
import demo.java.v8.lambda.use.caze.approach04.CriteriaAnonymousClass;
import demo.java.v8.lambda.use.caze.approach05.CriteriaLambda;
import demo.java.v8.lambda.use.caze.approach06.CriteriaLambdaFunctionalInterfaces;
import org.junit.Test;

public class TestCriteria extends BaseTest {

    private int size = 10;
    private int low = 18;
    private int high = 38;

    @Test
    public void testCriteriaLocalClass() {
        CriteriaLocalClass.printPersonsWithinAgeRange(super.getRandomPersonList(size), low, high);
    }

    @Test
    public void testCriteriaAnonymousClass() {
        CriteriaAnonymousClass.printPersonsAgeRanage(super.getRandomPersonList(size), low, high);
    }

    @Test
    public void testCriteriaLambda() {
        CriteriaLambda.printPersonsAgeRanage(getRandomPersonList(size), low, high);
    }

    @Test public void testCriteriaLambdaFunctionalInterfaces() {
        CriteriaLambdaFunctionalInterfaces.printPersonsAgeRanage(getRandomPersonList(size), low, high);
    }
}
