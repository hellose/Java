package stream;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamToStringStream {

	public static void main(String[] args) {
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

		// public interface IntFunction<R>{
		// R apply(int value);
		IntFunction intFunction = i -> String.valueOf(i);

		// ���� Ÿ�� ��Ʈ���� ���� Ÿ�� ��Ʈ������ mapToObj()
		Stream<String> stringStream = intStream.mapToObj(intFunction);

		List<String> stringList = stringStream.collect(Collectors.toList());
		stringList.forEach(System.out::println);
	}
}
