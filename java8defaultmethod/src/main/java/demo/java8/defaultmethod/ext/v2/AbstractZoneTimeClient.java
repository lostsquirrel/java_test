package demo.java8.defaultmethod.ext.v2;

import demo.java8.defaultmethod.v2.TimeClient;

import java.time.ZonedDateTime;

/**
 * 重新声明默认方法，则此方法重新变为 `abstract`
 */
public interface AbstractZoneTimeClient extends TimeClient {
    ZonedDateTime getZonedDateTime(String zoneString);
}
