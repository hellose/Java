package string.format;

public class StringFormatMethodTest {

	public static void main(String[] args) {

		// 1. %d : 10진수 정수 포맷

		System.out.println("=============== 정수 포맷 테스트 ===============");
		resultString(String.format("%d", 1));
		resultString(String.format("abc%dabc", 1));

		// %05d
		// %0의 0 : 채워질 문자
		// %05의 5 : 총 5자리를 만듬
		resultString(String.format("%05d", 1)); // 5(전체자릿수) - 1(1표현자릿수) -> 좌측 네 자리를 0으로 채움
		resultString(String.format("%05d", 12)); // 5(전체자릿수) - 2(12표현자릿수) -> 좌측 세 자리를 0으로 채움
		resultString(String.format("%05d_", 12)); // 다섯자리 + _표현 한자리 -> 총 6 자리
		resultString(String.format("_%05d_", 12)); // _표현 한자리 + 다섯자리 + _표현 한자리 -> 총 7 자리

		System.out.println("=============== 16진수 포맷 테스트 ===============");
		// 2. %x : 16진수 포맷

		System.out.println("포맷 오브젝트가 Integer타입인 경우");
		System.out.println("소문자인 경우 x");
		resultString(String.format("%x", 10));
		resultString(String.format("%x", 11));

		// %0옵션은 위에서 설명한 것과 동일
		resultString(String.format("%05x", 11));
		resultString(String.format("_%05x_", 11));

		System.out.println("대문자인 경우 X");
		// 대문자 X의 경우 스트링을 대문자로
		resultString(String.format("%X", 10));
		resultString(String.format("%X", 11));
		resultString(String.format("%05X", 11));
		resultString(String.format("_%05X_", 11));
		System.out.println();

		System.out.println("포맷 오브젝트가 byte타입인 경우");

		resultString(String.format("%x", (byte) 1));
		resultString(String.format("%x", (byte) 2));
		resultString(String.format("%x", (byte) 3));
		resultString(String.format("%x", (byte) 4));
		resultString(String.format("%x", (byte) 5));
		resultString(String.format("%x", (byte) 6));
		resultString(String.format("%x", (byte) 7));
		resultString(String.format("%x", (byte) 8));
		resultString(String.format("%x", (byte) 9));
		resultString(String.format("%x", (byte) 10));
		resultString(String.format("%x", (byte) 11));
		resultString(String.format("%x", (byte) 12));
		resultString(String.format("%x", (byte) 13));
		resultString(String.format("%x", (byte) 14));
		resultString(String.format("%x", (byte) 15));
		resultString(String.format("%x", (byte) 16));
		resultString(String.format("%x", (byte) 17));
		resultString(String.format("%x", (byte) 18));

		resultString(String.format("%02x", (byte) 8));
		resultString(String.format("%02x", (byte) 10));
		resultString(String.format("%02x", (byte) 15));
		resultString(String.format("%02X", (byte) 16));

		System.out.println("=============== 문자형 포맷 테스트 ===============");
		// 3. %s : 문자형 포맷
		resultString(String.format("%s", "one"));
		resultString(String.format("_%s_", "one"));
	}

	public static void resultString(String str) {
		System.out.println("123456789(자릿수 출력)");
		System.out.println(str);
		System.out.println();
	}

}