package stream;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class PeekMethod {

	public static void main(String[] args) {

		IntStream intStream = IntStream.of(1, 3, 5, 7, 9);

		IntConsumer intConsumer = i -> System.out.println(i);

		// Stream ���������� ����� �� peek�� �����
		IntStream peekStream = intStream.peek(intConsumer);

		System.out.println("sum(): " + peekStream.sum()); // peek�� ó���� ��������(���⼭�� sum())�� ����� �� ����ȴ�.
	}

}
