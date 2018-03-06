package demo.java8.defaultmethod.ext.v1;


import demo.java8.defaultmethod.v2.TimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 不需要实现 getZonedDateTime 方法就可以直接使用
 */
public class SimpleTimeClient implements AnotherTimeClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTimeClient.class);

    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
        dateAndTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    public String toString() {
        return dateAndTime.toString();
    }

    public static void main(String... args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        LOGGER.info("Current time: {}", myTimeClient.toString());
        LOGGER.info("Time in China: {}", myTimeClient.getZonedDateTime("Blah blah"));
    }
}
