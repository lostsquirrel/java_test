package demo.java8.defaultmethod.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient  {

    LocalDateTime getLocalDateTime();

    static ZoneId getZoneId (String zoneString) {
        LogHolder.LOGGER.debug("create ZoneId from {}", zoneString);
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            LogHolder.LOGGER.error("Invalid time zone: {}; using default time zone instead.", zoneString);
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}

final class LogHolder {
    static final Logger LOGGER = LoggerFactory.getLogger(TimeClient.class);
}

