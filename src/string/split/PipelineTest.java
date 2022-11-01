package string.split;

public class PipelineTest {
	public static void main(String[] args) {
		// |를 사용
		String testString = "1,2,3,4,5-6-7-8-9";
		String[] results = testString.split(",|-");
		PrintUtil.printStringArray(results);
	}
}
