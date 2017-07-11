package demo.java8.method.reference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 类的实例方法
 */
public class MethodArbitraryObjectParticularType {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodArbitraryObjectParticularType.class);

    String[] stringArray = { "Barbara", "James", "Mary", "John",
            "Patricia", "Robert", "Michael", "Linda" };

    @Before
    public void init() {
        LOGGER.debug("{}", Arrays.toString(stringArray));
    }

    @Test
    public void test() {
        Arrays.sort(stringArray, String::compareToIgnoreCase);
    }

    @After
    public void destroy() {
        LOGGER.debug("{}", Arrays.toString(stringArray));
    }
}
