package generic;

import java.util.ArrayList;

public class UpperBoundWildcardConsume {

	public static void main(String[] args) {

		ArrayList<Number> numbers = new ArrayList<>();
		numbers.add(1.1d);
		numbers.add(7);
		numbers.add(3.3f);
		consumeItem(numbers);

		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(10);
		integers.add(5);
		consumeItem(integers);
	}

	public static void consumeItem(ArrayList<? extends Number> upperBoundArrayList) {
		System.out.println("모두 int로 변환");

		for (Number item : upperBoundArrayList) {
			System.out.println(item.intValue());
		}
		System.out.println();
	}

}
