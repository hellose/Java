package millisecondtime;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

class Program {

	public static void main(String[] args) {

		// time in Millis
		Calendar cal = Calendar.getInstance();
		long timeInMillis = cal.getTimeInMillis();
		System.out.println(timeInMillis);

		LocalDateTime localDateTime = LocalDateTime.now();
		long timeInMillis2 = Timestamp.valueOf(localDateTime).getTime();
		System.out.println(timeInMillis2);

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);

	}

}
