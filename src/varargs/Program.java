package varargs;

//인자를 전달하지 않으면 -> 사이즈가 0인 배열이 생성.
//인자를 null로 전달한 경우 -> null참조를 가진다.
//인자에는 배열 전달 가능
//인자에는 배열 타입을 열거해서 전달 가능
public class Program {

	public static void main(String[] args) {
		System.out.println("테스트- 인자를 전달하지 않은 경우");
		varArgTest();
		System.out.println();

		System.out.println("테스트- 인자에 null을 전달한 경우");
		varArgTest(null);
		System.out.println();

		System.out.println("테스트- 인자에 배열 변수 전달");
		String[] strArr = new String[2];
		varArgTest(strArr);
		System.out.println();

		System.out.println("테스트- 인자에 배열 타입을 열거하여 전달");
		varArgTest("test", "test2");
		System.out.println();

	}

	public static void varArgTest(String... strings) {
		System.out.println("인자 strings");
		if (strings != null) {
			System.out.println("not null");
			System.out.println("배열 사이즈: " + strings.length);
		} else {
			System.out.println("null");
		}
	}

}