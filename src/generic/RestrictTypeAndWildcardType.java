package generic;

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

class Box<T extends B> {
}

public class RestrictTypeAndWildcardType {

	public static void main(String[] args) {
		// 대입될 수 있는 타입을 제한
		//Box<A> box1; // class Box<T extends B> 만족 x
		Box<B> box2;
		Box<C> box3;
		Box<D> box4;

		// 상한 제한 와일드카드
		Box<B> box5 = new Box<B>();
		//test(box5); // 상한제한 와일드카드 Box<? extends C> 만족 x
		Box<C> box6 = new Box<C>();
		test(box6);
		Box<D> box7 = new Box<D>();
		test(box7);

	}

	// upperBoundArrayList에는 Box<C> 또는 Box<C의자손>만 대입이 가능하다.
	public static void test(Box<? extends C> upperBoundArrayList) {
	}

}
