package unitChange;

public class UnitChangeUtil {

	public static void main(String[] args) {
		String test = "700m";
		System.out.println(changeUnitString(test, null));
		String test2 = "30191896Ki";
		System.out.println(changeUnitString(test2, Unit.GIBI_BYTE));
		System.out.println(changeUnitString(test2, Unit.MEBI_BYTE));
	}

	public static class CanNotParseUnitException extends Exception {
		public CanNotParseUnitException(String errorMessage) {
			super(errorMessage);
		}
	}

	public static enum Unit {

		BYTE("B"), KILO_BYTE("KB"), KIBI_BYTE("KiB"), MEGA_BYTE("MB"), MEBI_BYTE("MiB"), GIGA_BYTE("GB"),
		GIBI_BYTE("GiB"), LOWER_CASE_M("m");

		// 클라이언트 페이지에 보여줄 단위 문자 설정
		private String value;

		private Unit(String unit) {
			this.value = unit;
		}

		public String getValue() {
			return this.value;
		}
	}

	// 유닛이 m일때 계산
	private static double calculateLowerCaseM(double before) {
		return before / 1000.0d;
	}

	// @NotNull currentUnit, changedUnit
	private static double calculateGeneralUnit(double before, UnitChangeUtil.Unit currentUnit,
			UnitChangeUtil.Unit changedUnit) {

		if ((currentUnit == null) || (changedUnit == null)) {
			return before;
		}

		double twoPowerTen = 1024d; // 2^10
		double tenPowerThree = 1000d; // 10^3

		double whatByte = -1d;
		// 넘겨받은 값을 바이트 값으로 변환
		if (currentUnit.equals(Unit.MEBI_BYTE)) {
			whatByte = before * (Math.pow(twoPowerTen, 2.0));
		}
		if (currentUnit.equals(Unit.KIBI_BYTE)) {
			whatByte = before * twoPowerTen;
		}
		if (currentUnit.equals(Unit.GIBI_BYTE)) {
			whatByte = before * (Math.pow(twoPowerTen, 3.0));
		}
		if (currentUnit.equals(Unit.MEGA_BYTE)) {
			whatByte = before * (Math.pow(tenPowerThree, 2.0));
		}
		if (currentUnit.equals(Unit.KILO_BYTE)) {
			whatByte = before * tenPowerThree;
		}
		if (currentUnit.equals(Unit.GIGA_BYTE)) {
			whatByte = before * (Math.pow(tenPowerThree, 3.0));
		}

		double result = -1d;
		// 해당 바이트 값을 원하는 단위로 변환
		if (changedUnit.equals(Unit.MEBI_BYTE)) {
			result = whatByte / (Math.pow(twoPowerTen, 2.0));
		}
		if (changedUnit.equals(Unit.KIBI_BYTE)) {
			result = whatByte / twoPowerTen;
		}
		if (changedUnit.equals(Unit.GIBI_BYTE)) {
			result = whatByte / (Math.pow(twoPowerTen, 3.0));
		}
		if (changedUnit.equals(Unit.MEGA_BYTE)) {
			result = whatByte / (Math.pow(tenPowerThree, 2.0));
		}
		if (changedUnit.equals(Unit.KILO_BYTE)) {
			result = whatByte / tenPowerThree;
		}
		if (changedUnit.equals(Unit.GIGA_BYTE)) {
			result = whatByte / (Math.pow(tenPowerThree, 3.0));
		}

		return result;
	}

