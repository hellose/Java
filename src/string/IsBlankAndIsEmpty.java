package string;

// isEmpty -> length가 0인 경우에만 true
// isBlank -> 1.공백 또는 2.whitespace만 포함하는 경우 true
public class IsBlankAndIsEmpty {
	public static void main(String[] args) {
		String emptyString = "";
		String blankString = "        ";

		System.out.println("emptyString.isEmpty(): " + emptyString.isEmpty());
		System.out.println("emptyString.isBlank(): " + emptyString.isBlank());
		System.out.println("blankString.isEmpty(): " + blankString.isEmpty());
		System.out.println("blankString.isBlank(): " + blankString.isBlank());
	}
}
