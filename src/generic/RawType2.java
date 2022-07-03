package generic;

import java.util.ArrayList;

public class RawType2 {

	public static void main(String[] args) {
		ArrayList rawType = new ArrayList();
		rawType.add(new Object());
		rawType.add("test");

		// 컴파일 에러 발생하지 않음
		ArrayList<String> stringType = rawType;

		// String item에서 String으로 형변환시 runtime 예외 발생
		for (String item : stringType) {
			System.out.println(item);
		}

	}

}
