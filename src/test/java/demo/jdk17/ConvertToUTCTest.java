package demo.jdk17;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class ConvertToUTCTest {

	@Test
	void testLocalToUtc() {
        // Get the current local time
        LocalDateTime localDateTime = LocalDateTime.now();

        // Get the local timezone
        ZoneId localZoneId = ZoneId.systemDefault();

        // Convert local time to UTC
        ZonedDateTime localDateTimeWithZone = ZonedDateTime.of(localDateTime, localZoneId);
        ZonedDateTime utcDateTime = localDateTimeWithZone.withZoneSameInstant(ZoneId.of("UTC"));

        // Format the UTC datetime as per desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedUTCDateTime = utcDateTime.format(formatter);
        String formattedESTDateTime = localDateTimeWithZone.format(formatter);

        // Print the converted UTC datetime
        System.out.println("Local Datetime: " + formattedESTDateTime);
        System.out.println("UTC Datetime: " + formattedUTCDateTime);


    }	
	
	@Test
	void testStringToTimestamp() {
		
		 // Your string timestamp
        String stringTimestamp = "2023-12-24T22:48:00";

        // Parse the string timestamp to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(stringTimestamp));

        // Convert LocalDateTime to Instant
        Instant instant = localDateTime.toInstant(java.time.ZoneOffset.UTC);

        // Convert Instant to Timestamp
        Timestamp utctimestamp = Timestamp.from(instant);

        System.out.println("String Timestamp: " + stringTimestamp);
        System.out.println("Converted Timestamp (Local Time Zone): " + utctimestamp);
        System.out.println("Converted Timestamp (UTC): " + utctimestamp.toInstant());


	}



}

// https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
