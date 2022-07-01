package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapMethod {

	public static void main(String[] args) {

		// @FunctionalInterface
		// public interface Function<T, R>�� Ȱ��
		// -> Stream<T> �� Stream<R>�� �����Ѵ�.

		// integerList�� 0~99�� 50���� ���� �� add
		List<Integer> integerList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			integerList.add((int) (Math.random() * 100));
		}

		System.out.println("List<Integer> ����Ʈ ���");
		integerList.forEach((i) -> System.out.print(i + ","));
		System.out.println();

		// Integer ��Ʈ�� ����
		Stream<Integer> integerStream = integerList.stream();
		
		// Integer ��ü�� �޾� String ��ü�� ����
		Function<Integer, String> integerToStringFunction = integer -> "����" + integer;

		Consumer<String> printStringConsumer = str -> System.out.print(str + ",");
		
		// Integer ��Ʈ���� �� Integer ������ ��ü�� stringToIntegerFunction�� ������ String ��Ʈ�� ����
		Stream<String> mappedToStringStream = integerStream.map(integerToStringFunction);
		// mappedToStringStream.forEach(printStringConsumer); //�߰� ������ ��� �ּ�
		// ó������������ closed ����
		
		Stream<String> sortedStream = mappedToStringStream.sorted();
		sortedStream.forEach(printStringConsumer);

	}

}

/*
 * public interface Stream<T> extends BaseStream<T, Stream<T>> { <R> Stream<R>
 * map(Function<? super T, ? extends R> mapper); }
 */

// Stream<T>.forEach ���� �������꿡 �ش�ȴ�. -> ����ϸ� Stream closed��