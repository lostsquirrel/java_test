package demo.java8.method.reference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.shangao.generator.EmailGenerator;
import tech.shangao.generator.NameGenerator;
import tech.shangao.generator.date.DateGenerator;
import tech.shangao.generator.number.IntGenerator;

import java.time.ZoneId;
import java.util.*;
import java.util.function.Supplier;

public abstract class MethodReferenceBaseTest {

    private static final Person.Sex[] genders = new Person.Sex[]{Person.Sex.MALE, Person.Sex.FEMALE};

    private static final Logger log = LoggerFactory.getLogger(MethodReferenceBaseTest.class);

    private List<Person> roster;

    private Person[] personArray;

    public MethodReferenceBaseTest(int size) {
        roster = getRandomPersonList(size);
        personArray = roster.toArray(new Person[roster.size()]);
    }

    @Before
    public void init() {
        printPersonArray(getPeopleArray());
    }

    private List<Person> getRandomPersonList(int size) {
        List<Person> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Person p = new Person();
            p.setBirthday(DateGenerator.randam().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            String name = NameGenerator.random();
            String email = String.format("%s@%s", name, EmailGenerator.random());
            p.setEmailAddress(email);
            p.setName(name);
            p.setGender(genders[IntGenerator.random(2)]);
            log.debug("create person {}", p.getName());

            list.add(p);
        }
        log.debug("------------- create person finished -------------");
        return list;
    }

    @Test
    public void testSortInOldWay() {
        Person[] rosterAsArray = getPeopleArray();
        printPersonArray(rosterAsArray);
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        printPersonArray(rosterAsArray);
    }

    @After
    public void destroy() {
        printPersonArray(getPeopleArray());
    }

    protected Person[] getPeopleArray() {
        return personArray;
    }

    protected List<Person> getPeopleList() {
        return roster;
    }

    private void printPersonArray(Person[] rosterAsArray) {
        log.debug("-------------start to print person------------------");
        for (Person person : rosterAsArray) {
            log.debug("{}-{}", person.getName(), person.getAge());
        }
        log.debug("-------------person print finished------------------");
    }

    protected void printPersonArray(Collection<Person> collection) {
        for (Person person : collection) {
            log.debug("{}-{}", person.getName(), person.getAge());
        }
    }


    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        result.addAll(sourceCollection);
        return result;
    }

}
