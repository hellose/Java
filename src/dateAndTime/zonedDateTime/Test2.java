package dateAndTime.zonedDateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//시간 스트링을 제공해주는 서버에서 타임존이 변경되거나 운영서버의 타임존이 변경되면 각 타임존만 변경하면 된다.
public class Test2 {

	public static void main(String[] args) {
		String str = LocalDateTime.now().toString();
		// 뽑힌 String을 utc+00:00타임존으로 설정한 후 Asia/Seoul타임존에 해당하는 ZonedDateTime으로 변환
		// ZonedDateTime을 LocalDateTime으로 변환하여 타임존과 오프셋을 제거한다.
		String convertedString = test(str, "UTC", "Asia/Seoul");
	}

	public static String test(String str, String beforeZondId, String afterZoneId) {
		ZoneId zoneK8s = ZoneId.of(beforeZondId);
		ZoneId zoneDesti = ZoneId.of(afterZoneId);

		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int dayOfMonth = Integer.parseInt(str.substring(8, 10));
		int hour = Integer.parseInt(str.substring(11, 13));
		int minute = Integer.parseInt(str.substring(14, 16));
		int second = Integer.parseInt(str.substring(17, 19));

		LocalDateTime kuberLocalDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		System.out.println("LocalDateTime: " + kuberLocalDateTime);

		ZonedDateTime kubernetesZonedDateTime = ZonedDateTime.of(kuberLocalDateTime, zoneK8s);
		System.out.println(
				"LocalDateTime에 " + zoneK8s.toString() + "+00:00이 적용된 ZonedDateTime1: " + kubernetesZonedDateTime);

		// withZoneSameInstant()메서드
		ZonedDateTime convertedZonedDateTime = kubernetesZonedDateTime.withZoneSameInstant(zoneDesti);
		System.out.println("ZonedDateTime1을 " + zoneDesti.toString() + " 타임존 시간으로 변환: " + convertedZonedDateTime);

		LocalDateTime convertedLocalDateTime = convertedZonedDateTime.toLocalDateTime();
		System.out.println("타임존과 오프셋을 제거한 LocalDateTime: " + convertedLocalDateTime.toString());

		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ahh:mm:ss");
		System.out.println("ISO_LOCAL_DATE_TIME포맷 DateTimeFormatter로 String변환");
		String converted = convertedLocalDateTime.format(fomatter);
		System.out.println("포맷팅된 시간: " + converted);

		return converted;
	}
}
