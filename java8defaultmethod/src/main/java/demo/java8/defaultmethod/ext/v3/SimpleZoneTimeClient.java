package demo.java8.defaultmethod.ext.v3;


import demo.java8.defaultmethod.ext.v2.AbstractZoneTimeClient;
import demo.java8.defaultmethod.v2.TimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * 重新声明并实现默认方法，则覆盖父类的默认方法
 */
public class SimpleZoneTimeClient implements HandleInvalidTimeZoneClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleZoneTimeClient.class);

    private LocalDateTime dateAndTime;

    public SimpleZoneTimeClient() {
        dateAndTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    public String toString() {
        return dateAndTime.toString();
    }

    public static void main(String... args) {
        TimeClient myTimeClient = new SimpleZoneTimeClient();
        LOGGER.info("Current time: {}", myTimeClient.toString());
        LOGGER.info("Time in China: {}", myTimeClient.getZonedDateTime("Blah blah"));
    }

}