	// String에 단위가 존재하지 않으면 받은 스트링 그대로 리턴, 단위가 존재하면 해당 스트링으로 변환한다.
	// 인자 스트링에 단위가 없으면 boolean은 무시된다.
	// public static double changeUnitString(String beforeChanged,
	// UnitChangeUtil.Unit toBeChangedUnit) {
	public static String changeUnitString(String beforeChanged, UnitChangeUtil.Unit toBeChangedUnit) {

		// firstUnitCharIndex() - 스트링에 단위에 해당하는 첫 문자 인덱스 리턴 or 단위없으면 -1리턴
		int firstOccurence = firstUnitCharIndex(beforeChanged);
		if (firstOccurence == -1) {
			// 단위 문자가 포함되어 있지 않으면 전달된 beforeChanged 그대로 리턴
			return beforeChanged;
		}

		// beforeChanged에는 단위가 포함되어있음

		// 단위 스트링
		String unitString = beforeChanged.substring(firstOccurence);
		// 단위 제거된 값만 존재하는 스트링
		String unitRemovedString = beforeChanged.substring(0, firstOccurence);
		// 단위 계산전 double로 변환
		double beforeCalculated = Double.parseDouble(unitRemovedString);

		UnitChangeUtil.Unit parsedUnit;
		try {
			// checkUnit() - 단위 스트링의 단위를 체크
			parsedUnit = checkUnit(unitString);
		} catch (CanNotParseUnitException e) {
			// 다른 단위 추가 필요
			e.printStackTrace();
			return beforeChanged;
		}

		double afterCalculated;
		// cpu core 계산
		if (Unit.LOWER_CASE_M.equals(parsedUnit)) {
			afterCalculated = calculateLowerCaseM(beforeCalculated);
			return String.format("%.2f", afterCalculated);
		} else {
			// 이외의 값 계산
			if (toBeChangedUnit == null) {
				throw new IllegalArgumentException("changedUnitString method changedUnit argument is null");
			}
			afterCalculated = calculateGeneralUnit(beforeCalculated, parsedUnit, toBeChangedUnit);
			return String.format("%.2f", afterCalculated);
		}

	}

	// 문자열에 단위가 포함되어 있는지 체크한 후 단위가 포함되어있다면 단위에 해당하는 첫 문자의 인덱스를 리턴
	// 단위에 해당하는 문자가 없으면 -1리턴
	private static int firstUnitCharIndex(String needToCheck) {
		// 48~57 and 46
		// char '.' -> int 46
		// char '0' -> int 48
		// char '9' -> int 57
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

	// 단위 스트링에 해당하는 str이 어떠한 단위인지 체크
	private static UnitChangeUtil.Unit checkUnit(String str) throws CanNotParseUnitException {
		// 쿠버네티스 메비,키비,기비
		if (isLowerCaseM(str)) {
			return Unit.LOWER_CASE_M;
		} else if (isMebi(str)) {
			return Unit.MEBI_BYTE;
		} else if (isKibi(str)) {
			return Unit.KIBI_BYTE;
		} else if (isGibi(str)) {
			return Unit.GIBI_BYTE;
		} else if (isMega(str)) {
			return Unit.MEGA_BYTE;
		} else if (isKilo(str)) {
			return Unit.KILO_BYTE;
		} else if (isGiga(str)) {
			return Unit.GIGA_BYTE;
		}

		throw new CanNotParseUnitException("UnitChangeUtil's checkUnit method can\'t parse unit");
	}

	private static boolean isKilo(String str) {
		if (str.equalsIgnoreCase("K") || str.equalsIgnoreCase("KB")) {
			return true;
		}
		return false;
	}

	private static boolean isMega(String str) {
		if (str.equals("M") || str.equalsIgnoreCase("MB")) {
			return true;
		}
		return false;
	}

	private static boolean isGiga(String str) {
		if (str.equalsIgnoreCase("G") || str.equalsIgnoreCase("GB")) {
			return true;
		}
		return false;
	}

	private static boolean isKibi(String str) {
		if (str.equalsIgnoreCase("Ki") || str.equalsIgnoreCase("KiB")) {
			return true;
		}
		return false;
	}

	private static boolean isMebi(String str) {
		if (str.equalsIgnoreCase("Mi") || str.equalsIgnoreCase("MiB")) {
			return true;
		}
		return false;
	}

	private static boolean isGibi(String str) {
		if (str.equalsIgnoreCase("Gi") || str.equalsIgnoreCase("GiB")) {
			return true;
		}
		return false;
	}

	private static boolean isLowerCaseM(String str) {
		if (str.equals("m")) {
			return true;
		}
		return false;
	}

}