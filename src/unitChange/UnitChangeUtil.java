package unitChange;

public class UnitChangeUtil {

	// 48~57 and 46
	// char '.' -> int 46
	// char '0' -> int 48
	// char '9' -> int 57

	// 체크해야할 String에 단위가 없으면 -1리턴, 단위에 해당하는 첫 문자 인덱스 리턴
	private static int firstUnitCharIndex(String needToCheck) {

		int unitIndex = -1;

		// 단위에 해당하는 첫 문자가 나오면 for문 탈출
		for (int i = 0; i < needToCheck.length(); i++) {

			int value = (int) needToCheck.charAt(i);

			if (((value >= 48) && (value <= 57)) || (value == 46)) {
				// 문자가 아닌 경우 pass
			} else {
				// 문자인 경우 현재 인덱스를 저장하고 반복문을 탈출
				unitIndex = i;
				break;
			}
		}

		return unitIndex;
	}

	// public static String changeUnit(String ch) {
	// }

}
