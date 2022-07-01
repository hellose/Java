package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ForEachMethod {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			stringList.add(i + "");
		}

		Stream<String> originalStream = stringList.stream();
		
		// void forEach(Consumer<? super T> action);
		originalStream.forEach(str -> System.out.print(str + ","));
	}

}
