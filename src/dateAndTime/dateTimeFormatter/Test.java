package dateAndTime.dateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {

		LocalDateTime localNow = LocalDateTime.now();
		System.out.println(localNow);

		// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		// a -> 오전/오후
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ahh:mm:ss");
		System.out.println("custom 포맷팅: " + customFormatter.format(localNow));

		// 'yyyy-MM-ddThh:mm:ss' 형식
		DateTimeFormatter isoLocalDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		System.out.println("ISO_LOCAL_DATE_TIME: " + isoLocalDateTimeFormatter.format(localNow));
	}
}
