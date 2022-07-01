package stream;

import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringStreamToIntStream {

	public static void main(String[] args) {
		Stream<String> stringStream = Stream.of("1", "12", "123", "1234", "12345");

		// string Stream�� �� string ��ü�� ���̸� ����
		ToIntFunction<String> stringToIntFunction = str -> str.length();

		// ���� Ÿ�� ��Ʈ���� ���� Ÿ�� ��Ʈ������ mapToInt(), mapToDouble(), mapToLong()
		// mapping�� primitive int ��Ʈ��
		IntStream intStream = stringStream.mapToInt(stringToIntFunction);

		IntConsumer intConsumer = i -> System.out.println(i);
		intStream.forEach(intConsumer);

	}

}
