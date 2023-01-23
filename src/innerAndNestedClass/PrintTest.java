package innerAndNestedClass;

class PrintTest {
	public static void main(String[] args) {

		Hello hello = new Hello();

		Hello.Inner inner1 = hello.new Inner();
		System.out.println(inner1);

		Hello.Inner inner2 = hello.new Inner();
		System.out.println(inner2);

		Hello.StaticInner staticInner1 = new Hello.StaticInner();
		System.out.println(staticInner1);

		Hello.StaticInner staticInner2 = new Hello.StaticInner();
		System.out.println(staticInner2);

		Hello.InnerInterface innerInterfaceImple1 = new Hello.InnerInterface() {
		};
		System.out.println(innerInterfaceImple1);

		Hello.InnerInterface innerInterfaceImple2 = new Hello.InnerInterface() {
		};
		System.out.println(innerInterfaceImple2);

	}
}

class Hello {
	static class StaticInner {
	}

	class Inner {
	}

	interface InnerInterface {
	}

}
