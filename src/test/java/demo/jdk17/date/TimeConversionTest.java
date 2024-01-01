package demo.jdk17.date;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TimeConversionTest {

	public static Date dateFromUTC(Date date){
	    return new Date(date.getTime() + Calendar.getInstance().getTimeZone().getOffset(new Date().getTime()));
	}

	public static Date dateToUTC(Date date){
	    return new Date(date.getTime() - Calendar.getInstance().getTimeZone().getOffset(date.getTime()));
	}
	
	@Test
	void test_jdk8_localToGMT() {
		Date date = new Date();
		System.out.println(dateToUTC(date));
	}
	
	@Test
	void test_jdk8_gmttoLocalDate() {
		Date date = new Date();
		System.out.println(dateFromUTC(dateToUTC(date)));
	}

 

	@Test
	void test_jdk17_localToGMT() {

		Date date = new Date();
		OffsetDateTime offsetDateTime = date.toInstant().atOffset(ZoneOffset.UTC);
		System.out.println(offsetDateTime);

	}

}
