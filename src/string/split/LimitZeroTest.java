package string.split;

//split​(String regex) 메서드 테스트
//split(String regex, int limit)에서 limit이 0인것과 동일
public class LimitZeroTest {

	public static void main(String[] args) {

		// 테스트1 - split(",")인 경우에 해당

		// 앞 부분의 empty string들은 항상 포함됨
		// String testString = ",1,2,3"; -> length 4
		// String testString = ",,1,2,3"; -> length 5

		// 마지막이 empty string인 경우 중간 empty string들은 포함되지 않음
		// String testString = "1,2,3,4,5,,"; -> length 5

		// 마지막이 empty string이 아닌 경우 중간 empty string들은 포함됨
		// String testString = "1,2,3,4,5,, "; -> length 7

		// 테스트2 - split("o")인 경우에 해당

		// String testString = "boo:and:foo";
		// -> "b" , "" , ":and:f" , 마지막이 empty라 foo의 중간은 포함되지 않음

		// String testString = "boo:and:foo ";
		// -> "b" , "" , ":and:f" , 마지막이 empty가 아니라서 중간들 포함됨 "" , " "

		String testString = "boo:and:foo ";

		// 테스트1
		// String[] results = testString.split(",");

		// 테스트2
		String[] results = testString.split("o");

		PrintUtil.printStringArray(results);
	}

}
