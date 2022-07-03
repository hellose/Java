package generic;

import java.util.ArrayList;

public class UnboundWildcardConsumeItem {

	public static void main(String[] args) {

		ArrayList<Object> objects = new ArrayList<>();
		objects.add(new Object());
		objects.add(new Object());
		consumeItem(objects);

		ArrayList<String> strings = new ArrayList<>();
		strings.add("가");
		strings.add("나");
		consumeItem(strings);

	}

	public static void consumeItem(ArrayList<?> unboundArrayList) {
		for (Object obj : unboundArrayList) {
			System.out.println(obj);
		}
		System.out.println();
	}

}
