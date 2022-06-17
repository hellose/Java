package string;

public class StringFormatMethodTest {

	public static void main(String[] args) {

		double value = 0.9136848d;
		System.out.println("double 일반 출력: " + value);
		System.out.println();

		// 소수점 첫째자리에서 반올림 하여 정수로 표현
		System.out.println("%.0f: " + String.format("%.0f", value));

		// 소수점 두번째자리에서 반올림 하여 소수점 한번째자리까지 보여줌
		System.out.println("%.1f: " + String.format("%.1f", value));

		// 0으로 pending하여 출력함
		System.out.println("%.4f: " + String.format("%.15f", value));
	}

}