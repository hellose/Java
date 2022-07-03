package generic;

import java.util.ArrayList;

public class UnboundWildcardRemoveItem {

	public static void main(String[] args) {

		ArrayList<Object> objects = new ArrayList<>();
		objects.add(new Object());
		objects.add(new Object());
		

		ArrayList<String> strings = new ArrayList<>();
		strings.add("가");
		strings.add("나");
		
	}

	public static void clearItem(ArrayList<?> unboundArrayList) {
		unboundArrayList.clear();
	}

}
