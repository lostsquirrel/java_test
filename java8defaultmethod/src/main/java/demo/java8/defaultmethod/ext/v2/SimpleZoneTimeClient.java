package demo.java8.defaultmethod.ext.v2;


import demo.java8.defaultmethod.ext.v1.AnotherTimeClient;
import demo.java8.defaultmethod.v2.TimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * 不需要实现 getZonedDateTime 方法就可以直接使用
 */
public class SimpleZoneTimeClient implements AbstractZoneTimeClient {

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
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in China: " +
                myTimeClient.getZonedDateTime("Blah blah").toString());
    }

    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
       LOGGER.debug("create ZoneId from {}", zoneString);
        return ZonedDateTime.of(getLocalDateTime(), TimeClient.getZoneId(zoneString));
    }
}
