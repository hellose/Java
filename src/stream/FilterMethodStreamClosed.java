package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterMethodStreamClosed {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			stringList.add(i + "");
		}

		Stream<String> originalStream = stringList.stream();

		// Stream<T> filter(Predicate<? super T> predicate);
		Stream<String> filteredStream = originalStream.filter(str -> str.startsWith("1"));

		filteredStream.forEach(str -> System.out.print(str + ","));
		System.out.println();

		filteredStream.forEach(str -> System.out.print(str + ",")); // stream has already been operated upon or closed

	}
}
