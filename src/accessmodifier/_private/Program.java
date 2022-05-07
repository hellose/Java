package accessmodifier._private;

public class Program {

	public static void main(String[] args) {
		Test t = new Test(10);
		Test t2 = new Test(t);
	}

}

class Test {
	private int i;

	Test(int i) {
		this.i = i;
	}

	Test(Test test) {
		// private

		// 자기 클래스인 Test클래스 내부에서 private 필드 참조 가능
		System.out.println(test.i);
		// 자기 클래스인 Test클래스 내부에서 private 메서드 호출 가능
		test.method(); //
		this.i = test.i;
	}

	private void method() {
		System.out.println("method() 호출");
	}

}