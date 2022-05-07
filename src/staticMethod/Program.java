package staticMethod;

public class Program {

	public static void main(String[] args) {
		Child.cMethod();
		Child.pMethod(); // 하위 클래스는 부모 메서드 사용 가능

		TestInterface.iMethod(); // 이것만 가능
		//TestInterfaceImpl.iMethod(); // 구현 클래스는 인터페이스 메서드 사용 불가능
		//new TestInterfaceImpl().iMethod(); // 불가능
		//((TestInterface) new TestInterfaceImpl()).iMethod(); // 불가능

		Class<TestInterface> clazz = TestInterface.class;
		System.out.println("TestInterface.class.isInterface(): " + clazz.isInterface());
	}

}

class Parent {
	static void pMethod() {
	}
}

class Child extends Parent {
	static void cMethod() {
	}
}

interface TestInterface {
	static void iMethod() {
	}
}

class TestInterfaceImpl implements TestInterface {
}