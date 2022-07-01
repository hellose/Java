package functionalInterface;

import java.util.ArrayList;
import java.util.List;

public class CollectionForEach {

	public static void main(String[] args) {

		System.out.println("1. Collection.forEach �׽�Ʈ");
		
		List<String> stringList = new ArrayList<>();
		stringList.add("java");
		stringList.add("c");
		stringList.add("javascript");
		stringList.add("python");
		stringList.add("go");
		stringList.add("kotlin");
		// Collection.forEach(Consumer)
		stringList.forEach(str -> System.out.println(str));
	}

}
