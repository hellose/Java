package dateAndTime.zonedDateTime;

import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Test3 {

	public static void main(String[] args) {
		// 하위 두개는 동일하게 ZonedDateTime 리턴
		// ZonedDateTime.of(LocalDateTime,ZoneId)
		// LocalDateTime.atZone(ZoneId)

		// 출처 https://www.daleseo.com/java8-zoned-date-time/
		ZonedDateTime seoul = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));
		System.out.println("Seoul =     " + seoul);

		ZonedDateTime utc = seoul.withZoneSameInstant(ZoneOffset.UTC);
		System.out.println("UTC =       " + utc);

		ZonedDateTime utc2 = seoul.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println("UTC2 =       " + utc2);

		ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
		System.out.println("London =    " + london);

		ZonedDateTime newYork = seoul.withZoneSameInstant(ZoneOffset.of("-0400"));
		System.out.println("NewYork =   " + newYork);

		ZonedDateTime vancouver = seoul.withZoneSameInstant(ZoneId.of("America/Vancouver"));
		System.out.println("Vancouver = " + vancouver);
	}

}
