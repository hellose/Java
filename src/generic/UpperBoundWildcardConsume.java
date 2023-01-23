package generic;

import java.util.ArrayList;

public class UpperBoundWildcardConsume {

	public static void main(String[] args) {

		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(10);
		integers.add(5);
		consumeItem(integers);
	}

	public static void consumeItem(ArrayList<? extends Number> upperBoundArrayList) {

		// Number 또는 Number의 조상 타입(여기서는 Object)으로는 consume가능
		Number number = upperBoundArrayList.get(0);
		for (Number item : upperBoundArrayList) {
			System.out.println(item.intValue());
		}
		System.out.println();
	}

	public static void consumeItem2(ArrayList<? extends B> upperBoundArrayList) {

		// B또는 B의 조상 타입으로는 consume가능
		for (int i = 0; i < upperBoundArrayList.size(); i++) {
			B b = upperBoundArrayList.get(i);
			A a = upperBoundArrayList.get(i);
			Object obj = upperBoundArrayList.get(i);
		}
	}

}
