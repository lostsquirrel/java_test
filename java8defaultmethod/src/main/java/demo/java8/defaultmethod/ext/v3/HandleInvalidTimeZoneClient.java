package demo.java8.defaultmethod.ext.v3;

import demo.java8.defaultmethod.v2.TimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 重新声明并实现默认方法，则覆盖父类的默认方法
 */
public interface HandleInvalidTimeZoneClient extends TimeClient {

    default ZonedDateTime getZonedDateTime(String zoneString) {
        LogHolder.LOGGER.debug("create ZoneId from {}", zoneString);
        try {
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
        } catch (DateTimeException e) {
            LogHolder.LOGGER.error("Invalid time zone: {}; using default time zone instead.", zoneString);
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.systemDefault());
        }
    }
}
final class LogHolder {
    static final Logger LOGGER = LoggerFactory.getLogger(HandleInvalidTimeZoneClient.class);
}
