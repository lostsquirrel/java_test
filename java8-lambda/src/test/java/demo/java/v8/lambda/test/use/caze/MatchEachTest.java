package demo.java.v8.lambda.test.use.caze;

import demo.java.v8.lambda.use.caze.Person;
import demo.java.v8.lambda.use.caze.approach01.MatchEach;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MatchEachTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(MatchEachTest.class);

    private static List<Person> rosters;

    @Before
    public void init() {
        rosters = getRandomPersonList(10);
        log.debug("real size is {}", rosters.size());
    }

    @Test
    public void testGender() {
        MatchEach.printPersonsGender(rosters, Person.Sex.MALE);
    }

    @Test
    public void testAge() {
        MatchEach.printPersonsOlderThan(rosters, 18);
    }
}
