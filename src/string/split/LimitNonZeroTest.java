package string.split;

// limit == 0인 경우는 LimitZeroTest 클래스 참고
// split(String regex, int limit) 메서드 limit != 0인 경우 테스트

// limit가 0이 아닌 경우 앞 뒤 empty string 모두 포함됨

// 그중에서 
// 음수인 경우 짜를 수 있는만큼 다짜름
// 양수인 경우 최대 지정된 개수만큼의 배열 생성

public class LimitNonZeroTest {

	public static void main(String[] args) {

		// limit가 음수인 경우 -> 짜를 수 있는만큼 다 짜름
		// String testString = ",,1,2,3,,4,5,6,,";
		// String[] results = testString.split(",", -1);

		// limit가 양수인 경우 -> limit가 0인 경우
		String testString = ",,1,2,3,,4,5,6,7,,,,";
		String[] results = testString.split(",", 10);

		PrintUtil.printStringArray(results);
	}

}
