package dateAndTime;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) throws ParseException {
		String str = "2022-06-07T08:23:21Z";
		System.out.println(convertCreationTimestamp(str));
	}

	private static String convertCreationTimestamp(String str) {

		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int dayOfMonth = Integer.parseInt(str.substring(8, 10));
		int hour = Integer.parseInt(str.substring(11, 13));
		int minute = Integer.parseInt(str.substring(14, 16));
		int second = Integer.parseInt(str.substring(17, 19));

		LocalDateTime src = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		LocalDateTime target = src.plusHours(9);

		DateTimeFormatter fomatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // 'YYYY-MM-DDTHH:MM:SS'
		return target.format(fomatter);
	}

}
