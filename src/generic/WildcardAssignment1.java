package generic;

import java.util.ArrayList;

public class WildcardAssignment1 {

	public static void main(String[] args) {
		ArrayList<A> aList = new ArrayList<>();
		aList.add(new A());
		aList.add(new A());

		// 메서드의 인자로 넘어가는 것과 동일한 것이다.
		ArrayList<?> unbound = aList;
		// 컴파일 에러
		// unbound.add(new Object());

		for (Object item : unbound) {
			System.out.println(item);
		}

	}
}