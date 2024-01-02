package demo.jdk17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateConversionExample {

    public static void main(String[] args) {
        // Example Date in EST
        Date estDate = getEstDate();

        // Convert Date to LocalDateTime in UTC
        LocalDateTime utcLocalDateTime = convertEstDateToUtc(estDate);

        // Print the result
        System.out.println("EST Date: " + estDate);
        System.out.println("UTC LocalDateTime: " + utcLocalDateTime);
    }

    private static Date getEstDate() {
        // Example date string in EST
        String estDateString = "2023-01-01 12:34:56";

        // Create a SimpleDateFormat with the EST time zone
        SimpleDateFormat estFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        estFormat.setTimeZone(java.util.TimeZone.getTimeZone("America/New_York"));

        // Parse the date string to get the Date object
        try {
            return estFormat.parse(estDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static LocalDateTime convertEstDateToUtc(Date estDate) {
        // Convert Date to ZonedDateTime with the EST time zone
        ZonedDateTime estZonedDateTime = ZonedDateTime.ofInstant(estDate.toInstant(), ZoneId.of("America/New_York"));

        // Convert ZonedDateTime to LocalDateTime in UTC
        return estZonedDateTime.withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
    }
}
