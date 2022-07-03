package generic;

import java.util.ArrayList;

public class WildcardAssignment3 {

	public static void main(String[] args) {

		ArrayList<C> cList = new ArrayList<>();
		cList.add(new C());
		cList.add(new C());
		ArrayList<? extends B> lowerB = cList;
		for (B b : lowerB) {
			System.out.println(b);
		}
		System.out.println();

		ArrayList<D> dList = new ArrayList<>();
		dList.add(new D());
		dList.add(new D());
		ArrayList<? extends C> lowerC = dList;
		for (C c : lowerC) {
			System.out.println(c);
		}
		System.out.println();

		// 와일드 카드가 사용된 변수간의 대입

		// lowerB에는 ArrayList<B>가 대입될 수 있지만 lowerC에는 ArrayList<B>가 들어갈 수 없기 떄문에
		// -> lowerC = lowerB시 컴파일 에러

		lowerB = lowerC;
		for (B b : lowerB) {
			System.out.println(b);
		}
		System.out.println();

	}
}
