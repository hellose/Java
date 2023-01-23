package innerInterface.syntax;

public class Clz {

	// public, private, protected, 생략한(default) 접근제한자 사용가능
	interface InnerInterface {
		// abstract static interface InnerInterface 와 동일
		public abstract void method();
	}

	public static void main(String[] args) {

		Clz.InnerInterface innerInterface = new Clz.InnerInterface() {
			@Override
			public void method() {
				System.out.println(this);
				System.out.println("클래스의 static inner 인터페이스 추상 메서드 구현");
			}
		};

		innerInterface.method();

		Clz.InnerInterface innerInterface2 = new Clz.InnerInterface() {
			@Override
			public void method() {
				System.out.println(this);
				System.out.println("클래스의 static inner 인터페이스 추상 메서드 구현");
			}
		};
		
		innerInterface2.method();

	}
}
