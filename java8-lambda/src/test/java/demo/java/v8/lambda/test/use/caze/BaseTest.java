package demo.java.v8.lambda.test.use.caze;

import demo.java.v8.lambda.use.caze.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.shangao.generator.EmailGenerator;
import tech.shangao.generator.NameGenerator;
import tech.shangao.generator.date.DateGenerator;
import tech.shangao.generator.number.IntGenerator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private static final Person.Sex[] genders = new Person.Sex[]{Person.Sex.MALE, Person.Sex.FEMALE};

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public  List<Person> getRandomPersonList(int size) {
        List<Person> list = new ArrayList<>(size);

        for (int i = 0; i <size; i++) {
            Person p = new Person();
            p.setBirthday(DateGenerator.randam().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            String name = NameGenerator.random();
            String email = String.format("%s@%s", name, EmailGenerator.random());
            p.setEmailAddress(email);
            p.setName(name);
            p.setGender(genders[IntGenerator.random(2)]);
            log.debug("create person");
            p.printPerson();
            list.add(p);
        }
        log.debug("------------- create person finished -------------");
        return list;
    }
}
