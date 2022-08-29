package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class ReflectionTest {

	public static void main(String[] args) {
	}

	// 테스트1 - Class 참조
	static void classTest() {
		try {
			// Class<?> clazz = Class.forName("reflection.Test");
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");
			Class<Test> clazz2 = Test.class;
			System.out.println(clazz == clazz2); // true
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 테스트2 - private 생성자 호출시 예외 발생
	static void privateConstructorTest() {
		try {
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");

			// private Test(String privateString) 생성자
			Constructor<Test> constructor = clazz.getDeclaredConstructor();
			constructor.newInstance();
			// private 생성자를 통해 인스턴스 생성 -> IllegalAccessException 발생

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테스트3 - 생성자를 통해 인스턴스 생성
	static void defaultConstructorTest() {
		try {
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");

			// Test(String privateString, String defaultString) 생성자
			Constructor<Test> constructor = clazz.getDeclaredConstructor(String.class, String.class);
			Test test = constructor.newInstance("private스트링", "default스트링");

			// 필드 출력 메서드를 통해 생성자가 제대로 호출되었는지 확인
			test.printField();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테스트4 - 메서드 호출
	static void methodTest() {
		try {
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");

			// Test() 생성자
			Constructor<Test> constructor = clazz.getDeclaredConstructor();
			Test test = constructor.newInstance();

			// setField(String,String,String)
			Method method = clazz.getDeclaredMethod("setField", String.class, String.class, String.class);
			// 호출시 객체를 넘겨야 한다.
			method.invoke(test, "가", "나", "다");

			// printField()
			Method method2 = clazz.getDeclaredMethod("printField");
			// 호출시 객체를 넘겨야 한다.
			method2.invoke(test);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테스트5 - 클래스에 선언된 모든 public 생성자
	static void publicConstructorTest() {
		try {
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");

			Constructor<Test>[] constructors = (Constructor<Test>[]) clazz.getConstructors();
			System.out.println("public 생성자 개수: " + constructors.length);
			System.out.println("생성자 정보");
			for (Constructor<Test> item : constructors) {
				System.out.println(item.toString());
			}

			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테스트6 - 클래스에 선언된 모든 생성자
	static void allConstructorTest() {
		try {
			Class<Test> clazz = (Class<Test>) Class.forName("reflection.Test");

			Constructor<Test>[] constructors = (Constructor<Test>[]) clazz.getDeclaredConstructors();
			System.out.println("모든 생성자 개수: " + constructors.length);
			System.out.println("생성자 정보");
			for (Constructor<Test> item : constructors) {
				System.out.println(item.toString());
			}

			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 디버깅 - 생성자 정보 출력
	static void printConstructorInfo(Constructor<?>[] constructors) {
		System.out.println("생성자 개수: " + constructors.length);
		for (Constructor<?> cons : constructors) {
			System.out.println("--- 생성자 정보 ---");
			// System.out.println(cons.toGenericString());
			System.out.println(cons.toString());
		}
	}

}

//reflection 테스트 클래스
class Test {

	private String privateString;
	String defaultString;
	public String publicstring;

	public Test() {

	}

	private Test(String privateString) {
		System.out.println("private Test(String privateString) constructor 생성자 호출");
		this.privateString = privateString;
	}

	Test(String privateString, String defaultString) {
		System.out.println("Test(String privateString, String defaultString) 생성자 호출");
		this.privateString = privateString;
		this.defaultString = defaultString;
	}

	public Test(String privateString, String defaultString, String publicString) {
		System.out.println("Test(String privateString, String defaultString, String publicString) 생성자 호출");
		this.privateString = privateString;
		this.defaultString = defaultString;
		this.publicstring = publicString;
	}

	private void privateMethod() {
		System.out.println("privateMethod() method");
	}

	void method() {
		System.out.println("method() method");
	}

	public void publicMethod() {
		System.out.println("publicMethod() method");
	}

	public void printField() {
		System.out.println("privateString: " + privateString);
		System.out.println("defaultString: " + defaultString);
		System.out.println("publicstring: " + publicstring);
	}

	public void setField(String str1, String str2, String str3) {
		this.privateString = str1;
		this.defaultString = str2;
		this.publicstring = str3;
	}
}
