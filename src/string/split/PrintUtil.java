package string.split;

public class PrintUtil {

	public static void printStringArray(String[] results) {

		System.out.println("string array length: " + results.length);
		System.out.println();

		for (String item : results) {
			System.out.println("item 출력");
			System.out.println(item);
			System.out.println("length(): " + item.length());
			System.out.println("item.isEmpty(): " + item.isEmpty());
			System.out.println("item.isBlank(): " + item.isBlank());
			System.out.println();
		}
	}
}
