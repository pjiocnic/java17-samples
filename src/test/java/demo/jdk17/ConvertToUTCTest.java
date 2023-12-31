package demo.jdk17;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ConvertToUTCTest {
	
	@Test
	void testInstant() {
		Instant instant = Instant.now();  // Capture the current moment in UTC.
		System.out.println("instant: " + instant);	
		
        // Convert Instant to ET's LocalDateTime
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("localDateTime: " + localDateTime);	
		
        // Convert Instant to UTC's LocalDateTime
		LocalDateTime localDateTime2 = instant.atZone(ZoneId.of("UTC")).toLocalDateTime();		
		System.out.println("localDateTime2: " + localDateTime2);	
	}
	
	@Test
	void testMAXDttm() {
		ZonedDateTime zdt = ZonedDateTime.of(9999, 12, 31, 0, 0, 0, 0, ZoneOffset.UTC);
		Date endDt = Date.from(zdt.toInstant());
		System.out.println("endDt: " + endDt);
		
		LocalDateTime ldt = zdt.toLocalDateTime();
		System.out.println("ldt: " + ldt);
	}

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
	void testETToUTC() {
		
		// Eastern
		ZonedDateTime etZoned = ZonedDateTime.now();
		LocalDateTime etLocal = etZoned.toLocalDateTime();
		System.out.println("etZoned: " + etZoned);
		System.out.println("etLocal: " + etLocal);

		// UTC
		ZonedDateTime etInUTC = etZoned.withZoneSameInstant(ZoneId.of("UTC"));
		LocalDateTime etInUTCLocal = etZoned.toLocalDateTime();
		System.out.println("etInUTC: " + etInUTC);
		System.out.println("etInUTCLocal: " + etInUTCLocal);

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
