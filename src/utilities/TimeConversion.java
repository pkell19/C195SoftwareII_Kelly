package utilities;

import java.sql.Timestamp;
import java.time.*;

public class TimeConversion {

    private static ZoneId UTC_ZONE_ID = ZoneId.of("UTC");
    private static ZoneId LOCAL_ZONE_ID = ZoneId.systemDefault();

    public static Timestamp convertLDTtoUTCTimestamp(LocalDate localDate, LocalTime localTime) {

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZonedDateTime localZDT = ZonedDateTime.of(localDateTime, LOCAL_ZONE_ID);
        ZonedDateTime utcZDT = localZDT.withZoneSameInstant(UTC_ZONE_ID);
        LocalDateTime utcLDT = utcZDT.toLocalDateTime();
        return Timestamp.valueOf(utcLDT);
    }

    public static Timestamp convertLDTtoUTCTimestamp(LocalDateTime localDateTime) {

        ZonedDateTime localZDT = ZonedDateTime.of(localDateTime, LOCAL_ZONE_ID);
        ZonedDateTime utcZDT = localZDT.withZoneSameInstant(UTC_ZONE_ID);
        LocalDateTime utcLDT = utcZDT.toLocalDateTime();
        return Timestamp.valueOf(utcLDT);
    }

    public static LocalDateTime convertUTCTimestamptoLDT(Timestamp utcTS) {
        LocalDateTime utcLDT = utcTS.toLocalDateTime();
        ZonedDateTime localZDT = ZonedDateTime.ofInstant(Instant.from(utcLDT), LOCAL_ZONE_ID);
        return localZDT.toLocalDateTime();
    }

}
