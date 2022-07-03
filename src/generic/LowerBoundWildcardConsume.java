package generic;

import java.util.ArrayList;

public class LowerBoundWildcardConsume {

	public static void main(String[] args) {

		ArrayList<Object> objList = new ArrayList<>();
		objList.add(new Object());
		objList.add(new A());
		consumeItem(objList);

		ArrayList<A> aList = new ArrayList<>();
		aList.add(new A());
		aList.add(new B());

		consumeItem(aList);

		ArrayList<B> bList = new ArrayList<>();
		bList.add(new B());
		bList.add(new C());
		consumeItem(bList);
	}

	public static void consumeItem(ArrayList<? super B> lowerBoundArrayList) {
		for (Object item : lowerBoundArrayList) {
			System.out.println(item);
		}
		System.out.println();
	}

}
