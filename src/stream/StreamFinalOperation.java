package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamFinalOperation {

	public static void main(String[] args) {
		
		OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
		int max = IntStream.of().max().orElse(0);
		IntStream.of(1, 3, 5, 7, 9).average().ifPresent(System.out::println);
	}

}
