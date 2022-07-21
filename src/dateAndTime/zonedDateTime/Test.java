package dateAndTime.zonedDateTime;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Test 프로그램 (나쁜 코드)

//api호출시 str에 utc0에 해당하는 시간이 뽑혀져서 시간이 맞지 않아 직접적으로 9시간을 더하는 plusHours(9)을 사용하였음
//api호출시 뽑히는 타임존이 변경되고 운영하는 서버의 타임존도 변경될 경우 수정하기 어려운 코드가 된다.
//-> Test2 프로그램으로 개선
public class Test {

	public static void main(String[] args) throws ParseException {
		// 현재 str은 utc+00:00에 해당하는 시간
		String str = "2022-06-07T08:23:21Z";
		System.out.println(convertTime(str));

	}

	private static String convertTime(String str) {

		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int dayOfMonth = Integer.parseInt(str.substring(8, 10));
		int hour = Integer.parseInt(str.substring(11, 13));
		int minute = Integer.parseInt(str.substring(14, 16));
		int second = Integer.parseInt(str.substring(17, 19));

		LocalDateTime src = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		// utc+09:00시간으로 변환
		LocalDateTime target = src.plusHours(9); // 유연한 코드가 되지 못하므로 Test2로 개선함

		DateTimeFormatter fomatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // 'yyyy-MM-ddThh:mm:ss' 형식
		return target.format(fomatter);
	}

}
