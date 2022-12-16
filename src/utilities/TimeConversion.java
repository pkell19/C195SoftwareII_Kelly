package utilities;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Array;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeConversion {

    private static final ZoneId UTC_ZONE_ID = ZoneId.of("UTC");
    private static final ZoneId LOCAL_ZONE_ID = ZoneId.systemDefault();

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

    public static ObservableList<LocalTime> timeList() {
        LocalTime start = LocalTime.of(0, 0);
        LocalTime end = LocalTime.of(23, 0);
        ObservableList<LocalTime> times = FXCollections.observableArrayList();
        while(start.isBefore(end.plusSeconds(1))){
            start = start.plusMinutes(30);
            times.add(start);
        }
        return times;
    }

    public static String convertTSDateToString (Timestamp timestamp) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime ldt = timestamp.toLocalDateTime();
        return dtf.format(ldt);
    }

    public static String convertTSTimeToString (Timestamp timestamp) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime ldt = timestamp.toLocalDateTime();
        return dtf.format(ldt);
    }

    public static String convertTSDateTimeToString (Timestamp timestamp) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        LocalDateTime ldt = timestamp.toLocalDateTime();
        return dtf.format(ldt);
    }

    public static String convertLDTToString (LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        return dtf.format(localDateTime);
    }
}
